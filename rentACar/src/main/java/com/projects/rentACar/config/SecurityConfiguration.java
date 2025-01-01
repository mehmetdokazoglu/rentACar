package com.projects.rentACar.config;

import com.projects.rentACar.config.filter.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity){ // varsayılan yapılandırmayı değiştirmek için

        try {
            httpSecurity.csrf(customizer -> customizer.disable());//csrf'i devre dışı bırakmak için
            httpSecurity.authorizeHttpRequests(request -> request
                    .requestMatchers(HttpMethod.POST,
                            "api/customers/register", "api/admins/register", "api/customers/login", "api/admins/login", "api/sellers/register", "api/sellers/login")// register olurken herhangi bir doğrulama yapmamak için
                    .permitAll()
                    .anyRequest()
                    .authenticated()); // her bir istek için kimlik doğrulamayı etkinleştir
            httpSecurity.httpBasic(Customizer.withDefaults()); // kimlik doğrulamayı etkinleştirir
            httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
            return httpSecurity.build();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){

        try {
           return authenticationConfiguration.getAuthenticationManager();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

//    @Bean
//    UserDetailsService userDetailsService(){
//
//        UserDetails user = User.withDefaultPasswordEncoder().username("mehmet").password("12300").build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
