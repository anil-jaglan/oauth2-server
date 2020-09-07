package com.softron.security.auth.common.domainmodel.repository;

import com.softron.security.auth.common.domainmodel.entity.UserEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * UserRespository for data store operations as read/write user information.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

    /**
     * 
     * Method to find a user by matching user-name ignoring case.
     * 
     * @param username
     *            - user-name to be matched.
     * @return - {@code Optional} UserEntity object.
     */
    Optional<UserEntity> findByUserNameIgnoreCase(String username);

    /**
     * 
     * Method to find a user by matching email ignoring case.
     * 
     * @param email
     *            - email to be matched.
     * @return - {@code Optional} UserEntity object.
     */
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    
    /**
     * 
     * Method to find a user by matching user name or email in lower case.
     * 
     * @param user
     *            - user-name to be matched.
     * @return - {@code Optional} UserEntity object.
     */
    @Query("Select u from UserEntity u where lower(u.userName)=?1 or lower(u.email)=?1")
    Optional<UserEntity> findByUserNameOrEmail(String user);

    /**
     * 
     * Method to fetch all user details ordering by user-name.
     * 
     * @return - List of {@code UserEntity} objects.
     */
    List<UserEntity> findAllByOrderByUserName();

}
