package com.softron.security.auth.model;

public class LoginUser {

    private String username;

    private String password;

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

    /**
     * 
     * Getter of {@link #password}.
     * 
     * @return {@link #password}
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * Setter of {@link #password}.
     * 
     * @param password
     *            to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
