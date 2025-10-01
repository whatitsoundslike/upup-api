package com.grapheople.domain.workout.db.entity;


import com.grapheople.domain.common.entity.BaseEntity;
import com.grapheople.domain.workout.enums.WorkoutType;
import com.grapheople.domain.workout.vo.Workout;
import com.grapheople.domain.workout.vo.WorkoutLog;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "workouts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutEntity extends BaseEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private WorkoutType workoutType;

    public static WorkoutEntity from(Workout workout) {
        return WorkoutEntity.builder()
                .name(workout.getName())
                .workoutType(workout.getWorkoutType())
                .build();
    }
}
