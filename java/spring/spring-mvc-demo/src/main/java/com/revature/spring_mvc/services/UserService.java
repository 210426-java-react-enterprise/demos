package com.revature.spring_mvc.services;

import com.revature.spring_mvc.dtos.AppUserDTO;
import com.revature.spring_mvc.dtos.AppUserList;
import com.revature.spring_mvc.exceptions.ResourceNotFoundException;
import com.revature.spring_mvc.models.AppUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static int nextId = 6;
    List<AppUser> users;

    {
        users = new ArrayList<>(Arrays.asList(
                new AppUser(1, "wsingleton", "revature", "wsingleton@gmail.com", "Wezley", "Singleton"),
                new AppUser(2, "aanderson", "password", "aanderson@gmail.com", "Alice", "Anderson"),
                new AppUser(3, "bbailey", "password", "bbailey@gmail.com", "Bob", "Bailey"),
                new AppUser(4, "ccantrell", "password", "ccantrell@gmail.com", "Chris", "Cantrell"),
                new AppUser(5, "ddavis", "password", "ddavis@gmail.com", "Daniel", "Davis"))
        );
    }

    public List<AppUser> getAllUsers_json() {
        return users;
    }

    public AppUserList getAllUsers_xml() {
        List<AppUserDTO> userList = users.stream().map(AppUserDTO::new).collect(Collectors.toList());
        return new AppUserList(userList);
    }

    public AppUser getUserById_json(int id) {
        return users.stream()
                .filter(appUser -> appUser.getId() == id)
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);
    }


    public AppUserDTO getUserById_xml(int id) {
        return users.stream()
                    .filter(appUser -> appUser.getId() == id)
                    .map(AppUserDTO::new)
                    .findFirst()
                    .orElseThrow(ResourceNotFoundException::new);
    }

    public AppUser getUserByEmail(String email) {
        return users.stream()
                    .filter(appUser -> appUser.getEmail().equals(email))
                    .findFirst()
                    .orElseThrow(ResourceNotFoundException::new);
    }

    public AppUser createNewUser(AppUser newUser) {
        newUser.setId(nextId++);
        users.add(newUser);
        return newUser;
    }

    public AppUser updateUserEmail(int id, String email) {
        AppUser user = users.get(id - 1);
        user.setEmail(email);
        return user;
    }
}
