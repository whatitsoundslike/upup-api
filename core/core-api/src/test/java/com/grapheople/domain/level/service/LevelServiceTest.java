package com.grapheople.domain.level.service;

import com.grapheople.domain.level.db.service.LevelDBService;
import com.grapheople.domain.level.vo.Level;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class LevelServiceTest {

    @Mock
    private LevelDBService levelDBService;

    @InjectMocks
    private LevelService levelService;

    @Test
    void addExp_whenGainCoversMultipleLevels_updatesLevelAndRemainingExp() {
        var level = new Level();
        level.setUserId(1L);
        level.setLevel(1);
        level.setAccumulatedExp(0L);

        when(levelDBService.getOrCreateLevel(1L)).thenReturn(level);


        levelService.addExp(1L, 100L);

        ArgumentCaptor<Level> captor = ArgumentCaptor.forClass(Level.class);
        verify(levelDBService).update(captor.capture());

        Level updatedLevel = captor.getValue();
        assertThat(updatedLevel.getLevel()).isEqualTo(3);
        assertThat(updatedLevel.getAccumulatedExp()).isEqualTo(23L);
    }

    @Test
    void requiredExpForNextLevel_returnsRoundedGrowthProjection() {
        assertThat(levelService.requiredExpForNextLevel(1)).isEqualTo(20L);
        assertThat(levelService.requiredExpForNextLevel(2)).isEqualTo(57L);
        assertThat(levelService.requiredExpForNextLevel(3)).isEqualTo(104L);
    }
}
