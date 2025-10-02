package com.grapheople.core.api.controller.v1;

import com.grapheople.core.support.response.ApiResponse;
import com.grapheople.domain.level.db.service.LevelDBService;
import com.grapheople.domain.level.service.LevelService;
import com.grapheople.domain.level.vo.Level;
import com.grapheople.domain.user.db.service.UserDBService;
import com.grapheople.domain.user.service.UserService;
import com.grapheople.domain.user.vo.User;
import com.grapheople.core.api.controller.v1.request.UserRequest;
import com.grapheople.core.api.controller.v1.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDBService userDBService;
    private final LevelDBService levelDBService;

    @GetMapping("/api/v1/users/{id}")
    public ApiResponse<UserResponse> getUser(@PathVariable Long id) {
        User user = userDBService.findById(id);
        Level level = levelDBService.getOrCreateLevel(id);
        return ApiResponse.success(UserResponse.from(user, level));
    }

    @PostMapping("/api/v1/users")
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request) {
        User newUser = User.builder()
                .name(request.name())
                .nickname(request.nickname())
                .email(request.email())
                .birthDate(request.birthDate())
                .gender(request.gender())
                .country(request.country())
                .socialLoginProvider(request.socialLoginProvider())
                .socialLoginProviderId(request.socialLoginProviderId())
                .role(request.role())
                .build();
        User createdUser = userDBService.save(newUser);
        return ApiResponse.success(UserResponse.from(createdUser, null));
    }
}
