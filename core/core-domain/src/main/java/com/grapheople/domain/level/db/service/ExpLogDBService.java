package com.grapheople.domain.level.db.service;

import com.grapheople.domain.level.db.entity.ExpLogEntity;
import com.grapheople.domain.level.db.repository.ExpLogRepository;
import com.grapheople.domain.level.enums.ExpGainType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpLogDBService {
    private final ExpLogRepository expLogRepository;

    public ExpLogEntity save(Long userId, ExpGainType expGainType, Long providerId, Long exp) {
        return expLogRepository.save(ExpLogEntity.builder()
                .userId(userId).expGainType(expGainType)
                .providerId(providerId)
                .gainedExp(exp)
                .build());
    }
}
