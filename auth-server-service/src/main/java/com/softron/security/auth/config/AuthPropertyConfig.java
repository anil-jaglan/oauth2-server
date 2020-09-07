package com.softron.security.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Class to load environment properties dynamically from run time arguments.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Configuration
public class AuthPropertyConfig {

    /**
     * Flag to enable/disable SSL requests only.
     */
    @Value("${security.ssl.enabled}")
    private boolean sslOnly;

    @Value("${security.security-realm}")
    private String securityRealm;

    /**
     * JWT token singing key.
     */
    @Value("${jwt.config.signing-key}")
    private String signingKey;

    /**
     * 
     * Getter of {@link #sslOnly}.
     * 
     * @return {@link #sslOnly}
     */
    public boolean isSslOnly() {
        return sslOnly;
    }

    /**
     * 
     * Setter of {@link #sslOnly}.
     * 
     * @param sslOnly
     *            to be set
     */
    public void setSslOnly(boolean sslOnly) {
        this.sslOnly = sslOnly;
    }

    /**
     * 
     * Getter of {@link #securityRealm}.
     * 
     * @return {@link #securityRealm}
     */
    public String getSecurityRealm() {
        return securityRealm;
    }

    /**
     * 
     * Setter of {@link #securityRealm}.
     * 
     * @param securityRealm
     *            to be set
     */
    public void setSecurityRealm(String securityRealm) {
        this.securityRealm = securityRealm;
    }

    /**
     * 
     * Getter of {@link #signingKey}.
     * 
     * @return {@link #signingKey}
     */
    public String getSigningKey() {
        return signingKey;
    }

    /**
     * 
     * Setter of {@link #signingKey}.
     * 
     * @param signingKey
     *            to be set
     */
    public void setSigningKey(String signingKey) {
        this.signingKey = signingKey;
    }

}
