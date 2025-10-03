package com.grapheople.api.controller.v1.request;

import com.grapheople.domain.user.enums.Country;
import com.grapheople.domain.user.enums.Gender;
import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.enums.UserRole;
import com.grapheople.domain.user.vo.User;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRequest(
    String name,
    String nickname,
    String email,
    LocalDate birthDate,
    Gender gender,
    Country country,
    SocialLoginProvider socialLoginProvider,
    String socialLoginProviderId,
    UserRole role
) {
}
