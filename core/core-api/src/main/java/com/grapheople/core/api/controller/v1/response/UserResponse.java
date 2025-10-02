package com.grapheople.core.api.controller.v1.response;

import com.grapheople.domain.level.vo.Level;
import com.grapheople.domain.user.enums.Country;
import com.grapheople.domain.user.enums.Gender;
import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.enums.UserRole;
import com.grapheople.domain.user.vo.User;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserResponse(
        Long id,
        String name,
        String nickname,
        String email,
        LocalDate birthDate,
        Gender gender,
        Country country,
        SocialLoginProvider socialLoginProvider,
        Level level
        ) {
    public static UserResponse from(User user, Level level) {
        if (user == null) {
            return null;
        }
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .gender(user.getGender())
                .country(user.getCountry())
                .socialLoginProvider(user.getSocialLoginProvider())
                .level(level)
                .build();
    }
}
