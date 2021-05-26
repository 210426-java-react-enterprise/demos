package com.revature.spring_aop;

import com.revature.spring_aop.config.AppConfig;
import com.revature.spring_aop.models.FootballCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDriver {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)) {

            FootballCoach footballCoach = container.getBean("footballCoach", FootballCoach.class);
            System.out.println(footballCoach.getDailyWorkout());
            System.out.println(footballCoach.getMotivation());
            System.out.println(footballCoach.getEmail());
            System.out.println(footballCoach.getTeamName());
            footballCoach.setEmail("someotheremail@gmail.com");

            try {
                footballCoach.setTeamName("The Java Beans");
            } catch (Exception e) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
