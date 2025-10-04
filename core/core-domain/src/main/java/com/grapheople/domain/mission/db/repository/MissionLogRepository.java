package com.grapheople.domain.mission.db.repository;

import com.grapheople.domain.mission.db.entity.MissionLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionLogRepository extends JpaRepository<MissionLogEntity, Long> {
}
