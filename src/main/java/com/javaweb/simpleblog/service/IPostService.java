package com.javaweb.simpleblog.service;

import com.javaweb.simpleblog.dto.PostDTO;

import java.util.List;

public interface IPostService {

    List<PostDTO> findAll();
    PostDTO findById(Long id);
    PostDTO save(PostDTO postDTO);
}
