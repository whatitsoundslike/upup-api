package com.grapheople.api.controller.v1;

import com.grapheople.api.support.response.ApiResponse;
import com.grapheople.domain.level.db.service.ExpLogDBService;
import com.grapheople.domain.level.enums.ExpGainType;
import com.grapheople.domain.level.service.LevelService;
import com.grapheople.domain.level.service.WorkoutLogExpCalculator;
import com.grapheople.domain.level.vo.ExpEvent;
import com.grapheople.domain.level.vo.Level;
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
    private final ExpLogDBService expLogDBService;
    private final WorkoutService workoutService;
    private final LevelService levelService;
    private final WorkoutLogExpCalculator workoutLogExpCalculator;

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
        Long userId = 1L;

        workoutLog.setUserId(userId);
        WorkoutLog createdWorkoutLog = workoutService.logWorkout(workoutLog);
        long expGained = workoutLogExpCalculator.calculateExp(new ExpEvent<>(userId, ExpGainType.WORKOUT_COMPLETE, createdWorkoutLog));
        levelService.addExp(userId, expGained);
        expLogDBService.save(userId, ExpGainType.WORKOUT_COMPLETE, createdWorkoutLog.getId(), expGained);
        return ApiResponse.success(createdWorkoutLog);
    }

    @GetMapping("/api/v1/workout-logs")
    public ApiResponse<List<WorkoutLog>> getWorkoutLogsByUserId() {
        Long testUserId = 1L;
        return ApiResponse.success(workoutService.getWorkoutLogsByUserId(testUserId));
    }

}
