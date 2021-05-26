package com.revature.spring_aop.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MotivationService {

    public String getMotivation() {
        // Pretend this queries some motivation quotes API (hard coded value for brevity)
        return "Don't quit. Suffer now and live the rest of your life like a champion. - Muhammad Ali";
    }

}
