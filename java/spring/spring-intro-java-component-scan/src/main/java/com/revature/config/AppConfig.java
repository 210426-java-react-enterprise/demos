package com.revature.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.revature") // if no package is specified, then Spring will scan the package that this class is in
@PropertySource("classpath:app.properties")
public class AppConfig {

}
