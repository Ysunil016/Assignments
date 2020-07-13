package com.Spring.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author sunil016, Security configuration class, that is responsible for all
 *         the authorisation and authentication happening. I have enabled
 *         GlobalMethodSecurity, that will allow us to user class level and
 *         method level authorisation security, so no need to use AntMatcher for
 *         each URL.
 *
 *
 */

@Configuration
@EnableWebSecurity

//Enabling Annotation based Security at Class and Functions
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.httpBasic().and().authorizeRequests().antMatchers("/secured/**").authenticated().anyRequest().permitAll()
				.and().logout().logoutUrl("/v1/logout").logoutSuccessHandler((req, res, e) -> {
					if (e != null)
						res.sendRedirect("/v1/user/logout");
				}).and().formLogin().disable();
	}
}
