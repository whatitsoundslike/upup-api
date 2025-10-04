package com.grapheople.domain.mission.db.entity;

import com.grapheople.domain.common.entity.BaseEntity;
import com.grapheople.domain.mission.vo.MissionLog;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mission_logs", indexes = {
        @Index(name = "idx_user_id_complete_date", columnList = "userId, completeDate")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_id_mission_id_complete_date", columnNames = {"userId", "missionId", "completeDate"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionLogEntity extends BaseEntity {
    private Long userId;
    private Long missionId;
    private LocalDate completeDate;

    public static MissionLogEntity from(MissionLog missionLog) {
        return MissionLogEntity.builder()
                .userId(missionLog.getUserId())
                .missionId(missionLog.getMissionId())
                .completeDate(missionLog.getCompleteDate())
                .build();
    }
}
