package com.grapheople.api.controller.v1;

import com.grapheople.api.support.response.ApiResponse;
import com.grapheople.domain.mission.db.service.MissionDBService;
import com.grapheople.domain.mission.enums.MissionPeriodType;
import com.grapheople.domain.mission.service.MissionService;
import com.grapheople.domain.mission.vo.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MissionController {
    private final MissionDBService missionDBService;
    private final MissionService missionService;

    @PostMapping("/api/v1/missions")
    public ApiResponse<Mission> createMission(@RequestBody Mission mission) {
        Mission createdMission = missionDBService.createMission(mission);
        return ApiResponse.success(createdMission);
    }

    @GetMapping("/api/v1/missions/{missionPeriodType}")
    public ApiResponse<List<Mission>> getDailyMission(@PathVariable MissionPeriodType missionPeriodType) {
        List<Mission> dailyMission = missionService.getMissionsByPeriodType(missionPeriodType);
        return ApiResponse.success(dailyMission);
    }
}
