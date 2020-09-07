package com.softron.security.authserver.boot;

import com.softron.security.authserver.constants.GeneralConstants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * Class to start Authentication server application.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan(basePackages = GeneralConstants.APPLICATION_BASE_PACKAGE)
public class StartAuthServerAppliction {

    /**
     * 
     * Main method to start application using spring boot.
     * 
     * @param args
     *            - command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(StartAuthServerAppliction.class, args);
    }
}
