package com.example.springawswebservice.web.controller;

import com.example.springawswebservice.service.posts.PostsService;
import com.example.springawswebservice.web.dto.PostsResDto;
import com.example.springawswebservice.web.dto.PostsSaveReqDto;
import com.example.springawswebservice.web.dto.PostsUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //Posts 등록 API
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveReqDto reqDto) {
        return postsService.save(reqDto);
    }

    //Posts 수정 API
    @PutMapping("/api/v1/posts/{postsId}")
    public Long update(@PathVariable Long postsId, @RequestBody PostsUpdateReqDto reqDto) {
        return postsService.update(postsId, reqDto);
    }

    //Posts 단건 조회 API
    @GetMapping("/api/v1/posts/{postsId}")
    public PostsResDto findById(@PathVariable Long postsId) {
        return postsService.findById(postsId);
    }
}
