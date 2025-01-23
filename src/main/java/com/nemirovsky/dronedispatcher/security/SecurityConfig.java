package com.nemirovsky.dronedispatcher.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // конфигурационный класс, источник бинов
@EnableWebSecurity // безопасность,
public class SecurityConfig {
    // определение пользователей в памяти, доступно для аутентификации, кодиование паролей
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("password1"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("password2"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin1")
                .password(passwordEncoder().encode("password1"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }
    // безопасность запросов, базовая аутентификация, нужна роль юзер, перенаправление
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/**")
                .hasRole("USER")
                .and()
                .formLogin()
                .defaultSuccessUrl("/drones", true);
        ;
        return http.build();
    }
    // хэширование паролей
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}