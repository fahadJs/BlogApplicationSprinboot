package com.bloggingapplicationspringboot.services;

import com.bloggingapplicationspringboot.payloads.PostDto;

import java.util.List;
import java.util.UUID;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    List<PostDto> getAllPost();

    PostDto getPostById(Integer postId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> getPostByUser(Integer userId);
}
