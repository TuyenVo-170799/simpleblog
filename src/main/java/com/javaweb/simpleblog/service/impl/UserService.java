package com.javaweb.simpleblog.service.impl;

import com.javaweb.simpleblog.dto.UserDTO;
import com.javaweb.simpleblog.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public UserDTO findByUserName(String userName) {
        return null;
    }
}
