package com.revature.spring_aop.config;

import com.revature.spring_aop.aspects.LoggingAspect;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan("com.revature.spring_aop")
@PropertySource("classpath:app.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
