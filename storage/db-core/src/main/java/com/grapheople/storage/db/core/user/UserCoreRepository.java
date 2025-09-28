package com.grapheople.storage.db.core.user;

import com.grapheople.domain.error.CoreException;
import com.grapheople.domain.error.ErrorType;
import com.grapheople.domain.user.enums.UserRole;
import com.grapheople.domain.user.vo.User;
import com.grapheople.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserCoreRepository implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public User findById(Long id) {
        UserEntity userEntity = userJpaRepository.findById(id).orElseThrow(() -> new CoreException(ErrorType.USER_NOT_FOUND));
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

    @Override
    public User save(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setNickname(user.getNickname());
        userEntity.setEmail(user.getEmail());
        userEntity.setSocialLoginProvider(user.getSocialLoginProvider());
        userEntity.setSocialLoginProviderId(user.getSocialLoginProviderId());
        userEntity.setRole(user.getRole() != null ? user.getRole() : UserRole.USER);
        UserEntity savedEntity = userJpaRepository.save(userEntity);
        user.setId(savedEntity.getId());
        return user;
    }
}
