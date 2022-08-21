package com.example.jwt.dto.responses;

import com.example.jwt.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private Long id;
    private String jwt;
    private Role role;
    private String firstName;
}
