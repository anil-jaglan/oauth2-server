package com.softron.security.auth.common.domainmodel.entity;

import com.softron.security.auth.common.enums.Realm;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * Entity to persist user information in data store.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 2877879787472382731L;

    /**
     * User id.
     */
    @Id
    @Column(name = "USER_ID")
    private String userName;

    /**
     * User first name;
     */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /**
     * User last name;
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * User email.
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * User password.
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * User enabled flag.
     */
    @Column(name = "ENABLED")
    private boolean enabled = true;

    /**
     * User account non-expired flag.
     */
    @Column(name = "ACCOUNT_NON_EXPIRED")
    private boolean accountNonExpired = true;

    /**
     * User account non-locked flag
     */
    @Column(name = "ACCOUNT_NON_LOCKED")
    private boolean accountNonLocked = true;

    /**
     * User
     */
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired = true;

    /**
     * User information last updated time.
     */
    @Column(name = "LAST_UPDATED_ON")
    private LocalDate lastUpdatedOn;

    /**
     * User authentication type.
     */
    @Column(name = "REALM")
    @Enumerated(EnumType.STRING)
    private Realm realm;

    /**
     * User roles.
     */
    /*
     * @ManyToMany(mappedBy = "users") private Collection<Role> roles;
     */
    /**
     * 
     * Getter of {@link #userName}.
     * 
     * @return {@link #userName}
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * Setter of {@link #userName}.
     * 
     * @param userName
     *            to be set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
    public void setFirstName(String firstName) {
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
    public void setLastName(String lastName) {
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
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * 
     * Getter of {@link #enabled}.
     * 
     * @return {@link #enabled}
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 
     * Setter of {@link #enabled}.
     * 
     * @param enabled
     *            to be set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 
     * Getter of {@link #accountNonExpired}.
     * 
     * @return {@link #accountNonExpired}
     */
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * 
     * Setter of {@link #accountNonExpired}.
     * 
     * @param accountNonExpired
     *            to be set
     */
    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * 
     * Getter of {@link #accountNonLocked}.
     * 
     * @return {@link #accountNonLocked}
     */
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * 
     * Setter of {@link #accountNonLocked}.
     * 
     * @param accountNonLocked
     *            to be set
     */
    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    /**
     * 
     * Getter of {@link #credentialsNonExpired}.
     * 
     * @return {@link #credentialsNonExpired}
     */
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * 
     * Setter of {@link #credentialsNonExpired}.
     * 
     * @param credentialsNonExpired
     *            to be set
     */
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
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
    public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
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
    public void setRealm(Realm realm) {
        this.realm = realm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserEntity other = (UserEntity) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

}
