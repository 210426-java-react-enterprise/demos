package com.revature.models;

import com.revature.services.MotivationService;

public class FootballCoach implements Coach {

    private String email;
    private String teamName;
    private MotivationService motivationService;

    public FootballCoach() {
        System.out.println("FootballCoach no-args constructor invoked!");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setMotivationService(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    public void customInit() {
        System.out.println("FootballCoach.customInit() invoked!");
    }

    public void customDestroy() {
        System.out.println("FootballCoach.customDestroy() invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Suicide runs to 40, 50, 60, 70, 80, and 100 yard lines";
    }

    @Override
    public String getMotivation() {
        return "The track coach says: " + motivationService.getMotivation();
    }
}
