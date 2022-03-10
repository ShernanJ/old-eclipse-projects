package ca.sheridancollege.javiersh;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import ca.sheridancollege.javiersh.security.SecurityConfig;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer() {
		super(SecurityConfig.class);
	}
}
