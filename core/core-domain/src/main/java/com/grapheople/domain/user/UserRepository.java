package com.grapheople.domain.user;

import com.grapheople.domain.user.vo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User findById(Long id);
    User save(User user);
}
