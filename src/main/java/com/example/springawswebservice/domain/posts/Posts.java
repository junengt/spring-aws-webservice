package com.example.springawswebservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_id")
    private Long postsId;

    @Column(name = "posts_title", length = 500, nullable = false)
    private String title;

    @Column(name = "posts_content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "posts_author")
    private String author;

    @Builder //빌더 패턴을 이용한 생성자
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}