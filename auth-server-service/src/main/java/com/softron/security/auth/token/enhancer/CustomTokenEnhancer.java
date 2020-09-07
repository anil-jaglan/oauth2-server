package com.softron.security.auth.token.enhancer;

import com.softron.security.auth.common.domainmodel.CustomUser;
import com.softron.security.auth.config.AuthPropertyConfig;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

/**
 * 
 * Jwt Token enhancer to add User information in Jwt Token
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@Component
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Autowired
    public CustomTokenEnhancer(AuthPropertyConfig config) {
        super();
        setSigningKey(config.getSigningKey());
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        
        final Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
        String fullName = null;
        Collection<GrantedAuthority> authorities = null;
        
        if(authentication.getPrincipal() instanceof CustomUser) {
            final CustomUser user = (CustomUser) authentication.getPrincipal();
            fullName = user.getFirstName() + " " + user.getLastName();
            authorities = user.getAuthorities();
        } else {
            fullName = (String) authentication.getPrincipal();
            authorities = authentication.getAuthorities();
        }
        info.put("full_name", fullName);
        //info.put("authorities", authorities);
        final DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(info);

        return super.enhance(customAccessToken, authentication);
    }
}
