package com.grapheople.domain.workout.db.service;

import com.grapheople.domain.workout.db.entity.WorkoutLogEntity;
import com.grapheople.domain.workout.db.repository.WorkoutLogRepository;
import com.grapheople.domain.workout.db.repository.WorkoutRepository;
import com.grapheople.domain.workout.vo.WorkoutLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutLogDBService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutLogRepository workoutLogRepository;

    public List<WorkoutLogEntity> findByUserId(Long userId) {
        return workoutLogRepository.findByUserId(userId);
    }

    public WorkoutLogEntity save(WorkoutLog workoutLog) {
        WorkoutLogEntity workoutLogEntity = WorkoutLogEntity.from(workoutLog);
        return workoutLogRepository.save(workoutLogEntity);
    }

    public void delete(WorkoutLog workoutLog) {
        WorkoutLogEntity workoutLogEntity = WorkoutLogEntity.from(workoutLog);
        workoutLogRepository.delete(workoutLogEntity);
    }
}
