package com.metacube.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Authentication config file.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource( new UserConfig().getDataSource())
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT username, role FROM user AS U "
				+ " WHERE U.username = ?");
	}
	
	@Override
	protected void configure(final HttpSecurity http)throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/home").hasAnyAuthority("user", "admin")
		.antMatchers("/showUser").hasAuthority("admin")
		.antMatchers("/AddUser").hasAuthority("admin")
		.anyRequest().authenticated().and().formLogin().loginPage("/login")
        .permitAll().defaultSuccessUrl("/home").failureUrl("/login?error=true")
        
        .and().logout().logoutSuccessUrl("/login")
        
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .permitAll()
        .and().exceptionHandling().accessDeniedPage("/accessDenied");
		
		http.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}