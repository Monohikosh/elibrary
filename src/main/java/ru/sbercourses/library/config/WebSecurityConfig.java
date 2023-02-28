package ru.sbercourses.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.sbercourses.library.service.userDetails.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(CustomUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Конфигурация прав доступа пользователей
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                // Page which public for all
                .antMatchers("/login",
                        "/users/registration",
                        "/users/remember-password",
                        "/users/change-password/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/**"
                        /*, "/static/**", "/js/**", "/static/images/**", "/webjars/**" */)
                .permitAll()
                // All other page need authentication
                .antMatchers("/authors/**").hasAnyRole("ADMIN", "USER", "LIBRARIAN") // authors доступен всем представленным ролям
                .antMatchers("/books/**").hasAnyRole("ADMIN", "USER", "LIBRARIAN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // Setting for login (входа) in system
                .loginPage("/login")
                // Redirect in head page after successful login
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                // Перенаправление после выхода
                .logoutSuccessUrl("/login");
        return http.build();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

}
