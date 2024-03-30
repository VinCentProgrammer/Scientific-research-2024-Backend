package com.dungken.scientificresearch2024backend.controller;

import com.dungken.scientificresearch2024backend.dto.PostRequest;
import com.dungken.scientificresearch2024backend.dto.UserRequest;
import com.dungken.scientificresearch2024backend.service.AccountService;
import com.dungken.scientificresearch2024backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody PostRequest postRequest){

    }
}
