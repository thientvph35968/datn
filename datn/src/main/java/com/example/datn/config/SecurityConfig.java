package com.example.datn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Cấu hình phân quyền
                .authorizeHttpRequests(auth -> auth
                        // Cho phép truy cập công khai
                        .requestMatchers("/login", "/dangki", "/quenmatkhau", "/css/**", "/js/**", "/images/**", "/error", "/test/**").permitAll()
                        .requestMatchers("/", "/home").permitAll()
                        // Phân quyền theo Role
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/employee/**").hasRole("EMPLOYEE")
                        .anyRequest().authenticated()
                )
                // 2. Cấu hình form đăng nhập
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/do-login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler(customSuccessHandler)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                // 3. Cấu hình logout
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                )
                // 4. Cấu hình UserDetailsService
                .userDetailsService(userDetailsService)
                // 5. Tắt CSRF (tạm thời để test)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    // 6. Dùng NoOpPasswordEncoder để hỗ trợ mật khẩu chưa mã hóa
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}