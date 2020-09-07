package com.softron.security.auth.config.handlers;

import static com.softron.security.auth.common.constants.AuthServerConstants.CONTINUE_URL;
import static com.softron.security.auth.common.constants.AuthServerConstants.REMEMBER_ME_COOKIE_NAME;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * Class to handle user request upon successful login.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Component
public class SecureLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    /**
     * HttpSessionRequestCache instance.
     */
    private final RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication) throws ServletException, IOException {

        addCookieForRememberMe(request, response);
        final SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest == null) {
            final String targetUrl = determineContinueUrl(request, response);
            response.getWriter().append(targetUrl);
            clearAuthenticationAttributes(request);
            return;
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

    /**
     * 
     * Method to create continue URL form request params.
     * 
     * @param request
     * @param response
     * @return
     */
    protected String determineContinueUrl(final HttpServletRequest request, final HttpServletResponse response) {
        String targetUrl = super.determineTargetUrl(request, response);
        final Map<String, List<String>> queryParam = UriComponentsBuilder.fromHttpUrl(
                targetUrl).build().getQueryParams();
        if (queryParam.containsKey(CONTINUE_URL)) {
            targetUrl = queryParam.get(CONTINUE_URL).get(0);
        }
        return targetUrl;
    }

    /**
     * 
     * Method to create cookie for remember-me service.
     * 
     * @param request
     *            - HttpServletRequest object.
     * @param response
     *            - HttpServletResponse object.
     */
    protected void addCookieForRememberMe(final HttpServletRequest request, final HttpServletResponse response) {
        final Boolean rememberMe = Boolean.valueOf(request.getParameter("rememberme"));
        if (rememberMe.booleanValue()) {
            response.addCookie(getCookie(REMEMBER_ME_COOKIE_NAME, request.getParameter("username")));
        } else {
            Cookie cookie = getCookie(REMEMBER_ME_COOKIE_NAME, null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    /**
     * 
     * Method to create never expiring cookie with given name and value. Cookie
     * max age is set to Integer.MAX_VALUE.
     * 
     * @param name
     *            - Cookie name.
     * @param value
     *            - Cookie value.
     * @return Cookie
     */
    protected Cookie getCookie(final String name, final String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(Integer.MAX_VALUE);
        cookie.setPath("/");
        return cookie;
    }
}
