package com.revature.spring_aop.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnmanagedBean {

    private final Logger logger = LogManager.getLogger();

    public void test() {
        logger.info("Whatever your log message is....");
        System.out.println("This will not be advised by our LoggingAspect!");
    }
}
