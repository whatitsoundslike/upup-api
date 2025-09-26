package com.grapheople.domain.user;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User findById(Long id);
}
