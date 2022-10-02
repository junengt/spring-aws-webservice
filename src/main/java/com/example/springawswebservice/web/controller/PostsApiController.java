package com.example.springawswebservice.web.controller;

import com.example.springawswebservice.service.posts.PostsService;
import com.example.springawswebservice.web.dto.PostsSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveReqDto reqDto) {
        return postsService.save(reqDto);
    }

}
