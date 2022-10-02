package com.example.springawswebservice.web.dto;

import com.example.springawswebservice.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResDto {

    private Long postsId;

    private String title;

    private String content;

    private String author;

    public PostsResDto(Posts entity) {
        this.postsId = entity.getPostsId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
