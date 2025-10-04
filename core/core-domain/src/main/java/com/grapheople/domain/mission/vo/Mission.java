package com.grapheople.domain.mission.vo;

import com.grapheople.domain.mission.db.entity.MissionEntity;
import com.grapheople.domain.mission.enums.MissionActionType;
import com.grapheople.domain.mission.enums.MissionPeriodType;
import com.grapheople.domain.mission.enums.MissionRewardType;
import com.grapheople.domain.workout.enums.WorkoutType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mission {
    private String titleFormat;
    private Integer goal;
    private MissionPeriodType missionPeriodType;
    private MissionActionType missionActionType;
    private MissionRewardType missionRewardType;
    private WorkoutType workoutType;

    public static Mission of(MissionEntity mission) {
        return Mission.builder()
                .titleFormat(mission.getTitleFormat())
                .goal(mission.getGoal())
                .missionPeriodType(mission.getMissionPeriodType())
                .missionActionType(mission.getMissionActionType())
                .missionRewardType(mission.getMissionRewardType())
                .workoutType(mission.getWorkoutType())
                .build();
    }
}
