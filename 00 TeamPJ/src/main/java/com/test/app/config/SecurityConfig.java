package com.test.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.test.app.config.auth.CustomAccessDeniedHandler;
import com.test.app.config.auth.CustomAuthenticationEntryPoint;
import com.test.app.config.auth.CustomAuthenticationFailureHandler;
import com.test.app.config.auth.CustomLoginSuccessHandler;
import com.test.app.config.auth.CustomLogoutHandler;
import com.test.app.config.auth.CustomLogoutSuccessHandler;
import com.test.app.config.auth.PrincipalDetailService;

// security-context.xml 설정 내용

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PrincipalDetailService PrincipalDetailService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();													// 중간 공격을 맞아주는 설정
		
		http
			.authorizeRequests()
				.antMatchers("/resources/static/css/**").permitAll()// 인가 처리 
				.antMatchers("/resources/static/js/**").permitAll()// 인가 처리 
				.antMatchers("/resources/static/src/**").permitAll()// 인가 처리 
				.antMatchers("/","/public","/join","/member/auth/Login").permitAll()
																				// hasRole을 사용시 기본적으로 Role_ 이 제공된다
				.antMatchers("/user").hasRole("User")							// Role_User	
				.antMatchers("/member").hasRole("Member")						// Role_Member
				.antMatchers("/admin","/product").hasRole("Admin")							// Role_Admin
				.anyRequest().authenticated()									// 나머지 URL은 모두 인증작업이 완료된 이후 접근가능
				.and()
				.formLogin()													// 로그인이 되지 않은 상태에서 자동으로 로그인 페이지로 리다이렉팅이 된다
				.loginPage("/member/auth/Login").permitAll()											// 커스텀 로그인 페이지 설정
				.successHandler(new CustomLoginSuccessHandler())				// 로그인시 역활에 따른 페이지 설정
				.failureHandler(new CustomAuthenticationFailureHandler())		// 로그인 실패 예외처리
				
				.and()
				
				.logout()
				.logoutUrl("/logout")
				.permitAll()
				.addLogoutHandler(new CustomLogoutHandler())					// 로그아웃시 세션초기화
				.logoutSuccessHandler(new CustomLogoutSuccessHandler());		// 로그아웃 성공적으로 되었을경우 기본위치로 페이지 이동
		
			http
				.exceptionHandling()
				.authenticationEntryPoint(new CustomAuthenticationEntryPoint())	// 인증 실패 예외처리
				.accessDeniedHandler(new CustomAccessDeniedHandler());			// 권한 실패 예외처리
				
//			http
//				.addFilterBefore(null, null);
	}

	// 인증처리 함수
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// auth.userDetailsService : DB 연결할때 사용되는 함수
		
		auth.userDetailsService(PrincipalDetailService).passwordEncoder(passwordEncoder);
//		
//		auth
//			.inMemoryAuthentication()
//				.withUser("user")
//				.password(passwordEncoder.encode("1234"))
//				.roles("User");
//						
//		auth
//		.inMemoryAuthentication()
//			.withUser("member")
//			.password(passwordEncoder.encode("1234"))
//			.roles("Member");
//		
//		auth
//		.inMemoryAuthentication()
//			.withUser("admin")
//			.password(passwordEncoder.encode("1234"))
//			.roles("Admin");
		
	}
	
	
	
	// BCryptPasswordEncoder	: 비밀번호를 암호화 시키는 작업

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
}
