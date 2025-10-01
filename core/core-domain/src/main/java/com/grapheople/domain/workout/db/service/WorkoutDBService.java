package com.grapheople.domain.workout.db.service;

import com.grapheople.domain.workout.db.entity.WorkoutEntity;
import com.grapheople.domain.workout.db.entity.WorkoutLogEntity;
import com.grapheople.domain.workout.db.repository.WorkoutLogRepository;
import com.grapheople.domain.workout.db.repository.WorkoutRepository;
import com.grapheople.domain.workout.vo.Workout;
import com.grapheople.domain.workout.vo.WorkoutLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutDBService {
    private final WorkoutRepository workoutRepository;

    public Workout findById(Long id) {
        WorkoutEntity workoutEntity = workoutRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Workout not found with id: " + id));
        return Workout.from(workoutEntity);
    }

    public Workout save(Workout workout) {
        WorkoutEntity workoutEntity = WorkoutEntity.from(workout);
        WorkoutEntity savedEntity = workoutRepository.save(workoutEntity);
        return Workout.from(savedEntity);
    }

    public Workout update(Workout workout) {
        if (workout.getId() == null) {
            throw new IllegalArgumentException("Workout ID must not be null for update.");
        }
        WorkoutEntity workoutEntity = workoutRepository.findById(workout.getId()).orElseThrow(() -> new IllegalArgumentException("Workout not found with id: " + workout.getId()));
        WorkoutEntity updatedEntity = workoutRepository.save(workoutEntity);
        return Workout.from(updatedEntity);
    }

    public void deleteById(Long id) {
        workoutRepository.deleteById(id);
    }
}
