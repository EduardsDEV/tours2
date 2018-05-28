package com.example.demo.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()// this is to allow adding a file
                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
                .antMatchers("/", "/css/**", "/js/**" ).permitAll()
                .antMatchers("/login*").anonymous()
                .antMatchers("/user/**").access("hasRole(\"ROLE_USER\")or hasRole(\"ROLE_ADMIN\")")
                .antMatchers("/admin/**").access("hasRole(\"ROLE_ADMIN\")")
                .antMatchers("/actuator/**").access("hasRole(\"ROLE_ACTUATOR\")")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
//                .logout().logoutSuccessUrl("/login")
                .logout()
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
                "select username,password,enabled from accounts where username=?")
                .authoritiesByUsernameQuery(
                        "select b.username, a.role_name from roles a, accounts b where b.username=? and a.id=b.role_id");

    }
}