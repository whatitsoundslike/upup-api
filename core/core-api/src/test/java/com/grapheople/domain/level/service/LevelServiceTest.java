package com.grapheople.domain.level.service;

import com.grapheople.domain.level.db.entity.LevelEntity;
import com.grapheople.domain.level.db.service.LevelDBService;
import com.grapheople.domain.level.vo.Level;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LevelServiceTest {

    @Mock
    private LevelDBService levelDBService;

    @InjectMocks
    private LevelService levelService;

    @Test
    void addExpThrowsWhenExpIsNotPositive() {
        assertThatThrownBy(() -> levelService.addExp(1L, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Exp to add must be positive");
        verifyNoInteractions(levelDBService);
    }

    @Test
    void addExpInitializesLevelAndAccumulatesExperience() {
        Long userId = 1L;
        LevelEntity levelEntity = LevelEntity.builder()
                .userId(userId)
                .level(0)
                .accumulatedExp(5L)
                .version(1L)
                .build();

        when(levelDBService.getOrCreateLevelForUpdate(userId)).thenReturn(levelEntity);
        when(levelDBService.save(any(LevelEntity.class))).thenAnswer(invocation -> Level.from(invocation.getArgument(0)));

        Level level = levelService.addExp(userId, 10L);

        ArgumentCaptor<LevelEntity> levelEntityCaptor = ArgumentCaptor.forClass(LevelEntity.class);
        verify(levelDBService).save(levelEntityCaptor.capture());

        LevelEntity savedEntity = levelEntityCaptor.getValue();
        assertThat(savedEntity.getLevel()).isEqualTo(1);
        assertThat(savedEntity.getAccumulatedExp()).isEqualTo(15L);

        assertThat(level.getUserId()).isEqualTo(userId);
        assertThat(level.getLevel()).isEqualTo(1);
        assertThat(level.getAccumulatedExp()).isEqualTo(15L);
    }

    @Test
    void addExpLevelsUpWhenThresholdIsReached() {
        Long userId = 2L;
        LevelEntity levelEntity = LevelEntity.builder()
                .userId(userId)
                .level(1)
                .accumulatedExp(50L)
                .version(3L)
                .build();

        when(levelDBService.getOrCreateLevelForUpdate(userId)).thenReturn(levelEntity);
        when(levelDBService.save(any(LevelEntity.class))).thenAnswer(invocation -> Level.from(invocation.getArgument(0)));

        Level level = levelService.addExp(userId, 20L);

        assertThat(levelEntity.getAccumulatedExp()).isEqualTo(70L);
        assertThat(levelEntity.getLevel()).isEqualTo(2);

        assertThat(level.getUserId()).isEqualTo(userId);
        assertThat(level.getLevel()).isEqualTo(2);
        assertThat(level.getAccumulatedExp()).isEqualTo(70L);

        verify(levelDBService).save(levelEntity);
    }

    @Test
    void requiredExpForNextLevelUsesGrowthCurve() {
        assertThat(levelService.requiredExpForNextLevel(1)).isEqualTo(20L);
        assertThat(levelService.requiredExpForNextLevel(2)).isEqualTo(57L);
        assertThat(levelService.requiredExpForNextLevel(3)).isEqualTo(104L);
    }

    @Test
    void getLevelFromExpCalculatesLevelFromExperience() {
        assertThat(levelService.getLevelFromExp(0)).isEqualTo(0);
        assertThat(levelService.getLevelFromExp(20)).isEqualTo(1);
        assertThat(levelService.getLevelFromExp(80)).isEqualTo(2);
    }
}
