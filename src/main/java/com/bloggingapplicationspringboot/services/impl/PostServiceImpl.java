package com.bloggingapplicationspringboot.services.impl;

import com.bloggingapplicationspringboot.entities.Categories;
import com.bloggingapplicationspringboot.entities.Posts;
import com.bloggingapplicationspringboot.entities.Users;
import com.bloggingapplicationspringboot.exceptions.ResourceNotFoundException;
import com.bloggingapplicationspringboot.payloads.PostDto;
import com.bloggingapplicationspringboot.repositories.CategoryRepo;
import com.bloggingapplicationspringboot.repositories.PostRepo;
import com.bloggingapplicationspringboot.repositories.UserRepo;
import com.bloggingapplicationspringboot.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        Users users = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User "," user Id ", userId));
        Categories categories = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", " category Id ", categoryId));
        Posts posts = modelMapper.map(postDto, Posts.class);
        posts.setDateCreated(new Date());
        posts.setImagePath("new.png");
        posts.setCategories(categories);
        posts.setUsers(users);
        Posts savePost = this.postRepo.save(posts);
        return modelMapper.map(savePost, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Posts> postsList = this.postRepo.findAll();

        List<PostDto> postDtoList = postsList.stream()
                .map(posts -> this.postToDto(posts))
                .collect(Collectors.toList());

        return postDtoList;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        return null;
    }

    public Posts dtoToPost(PostDto postDto){
        Posts posts = modelMapper.map(postDto, Posts.class);
        return posts;
    }

    public PostDto postToDto(Posts posts){
        PostDto postDto = modelMapper.map(posts, PostDto.class);
        return postDto;
    }
}
