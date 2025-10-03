package com.grapheople.domain.level.vo;

import com.grapheople.domain.level.enums.ExpGainType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExpEvent<T> {
    private Long userId;
    private ExpGainType expGainType;
    private T payload;
}
