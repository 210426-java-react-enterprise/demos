package com.revature.config;

import com.revature.models.BaseballCoach;
import com.revature.models.FootballCoach;
import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
//The @Configuration annotation dictates the java.class that configues
// the App's beans to manage, their scopes and the property source

@Configuration
//@Property Source allows us to pass in a classpath to our properties file
//which holds our apps resources
//currently this demo properties file only holds the information to our coach
//'s email
@PropertySource("classpath:app.properties")
public class AppConfig {
    //The @Value annotation takes in a pom like variable "${propertiesVar}"
    //this variable links our private App field to the a certain resource
    //property.
    @Value("${coach-email}")
    private String coachEmail;

    /**
     * @BEAN: When the ApplicationContext starts it uses either an XML config file or
     * componen scanning to discover what Java classes(beans) it needs to manage for us
     * Once the beans are discovered the AppContxt will create bean definitions
     * which are instructions for creating the bean.
     * These definitions are then stored in the bean container.
    **/

    /**
     * @SCOPE: the Scope annotation tells Spring which method to use when creating
     * these beans in the container aka how to create said bean. Without the @scope
     * annotation, the bean falls into the default type of Singleton
     *
     * There are 6 different types of SCOPE definition:
     *  1) @Singleton(default) - Spring container creates only one instance of the bean
     *                         - This bean is then cached into memory
     *                         - All request for the bean returns a reference to the /same/ bean
     *
     *  2) @Prototype          - Creates new bean instance for each container request
     *
     *  3) @Request            - Bean is scoped to an HTTP we request
     *                         - Only used in web applications
     *
     *  4) @Session            - Bean is schoped to a HTTP web session
     *                         - Only used in web applications
     *
     *  5) @Application        - Scopes a single bean definition to the lifecycle of a ServletContext
     *
     *  6) @websocket          - Scopes a single bean definition to the lifecycle of a WebScoket
     *                         - Only used in web applications
     *
     * **/

    //The @Bean tag tells Spring which class we want to monitor as and their Scope
    @Bean
    //sets the baseball coach to a prototype, meaning it will create a new bean for each of its instances
    @Scope("prototype")
    public BaseballCoach baseballCoach() {
        return new BaseballCoach(motivationService());
    }


    //You can also customize the beans initialize and destroy methods by
    //passing in the initMethod and or destroyMethods as parameters of the
    //@Bean annotations tag
    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public FootballCoach footballCoach() {
        FootballCoach footballCoach = new FootballCoach();
        footballCoach.setMotivationService(motivationService());
        footballCoach.setTeamName("The Cafebabes");
        footballCoach.setEmail(coachEmail);
        return footballCoach;
    }
    //Thw namw parameter allows you to give a referenceName for youe bean
    //If not given the bean name defaults to the name of you method
    @Bean(name = "motivationService")
    public MotivationService motivationService() {
        return new MotivationService();
    }
}
