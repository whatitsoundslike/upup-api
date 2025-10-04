package com.grapheople.domain.mission.service;

import com.grapheople.domain.mission.db.service.MissionDBService;
import com.grapheople.domain.mission.db.service.MissionLogDBService;
import com.grapheople.domain.mission.enums.MissionPeriodType;
import com.grapheople.domain.mission.vo.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionDBService missionDBService;
    private final MissionLogDBService missionLogDBService;

    public List<Mission> getMissionsByPeriodType(MissionPeriodType periodType) {
        return missionDBService.getMissionsByPeriodType(periodType);
    }
}
