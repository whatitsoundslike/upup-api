package com.grapheople.domain.mission.db.entity;

import com.grapheople.domain.common.entity.BaseEntity;
import com.grapheople.domain.mission.enums.MissionActionType;
import com.grapheople.domain.mission.enums.MissionPeriodType;
import com.grapheople.domain.mission.enums.MissionRewardType;
import com.grapheople.domain.mission.vo.Mission;
import com.grapheople.domain.workout.enums.WorkoutType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "missions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionEntity extends BaseEntity {
    private String titleFormat;
    private Integer goal;

    @Enumerated(EnumType.STRING)
    private MissionPeriodType missionPeriodType;

    @Enumerated(EnumType.STRING)
    private MissionActionType missionActionType;

    @Enumerated(EnumType.STRING)
    private MissionRewardType missionRewardType;

    @Enumerated(EnumType.STRING)
    private WorkoutType workoutType;

    public static MissionEntity from(Mission mission) {
        return MissionEntity.builder()
                .titleFormat(mission.getTitleFormat())
                .goal(mission.getGoal())
                .missionPeriodType(mission.getMissionPeriodType())
                .missionActionType(mission.getMissionActionType())
                .missionRewardType(mission.getMissionRewardType())
                .workoutType(mission.getWorkoutType())
                .build();
    }
}
