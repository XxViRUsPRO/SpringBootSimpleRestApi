package com.xvru.myserver.controller;

import com.xvru.myserver.model.Post;
import com.xvru.myserver.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getPost(@PathVariable long id) {
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.addPost(post), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
