package com.bloggingapplicationspringboot.controllers;

import com.bloggingapplicationspringboot.payloads.PostDto;
import com.bloggingapplicationspringboot.payloads.PostRequestDto;
import com.bloggingapplicationspringboot.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

//    POST METHOD CREATE POST
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostRequestDto postRequestDto){
        PostDto createdPost = this.postService.createPost(postRequestDto);
        return ResponseEntity.created(URI.create("/api/posts/" + createdPost.getId())).body(createdPost);
    }

//    GET METHOD GET ALL POSTS
    @GetMapping("/posts/")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> allPosts = this.postService.getAllPost();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

}
