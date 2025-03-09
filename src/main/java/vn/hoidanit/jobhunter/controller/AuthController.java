package vn.hoidanit.jobhunter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.dto.LoginDTO;

@RestController
public class AuthController {
    final private AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDto) {
        // Nạp input gồm username/password vào Security theo định dạng token cho
        // authManager
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword());

        // truyen token vào để thực hiện xác minh người dùng
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        return ResponseEntity.ok().body(loginDto);
    }
}
