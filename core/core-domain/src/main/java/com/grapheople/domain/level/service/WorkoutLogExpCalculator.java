package com.grapheople.domain.level.service;

import com.grapheople.domain.level.vo.ExpEvent;
import com.grapheople.domain.workout.vo.WorkoutLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkoutLogExpCalculator implements ExpCalculator<WorkoutLog> {

    @Override
    public long calculateExp(ExpEvent<WorkoutLog> expEvent) {
        WorkoutLog workoutLog = expEvent.getPayload();

        switch (workoutLog.getWorkoutType()) {
            case RUNNING, HIKING -> {
                return workoutLog.getDurationSec()/60;
            }
            case CYCLING -> {
                return workoutLog.getDistanceMeter()/1000;
            }
            case WALKING -> {
                return workoutLog.getSteps()/1000;
            }
            default -> {
                return 0;
            }
        }
    }
}
