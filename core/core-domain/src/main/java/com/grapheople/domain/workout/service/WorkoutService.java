package com.grapheople.domain.workout.service;

import com.grapheople.domain.workout.db.entity.WorkoutLogEntity;
import com.grapheople.domain.workout.db.service.WorkoutDBService;
import com.grapheople.domain.workout.db.service.WorkoutLogDBService;
import com.grapheople.domain.workout.vo.Workout;
import com.grapheople.domain.workout.vo.WorkoutLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutDBService workoutDBService;
    private final WorkoutLogDBService workoutLogDBService;

    public WorkoutLog logWorkout(WorkoutLog log) {
        WorkoutLogEntity workoutLogEntity = workoutLogDBService.save(log);
        return WorkoutLog.of(workoutLogEntity);
    }

    public List<WorkoutLog> getWorkoutLogsByUserId(Long userId) {
        List<WorkoutLogEntity> workoutLogEntities = workoutLogDBService.findByUserId(userId);
        return workoutLogEntities.stream().map(WorkoutLog::of).toList();
    }
}
