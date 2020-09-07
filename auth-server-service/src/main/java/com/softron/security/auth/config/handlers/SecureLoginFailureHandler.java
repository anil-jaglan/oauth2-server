package com.softron.security.auth.config.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

/**
 * 
 * Class to handle authentication failure.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Component
public class SecureLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    /**
     * Logger instance.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SecureLoginFailureHandler.class);

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException exception) throws IOException, ServletException {

        LOG.warn("Handling authentication failure. {}", exception.getMessage());

        if ((exception instanceof SessionAuthenticationException)) {
            response.sendError(401, "multiple.session.error");
        } else if ((exception instanceof BadCredentialsException)) {
            response.sendError(401, "bad.credentials.error");
        } else if (exception instanceof DisabledException
                && "No Roles Assigned to User.".equals(exception.getMessage())) {
            response.sendError(401, "no.roles.assigned.error");
        } else if ((exception instanceof CredentialsExpiredException)) {
            response.sendError(401, "credential.expired.existing.user.error");
        } else {
            response.sendError(500, "internal.server.error");
        }

    }
}
