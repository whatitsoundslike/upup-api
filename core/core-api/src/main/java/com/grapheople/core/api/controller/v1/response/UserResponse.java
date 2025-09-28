package com.grapheople.core.api.controller.v1.response;

import com.grapheople.domain.user.vo.User;
import lombok.Builder;

@Builder
public record UserResponse(
    Long id,
    String name,
    String email
) {
    public static UserResponse fromUser(User user) {
        if (user == null) {
            return null;
        }
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
