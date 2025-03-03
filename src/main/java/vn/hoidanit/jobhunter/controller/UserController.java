package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public User createNewUSer(
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
}
