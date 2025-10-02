package com.grapheople.domain.user.db.entity;

import com.grapheople.domain.common.entity.BaseEntity;
import com.grapheople.domain.user.enums.Country;
import com.grapheople.domain.user.enums.Gender;
import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends BaseEntity {
    private String name;
    private String nickname;

    @Column(unique = true)
    private String email;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Enumerated(EnumType.STRING)
    private SocialLoginProvider socialLoginProvider;

    @Column(unique = true)
    private String socialLoginProviderId;
    private UserRole role;
}
