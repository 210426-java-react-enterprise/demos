package com.revature.spring_mvc.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("There was not resource found with the provided search criteria!");
    }
}
