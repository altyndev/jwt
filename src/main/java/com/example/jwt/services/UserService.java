package com.example.jwt.services;

import com.example.jwt.dto.requests.UserRegisterRequest;
import com.example.jwt.dto.responses.JwtResponse;
import com.example.jwt.exceptions.AlreadyExistException;
import com.example.jwt.models.User;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.security.JWTUtil.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public JwtResponse register(UserRegisterRequest userRegisterRequest) {

        if (userRepository.existsByEmail(userRegisterRequest.getEmail())) {
            throw new AlreadyExistException(
                    "An email = " + userRegisterRequest.getEmail() + " with this name already exists"
            );
        }
        User user = new User(userRegisterRequest);
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));

        User savedUser = userRepository.save(user);

        String token = jwtUtil.generateToken(userRegisterRequest.getEmail());

        return new JwtResponse(savedUser.getId(), token,
                savedUser.getRole(), savedUser.getFirstName());
    }
}
