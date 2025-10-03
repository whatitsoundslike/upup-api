package com.grapheople.domain.level.db.repository;

import com.grapheople.domain.level.db.entity.ExpLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpLogRepository extends JpaRepository<ExpLogEntity, Long> {
}
