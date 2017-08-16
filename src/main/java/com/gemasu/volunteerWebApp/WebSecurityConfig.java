package com.gemasu.volunteerWebApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;
	@Override
	public void configure(HttpSecurity http) throws Exception{

			http
			.authorizeRequests()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/static/**", "/", "/index", "/css/**", "/fonts/**", "/js/**", "/images/**", "**/favicon.ico").permitAll()
				
				.antMatchers("/","/register","/home","/login","/createUser","/project/public/**").permitAll()
				
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
//				.defaultSuccessUrl("/secure")
				.failureUrl("/loginError")
				.permitAll()
				.and()
				
				.logout()
	            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            	.logoutSuccessUrl("/")
	                .permitAll();

	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
/*	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}*/
	

}
