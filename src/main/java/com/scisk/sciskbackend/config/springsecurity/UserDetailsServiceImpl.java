package com.scisk.sciskbackend.config.springsecurity;

import com.scisk.sciskbackend.entity.User;
import com.scisk.sciskbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = userRepository.existsByEmail(username);
        if (userList.isEmpty()) {
            throw new UsernameNotFoundException("user.not.found.by.email=" + username);
        }
        return UserDetailsImpl.build(userList.get(0));
    }
}
