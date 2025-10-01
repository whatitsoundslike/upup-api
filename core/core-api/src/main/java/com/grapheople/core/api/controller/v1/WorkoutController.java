package com.grapheople.core.api.controller.v1;

import com.grapheople.core.api.controller.v1.response.WorkoutResponse;
import com.grapheople.core.support.response.ApiResponse;
import com.grapheople.domain.workout.db.repository.WorkoutRepository;
import com.grapheople.domain.workout.db.service.WorkoutDBService;
import com.grapheople.domain.workout.vo.Workout;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutDBService workoutDBService;

    @GetMapping("/api/v1/workouts/{id}")
    public ApiResponse<Workout> getWorkout(@PathVariable Long id) {
        Workout workout = workoutDBService.findById(id);
        return ApiResponse.success(workout);
    }

    @PostMapping("/api/v1/workouts")
    public ApiResponse<Workout> createWorkout(@RequestBody Workout workout) {
        Workout createdWorkout = workoutDBService.save(workout);
        return ApiResponse.success(createdWorkout);
    }
}
