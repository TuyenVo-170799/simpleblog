package com.javaweb.simpleblog.service.impl;

import com.javaweb.simpleblog.entity.RoleEntity;
import com.javaweb.simpleblog.entity.UserEntity;
import com.javaweb.simpleblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username);
        if(userEntity == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(RoleEntity role: userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        UserDetails userDetails = new User(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
        return userDetails;
    }
}
