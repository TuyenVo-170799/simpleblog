package com.javaweb.simpleblog.service;

import com.javaweb.simpleblog.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();
}
