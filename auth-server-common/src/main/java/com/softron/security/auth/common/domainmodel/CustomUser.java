package com.softron.security.auth.common.domainmodel;

import com.softron.security.auth.common.domainmodel.entity.UserEntity;
import com.softron.security.auth.common.enums.Realm;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * Custom User object for holding user details in authentication context.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
public class CustomUser extends User implements UserDetails {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -7221307130153289097L;

    /**
     * First name.
     */
    private String firstName;

    /**
     * Last name.
     */
    private String lastName;

    /**
     * User email.
     */
    private String email;

    /**
     * User information last updated time.
     */
    private LocalDate lastUpdatedOn;

    /**
     * Realm
     */
    private Realm realm;
    
    /**
     * 
     * Constructor.
     *
     * @param username
     * @param password
     * @param enabled
     * @param accountNonExpired
     * @param credentialsNonExpired
     * @param accountNonLocked
     * @param authorities
     */
    public CustomUser(final String username, final String password, final boolean enabled,
            final boolean accountNonExpired, final boolean credentialsNonExpired, final boolean accountNonLocked,
            final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /**
     * 
     * Constructor.
     *
     * @param username
     * @param password
     * @param authorities
     * @param firstName
     * @param lastName
     * @param email
     * @param realm
     */
    public CustomUser(final String username, final String password,
            final Collection<? extends GrantedAuthority> authorities, final String firstName, final String lastName,
            final String email, final Realm realm) {
        super(username, password, authorities);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.realm = realm;
    }

    /**
     * 
     * Constructor.
     *
     * @param user
     * @param authorities
     */
    public CustomUser(final UserEntity user, final Collection<? extends GrantedAuthority> authorities) {
        super(
                user.getUserName(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                authorities);
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.lastUpdatedOn = user.getLastUpdatedOn();
        this.realm = user.getRealm();
    }

    /**
     * 
     * Getter of {@link #firstName}.
     * 
     * @return {@link #firstName}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * Setter of {@link #firstName}.
     * 
     * @param firstName
     *            to be set
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * Getter of {@link #lastName}.
     * 
     * @return {@link #lastName}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * Setter of {@link #lastName}.
     * 
     * @param lastName
     *            to be set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * Getter of {@link #email}.
     * 
     * @return {@link #email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * Setter of {@link #email}.
     * 
     * @param email
     *            to be set
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * 
     * Getter of {@link #lastUpdatedOn}.
     * 
     * @return {@link #lastUpdatedOn}
     */
    public LocalDate getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    /**
     * 
     * Setter of {@link #lastUpdatedOn}.
     * 
     * @param lastUpdatedOn
     *            to be set
     */
    public void setLastUpdatedOn(final LocalDate lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    /**
     * 
     * Getter of {@link #realm}.
     * 
     * @return {@link #realm}
     */
    public Realm getRealm() {
        return realm;
    }

    /**
     * 
     * Setter of {@link #realm}.
     * 
     * @param realm
     *            to be set
     */
    public void setRealm(final Realm realm) {
        this.realm = realm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CustomUser other = (CustomUser) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

}
