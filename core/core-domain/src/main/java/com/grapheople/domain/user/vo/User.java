package com.grapheople.domain.user.vo;

import com.grapheople.domain.user.enums.SocialLoginProvider;
import com.grapheople.domain.user.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String nickname;
    private String email;
    private SocialLoginProvider socialLoginProvider;
    private String socialLoginProviderId;
    private UserRole role;
}
