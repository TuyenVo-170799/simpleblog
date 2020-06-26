package com.javaweb.simpleblog.converter;

import com.javaweb.simpleblog.dto.PostDTO;
import com.javaweb.simpleblog.entity.PostEntity;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public PostDTO toDTO(PostEntity postEntity) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postEntity.getId());
        postDTO.setTitle(postEntity.getTitle());
        postDTO.setShortDescription(postEntity.getShortDescription());
        postDTO.setContent(postEntity.getContent());
        postDTO.setThumbnail(postEntity.getThumbnail());
        postDTO.setCreatedDate(postEntity.getCreatedDate());
        postDTO.setCreatedBy(postEntity.getCreatedBy());
        postDTO.setModifiedDate(postEntity.getModifiedDate());
        postDTO.setModifiedBy(postEntity.getModifiedBy());
        return postDTO;
    }

    public PostEntity toEntity(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setShortDescription(postDTO.getShortDescription());
        postEntity.setContent(postDTO.getContent());
        postEntity.setThumbnail(postDTO.getThumbnail());
        postEntity.setCreatedDate(postDTO.getCreatedDate());
        postEntity.setCreatedBy(postDTO.getCreatedBy());
        postEntity.setModifiedDate(postDTO.getModifiedDate());
        postEntity.setModifiedBy(postDTO.getModifiedBy());
        return postEntity;
    }
}
