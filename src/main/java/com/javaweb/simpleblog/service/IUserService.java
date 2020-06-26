package com.javaweb.simpleblog.service;

import com.javaweb.simpleblog.dto.UserDTO;


public interface IUserService {

    UserDTO findByUserName(String userName);
}
