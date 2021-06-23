package com.mortgert.controllers;

import com.mortgert.data.dtos.Credentials;
import com.mortgert.security.authentication.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public AuthenticationController(AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/fails",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody Credentials request) {
        Authentication authentication = authenticationFacade.getAuthentication();
        authentication.getPrincipal();

        if(!authentication.isAuthenticated()){
            return ResponseEntity.badRequest().body("Invalid Credentials Supplied");
        }
        return ResponseEntity.accepted().build();
    }
}
