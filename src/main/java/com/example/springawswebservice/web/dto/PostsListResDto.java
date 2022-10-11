package com.example.springawswebservice.web.dto;

import com.example.springawswebservice.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResDto {

    private Long postsId;

    private String title;

    private String author;

    private LocalDateTime modifiedDate;

    public PostsListResDto(Posts entity) {
        this.postsId = entity.getPostsId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
