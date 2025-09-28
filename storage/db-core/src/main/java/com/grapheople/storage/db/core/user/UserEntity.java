package com.grapheople.storage.db.core.user;

import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.enums.UserRole;
import com.grapheople.storage.db.core.BaseEntity;
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
