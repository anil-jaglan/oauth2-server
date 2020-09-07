package com.softron.security.auth.config;

import com.softron.security.auth.token.enhancer.CustomTokenEnhancer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 
 * Class to customize AuthorizationServerConfigurerAdapter configuration by
 * overriding default implementation of custom tokenStore,
 * AuthorizationServerSecurityConfigurer, ClientDetailsServiceConfigurer and
 * AuthorizationServerEndpointsConfigurer.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(ServerSecurityConfig.class)
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {

    /**
     * Injecting DataSource instance.
     */
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    /**
     * Injecting AuthenticationManager instance,
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Injecting UserDetailsService instance.
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Injecting oauthClientPasswordEncoder instance.
     */
    @Autowired
    private PasswordEncoder oauthClientPasswordEncoder;

    /**
     * Injecting Jwt Token enhancer instance.
     */
    @Autowired
    private CustomTokenEnhancer tokenEnhancer;

    /**
     * 
     * Method to create {@code TokeStore} instance for managing tokens.
     * 
     * @return TokenStore instance.
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer);
    }

    /**
     * 
     * Method to create OAuth2AccessDeniedHandler bean instance.
     * 
     * @return OAuth2AccessDeniedHandler instance.
     */
    @Bean
    public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler();
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(
                oauthClientPasswordEncoder);
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).userDetailsService(
                userDetailsService).tokenEnhancer(tokenEnhancer);
    }

}
