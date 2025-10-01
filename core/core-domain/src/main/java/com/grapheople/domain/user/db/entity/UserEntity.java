package com.grapheople.domain.user.db.entity;

import com.grapheople.domain.common.entity.BaseEntity;
import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    private String name;
    private String nickname;
    private String email;

    @Enumerated(EnumType.STRING)
    private SocialLoginProvider socialLoginProvider;
    private String socialLoginProviderId;
    private UserRole role;
}
