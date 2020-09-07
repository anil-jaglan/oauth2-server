package com.softron.security.auth.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * User service interface.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
public interface UserService {

    /**
     * 
     * Method to find user by user-name or email.
     * 
     * @param email
     * @return
     */
    UserDetails findByUserNameOrEmail(String email);
}
