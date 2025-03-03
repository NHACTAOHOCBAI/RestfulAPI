package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/create")
    public String createNewUSer() {
        User user = new User();
        user.setEmail("phuc2005@gmail.com");
        user.setName("phucc");
        user.setPassword("12345");
        this.userService.handleCreateUser(user);
        return "create user";
    }
}
