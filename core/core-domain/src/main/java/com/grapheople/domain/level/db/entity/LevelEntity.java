package com.grapheople.domain.level.db.entity;

import com.grapheople.domain.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "levels")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LevelEntity extends BaseEntity {
    private Long userId;
    private Integer level;
    private Long accumulatedExp;
    @Version
    private Long version;
}
