package com.grapheople.domain.workout.service;

import com.grapheople.domain.workout.db.service.WorkoutDBService;
import com.grapheople.domain.workout.vo.Workout;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutDBService workoutDBService;

}
