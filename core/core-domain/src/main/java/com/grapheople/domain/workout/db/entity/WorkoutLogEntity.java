package com.grapheople.domain.workout.db.entity;

import com.grapheople.domain.common.entity.BaseEntity;
import com.grapheople.domain.workout.vo.WorkoutLog;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "workout_logs" , indexes = {
        @Index(name = "idx_user_id", columnList = "userId"),
        @Index(name = "idx_exercise_date", columnList = "exerciseDate")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutLogEntity extends BaseEntity {
    private Long userId;
    private Long workoutId;
    private String workoutName;
    private Integer durationSec;
    private Integer distanceMeter;
    private Integer calorie;
    private Integer exp;

    private Instant exerciseAt;
    private LocalDate exerciseDate;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public static WorkoutLogEntity from(WorkoutLog workoutLog) {
        return WorkoutLogEntity.builder()
                .userId(workoutLog.getUserId())
                .workoutId(workoutLog.getWorkoutId())
                .workoutName(workoutLog.getWorkoutName())
                .durationSec(workoutLog.getDurationSec())
                .distanceMeter(workoutLog.getDistanceMeter())
                .calorie(workoutLog.getCalorie())
                .exp(workoutLog.getExp())
                .exerciseAt(workoutLog.getExerciseAt())
                .exerciseDate(workoutLog.getExerciseDate())
                .startAt(workoutLog.getStartAt())
                .endAt(workoutLog.getEndAt())
                .build();
    }
}
