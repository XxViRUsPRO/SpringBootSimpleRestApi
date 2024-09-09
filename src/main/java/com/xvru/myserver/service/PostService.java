package com.xvru.myserver.service;

import com.xvru.myserver.model.Post;
import com.xvru.myserver.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

interface IPostService {
    List<Post> getPosts();
    Post getPost(long id);
    Post addPost(Post post);
    void deletePost(long id);
}

@Service
public class PostService implements IPostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPost(long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new RuntimeException("Post not found");
        }
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}