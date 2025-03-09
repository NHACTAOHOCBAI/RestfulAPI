package vn.hoidanit.jobhunter.service;

import java.util.List;
import java.util.Optional;

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

    public User handleGetUserById(long id) {
        Optional<User> userOptional = this.userRepositoty.findById(id);
        if (userOptional.isEmpty())
            return null;
        return userOptional.get();
        // ham get , lay gia tri ben trong optional
    }

    public List<User> handleGetAllUser() {
        return this.userRepositoty.findAll();
    }

    public User handleUpdateUser(User user) {
        if (handleGetUserById(user.getId()) == null)
            return null;
        return this.userRepositoty.save(user);
    }

    public User handleGetUserByUsername(String username) {
        return this.userRepositoty.findByEmail(username);
    }
}
