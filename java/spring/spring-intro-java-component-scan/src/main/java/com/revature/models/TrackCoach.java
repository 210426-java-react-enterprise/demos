package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

//    @Autowired // NEVER DO FIELD BASED INJECTION; IT MAKES FOR UNTESTABLE CLASSES
    private MotivationService motivationService;

    // Autowired
    public TrackCoach(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Run a 30-minute 5k.";
    }

    @Override
    public String getMotivation() {
        return "The track coach says: " + motivationService.getMotivation();
    }

}
