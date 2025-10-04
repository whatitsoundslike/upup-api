package com.grapheople.domain.mission.vo;

import com.grapheople.domain.mission.db.entity.MissionEntity;
import com.grapheople.domain.mission.db.entity.MissionLogEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MissionLog {
    private Long userId;
    private Long missionId;
    private LocalDate completeDate;

    public static MissionLog of(MissionLogEntity missionLogEntity) {
        return MissionLog.builder()
                .userId(missionLogEntity.getUserId())
                .missionId(missionLogEntity.getMissionId())
                .completeDate(missionLogEntity.getCompleteDate())
                .build();
    }
}
