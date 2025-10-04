package com.grapheople.domain.mission.db.repository;

import com.grapheople.domain.mission.db.entity.MissionEntity;
import com.grapheople.domain.mission.enums.MissionPeriodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<MissionEntity, Long> {
    List<MissionEntity> findByMissionPeriodType(MissionPeriodType missionPeriodType);
}
