package com.javaweb.simpleblog.converter;

import com.javaweb.simpleblog.dto.CategoryDTO;
import com.javaweb.simpleblog.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDTO toDTO(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setCode(categoryEntity.getCode());
        return categoryDTO;
    }
}
