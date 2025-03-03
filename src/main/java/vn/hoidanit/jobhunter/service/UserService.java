package vn.hoidanit.jobhunter.service;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepositoty;

@Service
public class UserService {
    private final UserRepositoty userRepositoty;

    public UserService(UserRepositoty userRepositoty) {
        this.userRepositoty = userRepositoty;
    }

    public void handleCreateUser(User user) {
        this.userRepositoty.save(user);
    }
}
