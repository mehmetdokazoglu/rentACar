package com.projects.rentACar.business.implement;

import com.projects.rentACar.dtos.AdminDto;
import com.projects.rentACar.dtos.CustomerDto;
import com.projects.rentACar.dtos.SellerDto;
import com.projects.rentACar.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public String verify(UserDto userDto) {

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
        if (authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            return jwtService.generateToken(userDto.getEmail());
        }
        return "Login Failed";
    }
}
