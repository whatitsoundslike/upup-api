package com.grapheople.domain.mission.db.service;

import com.grapheople.domain.mission.db.entity.MissionLogEntity;
import com.grapheople.domain.mission.db.repository.MissionLogRepository;
import com.grapheople.domain.mission.db.repository.MissionRepository;
import com.grapheople.domain.mission.vo.MissionLog;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionLogDBService {
    private final MissionLogRepository missionRepository;

    @Transactional
    public MissionLog createMissionLog(MissionLog missionLog) {
        return MissionLog.of(missionRepository.save(MissionLogEntity.from(missionLog)));
    }
}
