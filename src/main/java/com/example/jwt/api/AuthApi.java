package com.example.jwt.api;

import com.example.jwt.dto.requests.LoginRequest;
import com.example.jwt.dto.requests.UserRegisterRequest;
import com.example.jwt.dto.responses.JwtResponse;
import com.example.jwt.services.LoginService;
import com.example.jwt.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/public")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthApi {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/register")
    public JwtResponse registration(@RequestBody UserRegisterRequest userRegisterRequest) {
        return userService.register(userRegisterRequest);
    }

    @PostMapping("/login")
    public JwtResponse performLogin(@RequestBody LoginRequest loginRequest) {
        return loginService.authenticate(loginRequest);
    }
}
