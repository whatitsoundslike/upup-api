package com.grapheople.domain.user.service;

import com.grapheople.domain.user.db.service.UserDBService;
import com.grapheople.domain.user.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDBService userDBService;

    public User getUser(Long id) {
        return userDBService.findById(id);
    }

    public User createUser(User user) {
        return userDBService.save(user);
    }
}
