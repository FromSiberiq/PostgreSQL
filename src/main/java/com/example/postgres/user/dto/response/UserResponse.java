package com.example.postgres.user.dto.response;

import com.example.postgres.user.entity.UserEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class UserResponse extends UserEntity {

    public static UserResponse of(UserEntity user) {
        return UserResponse.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
    }
}
