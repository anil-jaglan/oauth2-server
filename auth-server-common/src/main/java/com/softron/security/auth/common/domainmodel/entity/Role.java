package com.softron.security.auth.common.domainmodel.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "USER_ROLES")
public class Role implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8645976870237473738L;

    /**
     * Role id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    /**
     * Role name.
     */
    @Column(name = "ROLE_NAME")
    private String name;

    /**
     * List of users, which has this role assigned.
     */
    @ManyToMany
    @JoinColumn(name = "roles")
    private Collection<UserEntity> users;

    /**
     * Collection of assigned privileges to this role.
     */
    @ManyToMany(mappedBy = "roles")
    private Collection<Privilege> privileges;

    /**
     * 
     * Getter of {@link #id}.
     * 
     * @return {@link #id}
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * Setter of {@link #id}.
     * 
     * @param id
     *            to be set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * Getter of {@link #name}.
     * 
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * Setter of {@link #name}.
     * 
     * @param name
     *            to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * Getter of {@link #users}.
     * 
     * @return {@link #users}
     */
    public Collection<UserEntity> getUsers() {
        return users;
    }

    /**
     * 
     * Setter of {@link #users}.
     * 
     * @param users
     *            to be set
     */
    public void setUsers(Collection<UserEntity> users) {
        this.users = users;
    }

    /**
     * 
     * Getter of {@link #privileges}.
     * 
     * @return {@link #privileges}
     */
    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    /**
     * 
     * Setter of {@link #privileges}.
     * 
     * @param privileges
     *            to be set
     */
    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

}
