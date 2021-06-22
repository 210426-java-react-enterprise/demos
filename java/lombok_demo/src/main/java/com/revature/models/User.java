package com.revature.models;

import lombok.*;

import javax.persistence.*;

/**
 * Example model class to demonstrate the use of Lombok Annotations.
 *
 * @Getter/@Setter generates a getter and setter for the class fields
 * @ToString creates a ToString()
 * @NoArgsConstructor generates a constructor with no arguments
 * @AllArgsConstructor generates a constructor with class fields as arguments(see UserService for more usage)
 * @EqualsAndHashCode generates an equals() method, as well as a hashCode() method
 * @Data implies @Getter/@Setter, @ToString, and @EqualsAndHashCode
 *
 */
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public @Data class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;

    private String email;
}
