package com.grapheople.domain.level.service;

import com.grapheople.domain.level.vo.ExpEvent;

public interface ExpCalculator<T> {
    long calculateExp(ExpEvent<T> expEvent);
}
