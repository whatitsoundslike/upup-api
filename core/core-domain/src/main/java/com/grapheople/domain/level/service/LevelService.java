package com.grapheople.domain.level.service;

import com.grapheople.domain.level.db.service.LevelDBService;
import com.grapheople.domain.level.db.entity.LevelEntity;
import com.grapheople.domain.level.vo.Level;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelDBService levelDBService;

    @Transactional
    public Level addExp(Long userId, long exp) {
        if (exp <= 0) {
            throw new IllegalArgumentException("Exp to add must be positive");
        }
        LevelEntity levelEntity = levelDBService.getOrCreateLevelForUpdate(userId);
        if (levelEntity.getLevel() == null || levelEntity.getLevel() < 1) {
            levelEntity.setLevel(1);
        }

        long currentExp = levelEntity.getAccumulatedExp() + exp;

        long requiredExpForCurrentLevel = requiredExpForNextLevel(levelEntity.getLevel() + 1);

        if (currentExp >= requiredExpForCurrentLevel) {
            levelEntity.setLevel(getLevelFromExp(currentExp));
        }

        levelEntity.setAccumulatedExp(currentExp);
        return levelDBService.save(levelEntity);
    }

    public long requiredExpForNextLevel(int currentLevel) {
        double exponent = 1.5; // Adjust the exponent to change the growth rate
        double baseExp = 20; // Base experience required for level 1
        return Math.round(baseExp * Math.pow(currentLevel, exponent));
    }

    public int getLevelFromExp(long currentExp) {
        double exponent = 1.5; // Adjust the exponent to change the growth rate
        double baseExp = 20; // Base experience required for level 1
        return (int) Math.floor(Math.pow(currentExp / baseExp, 1 / exponent));
    }
}
