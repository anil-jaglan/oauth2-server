package com.softron.security.auth.service.impl;

import com.softron.security.auth.common.domainmodel.CustomUser;
import com.softron.security.auth.common.domainmodel.entity.Privilege;
import com.softron.security.auth.common.domainmodel.entity.Role;
import com.softron.security.auth.common.domainmodel.entity.UserEntity;
import com.softron.security.auth.common.domainmodel.repository.UserRepository;
import com.softron.security.auth.service.UserService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 
 * UserService interface implementation.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Injecting UserRepository instance.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public UserDetails findByUserNameOrEmail(String email) {
        final UserEntity user = userRepository.findByUserNameOrEmail(email.toLowerCase()).orElseThrow(
                () -> new UsernameNotFoundException("User doesn't exist."));
        return new CustomUser(user, AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_MODIFIER"));
    }

    /**
     * 
     * Method to get {@code GrantedAuthority} from user roles.
     * 
     * @param roles
     *            -Collection<Role>
     * @return Collection<? extends GrantedAuthority>
     */
    protected Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        final Collection<Privilege> privileges = roles.stream().map(Role::getPrivileges).flatMap(
                Collection::stream).collect(Collectors.toSet());
        return getGrantedAuthorities(privileges);
    }

    /**
     * 
     * Method to convert Collection<Privilege> to Collection<GrantedAuthority>.
     * 
     * @param privileges
     *            - Collection<Privilege>.
     * @return Collection<GrantedAuthority>
     */
    protected Collection<GrantedAuthority> getGrantedAuthorities(final Collection<Privilege> privileges) {
        final Set<GrantedAuthority> authorities = new HashSet<>();
        privileges.forEach(privilege -> authorities.add(new SimpleGrantedAuthority(privilege.getName())));
        return authorities;
    }

}
