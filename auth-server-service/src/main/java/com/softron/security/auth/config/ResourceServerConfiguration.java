package com.softron.security.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 
 * Class to override the ResourceServer configuration default implementation.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * Defining resource id.
     */
    private static final String RESOURCE_ID = "order-service";

    /**
     * Resource server secure patterns to be authenticated.
     */
    private static final String[] SECURE_PATTERN = new String[]
        { "/userinfo", "/roles/**", "/users/**", "/account/**" };

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @throws Exception
     */
    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers(SECURE_PATTERN).and().authorizeRequests().anyRequest().authenticated();
    }
}
