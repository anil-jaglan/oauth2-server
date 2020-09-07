package com.softron.security.auth.service.impl;

import com.softron.security.auth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * 
 * Implementation class for UserDetails Service.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Service
public class UsersDetailsServiceImpl implements UserDetailsService {

    /**
     * Injecting UserService instance.
     */
    private final UserService userService;

    /**
     * 
     * Constructor.
     *
     * @param userService
     */
    @Autowired
    public UsersDetailsServiceImpl(final UserService userService) {
        this.userService = userService;
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        return userService.findByUserNameOrEmail(username);
    }

}
