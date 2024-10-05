package com.example.SpringSecuritysection4.config;

import com.example.SpringSecuritysection4.constants.ApiConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

/*@EnableWebSecurity
//sprinboot automatically detects spring security no need to add this annotation
//but for spring framework need to add this annotation*/
@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        // http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
        http.csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers(ApiConstants.ACCOUNT.getRequestMatcher(),
                        ApiConstants.CARDS.getRequestMatcher(), ApiConstants.BALANCE.getRequestMatcher()).authenticated()
                .requestMatchers("/notices", "/contact", "error","/register").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

/*
    @Bean
    public UserDetailsService getUserDetailsService() {
        //Bcrypt password encoder is used.
        //user_12345@46
        UserDetails user = User.withUsername("user").password("{bcrypt}$2a$12$t7u97h0ME/HkYswolmXXreOSGYNDxvp0nAZGVWq0SAaVTm2q47S9S")
                .authorities(Roles.ADMIN.getRole()).build();
        //5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5
    */
/*UserDetails user = User.withUsername("user").password("{sha256}5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5")
            .authorities(Roles.ADMIN.getRole()).build();*//*

        //{noop} means no need password encoder treat password as plain text.
        UserDetails user1 = User.withUsername("user1").password("{noop}user_123456").authorities(Roles.EXECUTIVE.getRole()).build();
        return new InMemoryUserDetailsManager(user, user1);// which used to store details in application manager
    }
*/

    /*@Bean
    public UserDetailsService getUserDetailsService(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }*/

    @Bean
    public PasswordEncoder getPasswordEncoder() {
       /* String idForEncode = "sha256";
        Map<String,PasswordEncoder> encoders = new HashMap<>();
        encoders. put("bcrypt", new BCryptPasswordEncoder());
        encoders. put("noop", NoOpPasswordEncoder. getInstance());
        encoders. put(idForEncode, new StandardPasswordEncoder());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
        return passwordEncoder;*/
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public CompromisedPasswordChecker getCompromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}


