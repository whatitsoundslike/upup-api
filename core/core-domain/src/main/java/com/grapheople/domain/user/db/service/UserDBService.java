package com.grapheople.domain.user.db.service;

import com.grapheople.domain.error.CoreException;
import com.grapheople.domain.error.ErrorType;
import com.grapheople.domain.user.db.entity.UserEntity;
import com.grapheople.domain.user.db.repository.UserRepository;
import com.grapheople.domain.user.enums.UserRole;
import com.grapheople.domain.user.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDBService {
    private final UserRepository userRepository;

    public User findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new CoreException(ErrorType.USER_NOT_FOUND));
        if (userEntity != null) {
            return User.builder()
                    .id(id)
                    .name(userEntity.getName())
                    .email(userEntity.getEmail())
                    .socialLoginProvider(userEntity.getSocialLoginProvider())
                    .build();
        }
        return null;
    }

    public User save(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setNickname(user.getNickname());
        userEntity.setEmail(user.getEmail());
        userEntity.setSocialLoginProvider(user.getSocialLoginProvider());
        userEntity.setSocialLoginProviderId(user.getSocialLoginProviderId());
        userEntity.setRole(user.getRole() != null ? user.getRole() : UserRole.USER);
        UserEntity savedEntity = userRepository.save(userEntity);
        user.setId(savedEntity.getId());
        return user;
    }
}
