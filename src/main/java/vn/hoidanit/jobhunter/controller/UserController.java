package vn.hoidanit.jobhunter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createNewUser(
            @RequestBody User user
    // request body giúp lấy được data ở phần body mà client gửi
    ) {

        User resUser = this.userService.handleCreateUser(user);
        return resUser;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUSer(@PathVariable("id") long id)
    // PathVariable giúp lấy ra được biến ở url
    {
        this.userService.handleDeleteUser(id);
        return "delete user";
    }

    @GetMapping("/user/{id}")
    public User getUSerById(@PathVariable("id") long id)
    // PathVariable giúp lấy ra được biến ở url
    {
        return this.userService.handleGetUserById(id);
    }

    @GetMapping("/user")
    public List<User> getAllUSer() {
        return this.userService.handleGetAllUser();
    }

    @PutMapping("/user")
    public User updateUser(
            @RequestBody User user
    // request body giúp lấy được data ở phần body mà client gửi
    ) {

        User resUser = this.userService.handleUpdateUser(user);
        return resUser;
    }
}
