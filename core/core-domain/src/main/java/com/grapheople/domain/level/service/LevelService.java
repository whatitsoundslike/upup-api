package com.grapheople.domain.level.service;

import com.grapheople.domain.level.db.service.LevelDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelDBService levelDBService;

}
