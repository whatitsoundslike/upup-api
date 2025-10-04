package com.grapheople.domain.mission.db.service;

import com.grapheople.domain.mission.db.entity.MissionEntity;
import com.grapheople.domain.mission.db.repository.MissionRepository;
import com.grapheople.domain.mission.enums.MissionPeriodType;
import com.grapheople.domain.mission.vo.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionDBService {
    private final MissionRepository missionRepository;

    public Mission createMission(Mission mission) {
        return Mission.of(missionRepository.save(MissionEntity.from(mission)));
    }

    public List<Mission> getMissionsByPeriodType(MissionPeriodType periodType) {
        return missionRepository.findByMissionPeriodType(periodType).stream().map(Mission::of).toList();
    }
}
