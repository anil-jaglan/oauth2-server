package com.softron.security.auth.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * Authentication controller Rest API interface.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
public interface AuthenticationController {

    @GetMapping("/login")
    String login();
}
