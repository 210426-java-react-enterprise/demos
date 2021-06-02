package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

//    @Query("from AppUser au where au.username = :username and au.password = :password")
    AppUser findAppUserByUsernameAndPassword(String username, String password);


}
