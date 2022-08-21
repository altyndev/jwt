package com.example.jwt.services;

import com.example.jwt.dto.requests.LoginRequest;
import com.example.jwt.dto.responses.JwtResponse;
import com.example.jwt.exceptions.WrongPasswordException;
import com.example.jwt.models.User;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.security.JWTUtil.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

    private final JWTUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public JwtResponse authenticate(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new NotFoundException(
                        "Email = " + loginRequest.getEmail() + " with this name does not exist"
                ));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new WrongPasswordException("Invalid password");
        }
        String token = jwtUtil.generateToken(user.getEmail());

        return new JwtResponse(user.getId(), token, user.getRole(), user.getFirstName());
    }
}
