package com.grapheople.domain.template.db.entity;

import com.grapheople.domain.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "example_entities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExampleEntity extends BaseEntity {
}
