package com.grapheople.domain.level.db.service;

import com.grapheople.domain.level.db.entity.LevelEntity;
import com.grapheople.domain.level.db.repository.LevelRepository;
import com.grapheople.domain.level.vo.Level;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelDBService {
    private final LevelRepository levelRepository;

    public Level getOrCreateLevel(Long userId) {
        LevelEntity levelEntity = levelRepository.findByUserId(userId).orElseGet(() -> create(userId));
        return Level.from(levelEntity);
    }

    public LevelEntity getOrCreateLevelForUpdate(Long userId) {
        return levelRepository.findByUserIdForUpdate(userId).orElseGet(() -> create(userId));
    }

    public LevelEntity create(Long userId) {
        LevelEntity levelEntity = LevelEntity.builder()
                .userId(userId)
                .level(1)
                .accumulatedExp(0L)
                .build();
        return levelRepository.save(levelEntity);
    }

    public Level save(LevelEntity levelEntity) {
        LevelEntity updatedEntity = levelRepository.save(levelEntity);
        return Level.from(updatedEntity);
    }
}
