package com.example.Springprojects.EmployeesSpring.rest.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig  {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")

        );
        //user basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        //disable cross site request forgery(csrf)
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}

//@Bean
//public InMemoryUserDetailsManager myuserDetailsManager(){
//    UserDetails Ganesh = User.builder()
//            .username("Ganesh")
//            .password("{noop}Gane@2005")
//            .roles("Employee","Manager","Admin")
//            .build();
//
//    UserDetails Jaswanth = User.builder()
//            .username("Jaswanth")
//            .password("{noop}Gane@2005")
//            .roles("Employee")
//            .build();
//
//    UserDetails Hemanth = User.builder()
//            .username("Hemanth")
//            .password("{noop}Gane@2005")
//            .roles("Employee","Manager")
//            .build();
//
//    return new InMemoryUserDetailsManager(Ganesh,Jaswanth,Hemanth);
//}
