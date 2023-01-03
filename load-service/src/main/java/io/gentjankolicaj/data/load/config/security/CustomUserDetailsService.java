package io.gentjankolicaj.data.load.config.security;

import io.gentjankolicaj.data.load.common.domain.User;
import io.gentjankolicaj.data.load.common.domain.security.CustomUserDetails;
import io.gentjankolicaj.data.load.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        if (user != null) {
            return new CustomUserDetails(user);
        } else {
            return null;
        }

    }
}
