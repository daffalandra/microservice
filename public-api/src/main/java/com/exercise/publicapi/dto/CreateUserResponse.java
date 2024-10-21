package com.exercise.publicapi.dto;
import com.exercise.publicapi.entity.PublicUser;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class CreateUserResponse {
    private UserDto user;

    public CreateUserResponse(PublicUser publicUser) {
        this.user = new UserDto(publicUser.getId(), publicUser.getName(), publicUser.getCreatedAt(), publicUser.getUpdatedAt());
    }

    public UserDto getUser() {
        return user;
    }

    public static class UserDto {
        private Integer id;
        private String name;
        private Long createdAt;
        private Long updatedAt;

        public UserDto(Integer id, String name, Long createdAt, Long updatedAt) {
            this.id = id;
            this.name = name;
            final Long timestampInMicroSecond = nowInEpochMicroSecond();
            this.createdAt = timestampInMicroSecond;
            this.updatedAt = timestampInMicroSecond;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Long createdAt) {
            this.createdAt = createdAt;
        }

        public Long getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Long updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
    private static Long nowInEpochMicroSecond() {
        return ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now());
    }
}
