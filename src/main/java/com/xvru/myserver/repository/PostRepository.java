package com.xvru.myserver.repository;

import com.xvru.myserver.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
