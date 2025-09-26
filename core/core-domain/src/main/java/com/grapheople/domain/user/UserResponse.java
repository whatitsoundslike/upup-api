package com.grapheople.domain.user;

import lombok.Builder;

@Builder
public record UserResponse(
    Long id,
    String name,
    String email
) {
}
