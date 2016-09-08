package com.encuestas.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String LOGIN_PAGE = "/login";
    private static final String RESOURCES_PATTERN = "/resources/**";
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new Md5PasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
            .authorizeRequests()
            .antMatchers(RESOURCES_PATTERN).permitAll()
            .anyRequest().authenticated()
            .and()
                .formLogin()
                .successHandler(new LoginSuccessHandler())
        .loginPage(LOGIN_PAGE).permitAll().and().logout().permitAll();
    }
}
