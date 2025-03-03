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

    public User handleCreateUser(User user) {
        return this.userRepositoty.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepositoty.deleteById(id);
    }
}
