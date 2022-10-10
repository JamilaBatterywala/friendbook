//package com.friendbook.config;
//
//import javax.annotation.security.PermitAll;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.friendbook.services.UserService;
//	
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserService userService;
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//	return new BCryptPasswordEncoder();	
//	}
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//		auth.setUserDetailsService(userService);
//		auth.setPasswordEncoder(passwordEncoder());
//		return auth;
//		
//	}
//	
//	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//		auth.authenticationProvider(authenticationProvider());
//	}
//	
//	
//	
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().antMatchers(
//				"/views/home.jsp",
//				"/views/MyProfile.jsp",
//				"/views/navbar.jsp",
//				"/views/notification.jsp",
//				"/views/Registersuccess.jsp",
//				"/views/search.jsp",
//				"/views/style.css",
//				"/views/UploadPost.jsp"
//				).permitAll().anyRequest().authenticated().and().
//			formLogin().loginPage("/loginpage").permitAll();
//		//.and().formLogin().defaultSuccessUrl("/views/home/**",true);
////			.and()
////			.logout()
////			.invalidateHttpSession(true)
////			.clearAuthentication(true)
////			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////			.logoutSuccessUrl("/login?logout")
////		.permitAll();
//		
//	}
//	
//	
//
//}
