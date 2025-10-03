package com.grapheople.api.controller.v1.response;


import com.grapheople.domain.workout.enums.WorkoutType;
import lombok.Data;

@Data
public class WorkoutResponse {
    private Long id;
    private String name;
    private WorkoutType workoutType;
}
