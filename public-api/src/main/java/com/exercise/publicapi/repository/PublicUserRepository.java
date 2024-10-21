package com.exercise.publicapi.repository;
import com.exercise.publicapi.entity.PublicUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicUserRepository extends JpaRepository<PublicUser, Integer> {
}
