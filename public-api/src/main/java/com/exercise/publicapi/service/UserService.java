package com.exercise.publicapi.service;
import com.exercise.publicapi.entity.PublicUser;
import com.exercise.publicapi.repository.PublicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PublicUserRepository publicUserRepository;

    public PublicUser createUser(PublicUser publicUser) {
        return publicUserRepository.save(publicUser);
    }
}
