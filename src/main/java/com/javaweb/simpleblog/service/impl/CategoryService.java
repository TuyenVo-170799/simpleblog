package com.javaweb.simpleblog.service.impl;

import com.javaweb.simpleblog.converter.CategoryConverter;
import com.javaweb.simpleblog.dto.CategoryDTO;
import com.javaweb.simpleblog.entity.CategoryEntity;
import com.javaweb.simpleblog.repository.CategoryRepository;
import com.javaweb.simpleblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for(CategoryEntity categoryEntity: categoryEntities) {
            categoryDTOS.add(categoryConverter.toDTO(categoryEntity));
        }
        return categoryDTOS;
    }

}
