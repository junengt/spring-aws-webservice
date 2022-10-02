package com.example.springawswebservice.service.posts;

import com.example.springawswebservice.repository.posts.PostsRepository;
import com.example.springawswebservice.web.dto.PostsSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveReqDto reqDto) {
        return postsRepository.save(reqDto.toEntity()).getPostsId();
    }
}
