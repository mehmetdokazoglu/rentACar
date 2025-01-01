package com.projects.rentACar.business.userDetailsServiceImplement;

import com.projects.rentACar.entities.User;
import com.projects.rentACar.entities.UserDetailsImplement;
import com.projects.rentACar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplement implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Bu emaile ait kullanici bulunamadi" + email));

        return new UserDetailsImplement(user);

    }
}
