package com.softron.security.auth.encoders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * Configuration class to defined encoders.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Configuration
public class Encoders {
    /**
     * 
     * Method to create {@code PasswordEncoder} instance with strength level of
     * 4 rounds.
     * 
     * @return instance of PasswordEncoder.
     */
    @Bean
    public PasswordEncoder oauthClientPasswordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    /**
     * 
     * Method to create {@code PasswordEncoder} instance with strength level of
     * 8 rounds.
     * 
     * @return instance of PasswordEncoder.
     */
    @Bean
    public PasswordEncoder userPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
