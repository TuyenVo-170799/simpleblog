package com.javaweb.simpleblog.validation;

import com.javaweb.simpleblog.dto.PostDTO;
import com.javaweb.simpleblog.entity.PostEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PostEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostDTO postDTO = (PostDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortDescription", "field.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "field.empty");
    }
}
