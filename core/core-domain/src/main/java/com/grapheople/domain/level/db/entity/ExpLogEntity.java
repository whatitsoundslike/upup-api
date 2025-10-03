package com.grapheople.domain.level.db.entity;

import com.grapheople.domain.common.entity.BaseEntity;
import com.grapheople.domain.level.enums.ExpGainType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "exp_logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpLogEntity extends BaseEntity {
    private Long userId;

    @Enumerated(EnumType.STRING)
    private ExpGainType expGainType;
    private Long providerId;
    private Long gainedExp;
}
