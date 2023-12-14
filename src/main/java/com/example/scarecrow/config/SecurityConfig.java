package com.example.scarecrow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
// 스프링 시큐리티 사용
@EnableWebSecurity

public class SecurityConfig {
    
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	//HTTP 요청에 대한 접근 제한을 설정
            .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
            
            //CSRF 보호 설정
            .csrf((csrf) -> csrf
                .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
            
            //X-Frame-Options 헤더를 추가 클릭 재킹 공격을 방지하는 데 사용
            .headers((headers) -> headers
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
            
            // 로그인 폼에 대한 설정
            .formLogin((formLogin) -> formLogin
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/scarecrow/"))
            //로그아웃 폼에 대한 설정
            .logout((logout) -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                    .logoutSuccessUrl("/scarecrow/")
                    .invalidateHttpSession(true))
        ;
        return http.build();
    }
	
	//비밀번호 암호화
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    //시큐리티의 인증 담당
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
}