package com.grapheople.core.api.controller.v1;

import com.grapheople.core.support.response.ApiResponse;
import com.grapheople.domain.user.service.UserService;
import com.grapheople.domain.user.vo.User;
import com.grapheople.core.api.controller.v1.request.UserRequest;
import com.grapheople.core.api.controller.v1.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/v1/users/{id}")
    public ApiResponse<UserResponse> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ApiResponse.success(UserResponse.fromUser(user));
    }

    @PostMapping("/api/v1/users")
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request) {
        User newUser = User.builder()
                .name(request.name())
                .email(request.email())
                .nickname(request.nickname())
                .socialLoginProvider(request.socialLoginProvider())
                .socialLoginProviderId(request.socialLoginProviderId())
                .role(request.role())
                .build();
        User createdUser = userService.createUser(newUser);
        return ApiResponse.success(UserResponse.fromUser(createdUser));
    }
}
