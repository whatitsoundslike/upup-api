package com.grapheople.domain.level.service;

import com.grapheople.domain.level.db.service.LevelDBService;
import com.grapheople.domain.level.vo.Level;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelDBService levelDBService;

    public Level addExp(Long userId, long exp) {
        var level = levelDBService.getOrCreateLevel(userId);
        var newExp = level.getAccumulatedExp() + exp;
        var newLevel = level.getLevel();
        while (newExp >= requiredExpForNextLevel(newLevel)) {
            newExp -= requiredExpForNextLevel(newLevel);
            newLevel++;
        }
        level.setLevel(newLevel);
        level.setAccumulatedExp(newExp);
        return levelDBService.update(level);
    }

    public Long requiredExpForNextLevel(int currentLevel) {
        double exponent = 1.5; // Adjust the exponent to change the growth rate
        double baseExp = 20; // Base experience required for level 1
        return Math.round(baseExp * Math.pow(currentLevel, exponent));
    }

    public Integer getLevelFromExp(Long currentAccumulatedExp) {
        int level = 1;
        long accumulatedExp = 0;
        while (true) {
            long requiredExp = requiredExpForNextLevel(level);
            if (accumulatedExp + requiredExp > currentAccumulatedExp) {
                break;
            }
            accumulatedExp += requiredExp;
            level++;
        }
        return level;
    }
}
