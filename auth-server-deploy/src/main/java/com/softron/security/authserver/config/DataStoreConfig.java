package com.softron.security.authserver.config;

import com.softron.security.authserver.constants.GeneralConstants;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * Class to configure data store repositories and transaction management.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages =
    { GeneralConstants.APPLICATION_BASE_PACKAGE })
@EnableJpaRepositories(basePackages =
    { GeneralConstants.APPLICATION_BASE_PACKAGE })
@EnableTransactionManagement
public class DataStoreConfig {

}
