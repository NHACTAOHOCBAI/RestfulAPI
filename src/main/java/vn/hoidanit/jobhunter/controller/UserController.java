package vn.hoidanit.jobhunter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import vn.hoidanit.jobhunter.service.error.IdInvalidException;

@RestController
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(
            @RequestBody User user
    // request body giúp lấy được data ở phần body mà client gửi
    ) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        // ma hoa mat khau
        user.setPassword(hashPassword);
        User resUser = this.userService.handleCreateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(resUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUSer(@PathVariable("id") long id) throws IdInvalidException
    // PathVariable giúp lấy ra được biến ở url
    {
        if (id >= 1500) {
            throw new IdInvalidException("id khong lon hon 1500");
        }
        this.userService.handleDeleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUSerById(@PathVariable("id") long id)
    // PathVariable giúp lấy ra được biến ở url
    {
        User resUser = this.userService.handleGetUserById(id);
        return ResponseEntity.ok(resUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUSer() {
        List<User> resUsers = this.userService.handleGetAllUser();
        return ResponseEntity.ok(resUsers);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(
            @RequestBody User user
    // request body giúp lấy được data ở phần body mà client gửi
    ) {
        User resUser = this.userService.handleUpdateUser(user);
        return ResponseEntity.ok(resUser);
    }

}
