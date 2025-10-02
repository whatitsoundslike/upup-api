package com.grapheople.domain.user.db.service;

import com.grapheople.domain.common.error.CoreException;
import com.grapheople.domain.common.error.ErrorType;
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
                    .nickname(userEntity.getNickname())
                    .email(userEntity.getEmail())
                    .birthDate(userEntity.getBirthDate())
                    .gender(userEntity.getGender())
                    .country(userEntity.getCountry())
                    .socialLoginProvider(userEntity.getSocialLoginProvider())
                    .socialLoginProviderId(userEntity.getSocialLoginProviderId())
                    .role(userEntity.getRole())
                    .build();
        }
        return null;
    }

    public User save(User user) {
        UserEntity userEntity = UserEntity.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .gender(user.getGender())
                .country(user.getCountry())
                .socialLoginProvider(user.getSocialLoginProvider())
                .socialLoginProviderId(user.getSocialLoginProviderId())
                .role(user.getRole() != null ? user.getRole() : UserRole.USER)
                .build();
        UserEntity savedEntity = userRepository.save(userEntity);
        user.setId(savedEntity.getId());
        return user;
    }
}
