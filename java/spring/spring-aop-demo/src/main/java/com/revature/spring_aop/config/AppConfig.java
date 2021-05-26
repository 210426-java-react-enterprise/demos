package com.revature.spring_aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.revature.spring_aop")
@PropertySource("classpath:app.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
