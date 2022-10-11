package com.example.springawswebservice.repository.posts;

import com.example.springawswebservice.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p from posts p order by p.postsId desc ")
    List<Posts> findAllDesc();
}
