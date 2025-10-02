package com.grapheople.domain.user.vo;

import com.grapheople.domain.user.enums.Country;
import com.grapheople.domain.user.enums.Gender;
import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String nickname;
    private String email;
    private LocalDate birthDate;
    private Gender gender;
    private Country country;
    private SocialLoginProvider socialLoginProvider;
    private String socialLoginProviderId;
    private UserRole role;
}
