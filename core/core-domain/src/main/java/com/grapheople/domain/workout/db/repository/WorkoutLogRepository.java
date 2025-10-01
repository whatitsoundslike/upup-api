package com.grapheople.domain.workout.db.repository;

import com.grapheople.domain.workout.db.entity.WorkoutLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutLogRepository extends JpaRepository<WorkoutLogEntity, Long> {
    List<WorkoutLogEntity> findByUserId(Long userId);
}
