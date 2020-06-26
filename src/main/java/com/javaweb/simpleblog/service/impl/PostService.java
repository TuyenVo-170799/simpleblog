package com.javaweb.simpleblog.service.impl;

import com.javaweb.simpleblog.converter.PostConverter;
import com.javaweb.simpleblog.dto.PostDTO;
import com.javaweb.simpleblog.entity.PostEntity;
import com.javaweb.simpleblog.repository.CategoryRepository;
import com.javaweb.simpleblog.repository.PostRepository;
import com.javaweb.simpleblog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostConverter postConverter;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<PostDTO> findAll() {
        List<PostEntity> postEntities = postRepository.findAll();
        List<PostDTO> postDTOS = new ArrayList<>();
        for(PostEntity entity: postEntities) {
            PostDTO postDTO = postConverter.toDTO(entity);
            postDTO.setCategoryName(entity.getCategory().getName());
            postDTOS.add(postDTO);
        }
        return postDTOS;
    }

    @Override
    public PostDTO findById(Long id) {
        return null;
    }

    @Override
    public PostDTO save(PostDTO postDTO) {
        PostEntity postEntity = postConverter.toEntity(postDTO);
        postEntity.setCategory(categoryRepository.findByName(postDTO.getCategoryName()));
        postRepository.save(postEntity);
        return postConverter.toDTO(postEntity);
    }
}
