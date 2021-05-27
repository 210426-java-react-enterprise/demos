package com.revature.spring_mvc.services;

import com.revature.spring_mvc.exceptions.ResourceNotFoundException;
import com.revature.spring_mvc.models.AppUser;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    List<AppUser> users;

    {
        users = Arrays.asList(
            new AppUser(1, "wsingleton", "revature", "wsingleton@gmail.com", "Wezley", "Singleton"),
            new AppUser(2, "aanderson", "password", "aanderson@gmail.com", "Alice", "Anderson"),
            new AppUser(3, "bbailey", "password", "bbailey@gmail.com", "Bob", "Bailey"),
            new AppUser(4, "ccantrell", "password", "ccantrell@gmail.com", "Chris", "Cantrell"),
            new AppUser(5, "ddavis", "password", "ddavis@gmail.com", "Daniel", "Davis")
        );
    }

    public List<AppUser> getAllUsers() {
        return users;
    }

    public AppUser getUserById(int id) {
        return users.stream()
                    .filter(appUser -> appUser.getId() == id)
                    .findFirst()
                    .orElseThrow(ResourceNotFoundException::new);
    }

    public AppUser getUserByEmail(String email) {
        return users.stream()
                    .filter(appUser -> appUser.getEmail().equals(email))
                    .findFirst()
                    .orElseThrow(ResourceNotFoundException::new);
    }

}
