package com.grapheople.domain.level.vo;

import com.grapheople.domain.level.db.entity.LevelEntity;
import lombok.Data;

@Data
public class Level {
    private Long userId;
    private Integer level;
    private Long accumulatedExp;

    public static Level from(LevelEntity entity) {
        Level level = new Level();
        level.setUserId(entity.getUserId());
        level.setLevel(entity.getLevel());
        level.setAccumulatedExp(entity.getAccumulatedExp());
        return level;
    }
}
