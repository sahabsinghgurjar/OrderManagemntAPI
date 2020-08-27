package com.sahab.ordermanagement.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.sahab.ordermanagement.model.security.AccessTokenDetails;

@Component
public class JWTConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

	public void configure(JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);
	}

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		OAuth2Authentication auth = super.extractAuthentication(map);
		AccessTokenDetails details = new AccessTokenDetails();
		try {
		details.setId((String) map.get("client_id"));
		details.setName((String) map.get("name"));
		details.setUserName((String) map.get("user_name"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		auth.setDetails(details);
		return auth;
	}
}
