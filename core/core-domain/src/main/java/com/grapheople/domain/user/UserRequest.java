package com.grapheople.domain.user;

import lombok.Builder;

@Builder
public record UserRequest(
    String name,
    String email
) {
}
