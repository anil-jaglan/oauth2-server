package com.softron.security.auth.model;

public class AuthToken {

    private String token;

    private String username;

    /**
     * 
     * Constructor.
     *
     */
    public AuthToken() {
        super();
    }

    /**
     * 
     * Constructor.
     *
     * @param token
     * @param username
     */
    public AuthToken(String token, String username) {
        super();
        this.token = token;
        this.username = username;
    }

    /**
     * 
     * Getter of {@link #token}.
     * 
     * @return {@link #token}
     */
    public String getToken() {
        return token;
    }

    /**
     * 
     * Setter of {@link #token}.
     * 
     * @param token
     *            to be set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 
     * Getter of {@link #username}.
     * 
     * @return {@link #username}
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * Setter of {@link #username}.
     * 
     * @param username
     *            to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
