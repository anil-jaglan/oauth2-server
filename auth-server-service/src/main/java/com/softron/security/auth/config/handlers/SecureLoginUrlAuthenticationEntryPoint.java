package com.softron.security.auth.config.handlers;

import static com.softron.security.auth.common.constants.AuthServerConstants.REDIRECT_URI;
import static com.softron.security.auth.common.constants.AuthServerConstants.REQ_CHAR_ENCODING;
import static com.softron.security.auth.common.constants.AuthServerConstants.TARGET_URL;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * 
 * Custom class for configuring LoginUrlAuthenticationEntryPoint properties.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
public class SecureLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    /**
     * 
     * Constructor.
     *
     * @param loginFormUrl
     */
    public SecureLoginUrlAuthenticationEntryPoint(final String loginFormUrl) {
        super(loginFormUrl);
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    protected String determineUrlToUseForThisRequest(final HttpServletRequest request,
            final HttpServletResponse response, final AuthenticationException exception) {
        return super.determineUrlToUseForThisRequest(request, response, exception) + determineTargetUrl(request);
    }

    /**
     * 
     * Method to extract targetUrl from request.
     * 
     * @param request
     * @return
     */
    protected String determineTargetUrl(final HttpServletRequest request) {
        String redirectUri = "";
        try {
            if (request.getParameter(REDIRECT_URI) != null) {
                redirectUri = new StringBuilder("?").append(TARGET_URL).append("=").append(
                        URLEncoder.encode(request.getParameter(REDIRECT_URI), REQ_CHAR_ENCODING)).toString();
            }
        } catch (final UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Couldn't parse URI", e);
        }
        return redirectUri;
    }
}
