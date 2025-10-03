package com.grapheople.domain.workout.vo;

import com.grapheople.domain.workout.db.entity.WorkoutLogEntity;
import com.grapheople.domain.workout.enums.WorkoutType;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class WorkoutLog {
    private Long id;
    private String uuid;
    private Long userId;
    private Long workoutId;
    private WorkoutType workoutType;
    private String workoutName;
    private Integer steps;
    private Integer durationSec;
    private Integer distanceMeter;
    private Integer calorie;
    private Integer exp;

    private Instant exerciseAt;
    private LocalDate exerciseDate;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public static WorkoutLog of(WorkoutLogEntity workoutLogEntity) {
        return WorkoutLog.builder()
                .id(workoutLogEntity.getId())
                .uuid(workoutLogEntity.getUuid())
                .userId(workoutLogEntity.getUserId())
                .workoutId(workoutLogEntity.getWorkoutId())
                .workoutType(workoutLogEntity.getWorkoutType())
                .workoutName(workoutLogEntity.getWorkoutName())
                .steps(workoutLogEntity.getSteps())
                .durationSec(workoutLogEntity.getDurationSec())
                .distanceMeter(workoutLogEntity.getDistanceMeter())
                .calorie(workoutLogEntity.getCalorie())
                .exp(workoutLogEntity.getExp())
                .exerciseAt(workoutLogEntity.getExerciseAt())
                .exerciseDate(workoutLogEntity.getExerciseDate())
                .startAt(workoutLogEntity.getStartAt())
                .endAt(workoutLogEntity.getEndAt())
                .build();
    }
}
