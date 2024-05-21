package com.metro.authservice.config;

import com.metro.authservice.repository.IAuthRepository;
import com.metro.shared.entity.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IAuthRepository authRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = authRepo.findByEmail(email);
        return user.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found with email: " + email));
    }
}