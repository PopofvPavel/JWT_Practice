package com.example.lecpractice.service;

import com.example.lecpractice.config.UserInfoUserDetails;
import com.example.lecpractice.entity.UserInfo;
import com.example.lecpractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userInfo = repository.findUserByUsername(username);
        Optional<UserInfo> optionalUserInfo= Optional.ofNullable(userInfo);
        return optionalUserInfo.map(UserInfoUserDetails::new).orElseThrow(() -> new RuntimeException("USer not found"));
    }
}

