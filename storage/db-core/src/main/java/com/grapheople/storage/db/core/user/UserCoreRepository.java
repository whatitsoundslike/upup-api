package com.grapheople.storage.db.core.user;

import com.grapheople.domain.user.User;
import com.grapheople.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserCoreRepository implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public User findById(Long id) {
        UserEntity userEntity = userJpaRepository.findById(id).orElse(null);
        if (userEntity != null) {
            return User.builder()
                    .id(id)
                    .name(userEntity.getName())
                    .email(userEntity.getEmail())
                    .build();
        }
        return null;
    }
}
