package com.example.jwt.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}
