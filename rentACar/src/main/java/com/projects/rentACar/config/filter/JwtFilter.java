package com.projects.rentACar.config.filter;

import com.projects.rentACar.business.implement.JwtService;
import com.projects.rentACar.business.userDetailsServiceImplement.UserDetailsServiceImplement;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImplement userDetailsServiceImplement;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       String authenticationHeader =  request.getHeader("Authorization");
       String token = null;
       String email = null;

       if(authenticationHeader != null && authenticationHeader.startsWith("Bearer ")){
           token = authenticationHeader.substring(7);
           email = jwtService.extractEmail(token);
       }
       if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){

           UserDetails userDetails = userDetailsServiceImplement.loadUserByUsername(email);

           if(jwtService.validateToken(token, userDetails)){

               UsernamePasswordAuthenticationToken authenticationToken =
                       new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
               authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(authenticationToken);
           }
       }
       filterChain.doFilter(request, response);
    }
}
