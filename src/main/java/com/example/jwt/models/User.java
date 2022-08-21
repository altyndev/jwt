package com.example.jwt.models;

import com.example.jwt.dto.requests.UserRegisterRequest;
import com.example.jwt.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @CreatedDate
    private LocalDate createdAt;

    private String password;

    public User(UserRegisterRequest userRegisterRequest) {
        this.firstName = userRegisterRequest.getFirstName();
        this.lastName = userRegisterRequest.getLastName();
        this.phoneNumber = userRegisterRequest.getPhoneNumber();
        this.email = userRegisterRequest.getEmail();
        this.role = Role.USER;
        this.createdAt = LocalDate.now();
    }
}
