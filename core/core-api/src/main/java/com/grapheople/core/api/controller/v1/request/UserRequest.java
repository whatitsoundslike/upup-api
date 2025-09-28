package com.grapheople.core.api.controller.v1.request;

import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.enums.UserRole;
import com.grapheople.domain.user.vo.User;
import lombok.Builder;

@Builder
public record UserRequest(
    String name,
    String email,
    String nickname,
    SocialLoginProvider socialLoginProvider,
    String socialLoginProviderId,
    UserRole role
) {
}
