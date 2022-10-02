package com.example.springawswebservice.repository.posts;

import com.example.springawswebservice.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
