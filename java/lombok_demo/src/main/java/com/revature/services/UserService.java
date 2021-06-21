package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The <code>onConstructor</code> parameter in @AllArgsConstructor takes in an annotation reference (default syntax being (@__())
 * This is useful especially when working with Spring, as you can just add more beans as fields, and Lombok under the hood will
 * auto wire them for you.
 */
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUsers() {

        return userRepository.findAll();
    }

}