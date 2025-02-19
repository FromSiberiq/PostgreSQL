package com.example.postgres.controller;


import com.example.postgres.dto.request.CreateUserRequest;
import com.example.postgres.dto.response.UserResponse;
import com.example.postgres.entity.UserEntity;
import com.example.postgres.repository.UserRepository;
import com.example.postgres.routes.UserRoutes;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserApiController {
    private final UserRepository userRepository;

    @GetMapping("/")
    public UserEntity test() {
        UserEntity user = UserEntity.builder()
                .firstName("Test")
                .lastName("Test")
                .build();

        user = userRepository.save(user);
        return user;
    }

    @PostMapping(UserRoutes.CREATE)
    public UserResponse create(@RequestBody CreateUserRequest request) {
        UserEntity user = UserEntity.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .build();
        user = userRepository.save(user);
        return UserResponse.of(user);
    }
}
