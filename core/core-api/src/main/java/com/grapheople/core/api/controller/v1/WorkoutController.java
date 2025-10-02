package com.grapheople.core.api.controller.v1;

import com.grapheople.core.api.controller.v1.response.WorkoutResponse;
import com.grapheople.core.support.response.ApiResponse;
import com.grapheople.domain.workout.db.repository.WorkoutRepository;
import com.grapheople.domain.workout.db.service.WorkoutDBService;
import com.grapheople.domain.workout.service.WorkoutService;
import com.grapheople.domain.workout.vo.Workout;
import com.grapheople.domain.workout.vo.WorkoutLog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutDBService workoutDBService;
    private final WorkoutService workoutService;

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

    @PostMapping("/api/v1/workout-logs")
    public ApiResponse<WorkoutLog> createWorkoutLog(@RequestBody WorkoutLog workoutLog) {
        Long testUserId = 1L;
        workoutLog.setUserId(testUserId);
        WorkoutLog createdWorkoutLog = workoutService.logWorkout(workoutLog);
        return ApiResponse.success(createdWorkoutLog);
    }

    @GetMapping("/api/v1/workout-logs")
    public ApiResponse<List<WorkoutLog>> getWorkoutLogsByUserId() {
        Long testUserId = 1L;
        return ApiResponse.success(workoutService.getWorkoutLogsByUserId(testUserId));
    }

}
