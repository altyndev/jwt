package com.example.jwt.services;

import com.example.jwt.models.User;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.security.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty())
            throw new UsernameNotFoundException("User is not found");
        return new UserDetails(user.get());

    }
}
