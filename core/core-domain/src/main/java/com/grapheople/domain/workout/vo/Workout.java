package com.grapheople.domain.workout.vo;

import com.grapheople.domain.workout.db.entity.WorkoutEntity;
import com.grapheople.domain.workout.enums.WorkoutType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Workout {
    private Long id;
    private String name;
    private WorkoutType workoutType;

    public static Workout from(WorkoutEntity workoutEntity) {
        return Workout.builder()
                .id(workoutEntity.getId())
                .name(workoutEntity.getName())
                .workoutType(workoutEntity.getWorkoutType())
                .build();
    }
}
