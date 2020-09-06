package com.sahab.ordermanagement.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class CustomAuthoritiesExtractor implements AuthoritiesExtractor{

	@Override
	public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
		if(map.containsKey("groups")){
			String[] roles = ((Collection<String>)map.get("groups")).toArray(new String[0]);
			return AuthorityUtils.createAuthorityList(roles);
			}
		return null;
	}

}
