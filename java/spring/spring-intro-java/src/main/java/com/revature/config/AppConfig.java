package com.revature.config;

import com.revature.models.BaseballCoach;
import com.revature.models.FootballCoach;
import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Value("${coach-email}")
    private String coachEmail;

    @Bean
    @Scope("prototype")
    public BaseballCoach baseballCoach() {
        return new BaseballCoach(motivationService());
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public FootballCoach footballCoach() {
        FootballCoach footballCoach = new FootballCoach();
        footballCoach.setMotivationService(motivationService());
        footballCoach.setTeamName("The Cafebabes");
        footballCoach.setEmail(coachEmail);
        return footballCoach;
    }

    @Bean(name = "motivationService")
    public MotivationService motivationService() {
        return new MotivationService();
    }
}
