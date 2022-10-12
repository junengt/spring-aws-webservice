package com.example.springawswebservice.service.posts;

import com.example.springawswebservice.domain.posts.Posts;
import com.example.springawswebservice.repository.posts.PostsRepository;
import com.example.springawswebservice.web.dto.PostsListResDto;
import com.example.springawswebservice.web.dto.PostsResDto;
import com.example.springawswebservice.web.dto.PostsSaveReqDto;
import com.example.springawswebservice.web.dto.PostsUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    //Posts 등록
    @Transactional
    public Long save(PostsSaveReqDto reqDto) {
        return postsRepository.save(reqDto.toEntity()).getPostsId();
    }

    //Posts 수정 + 더티 체킹
    @Transactional
    public Long update(Long postsId, PostsUpdateReqDto reqDto) {
        Posts posts = postsRepository.findById(postsId).orElseThrow(() ->
                new IllegalStateException("해당 게시물이 없습니다. id=" + postsId));

        posts.update(reqDto.getTitle(), reqDto.getContent());
        return postsId;
    }

    //Posts 단건 조회
    public PostsResDto findById(Long postsId) {
        Posts posts = postsRepository.findById(postsId).orElseThrow(() ->
                new IllegalStateException("해당 게시물이 없습니다. id=" + postsId));

        return new PostsResDto(posts);
    }

    //Posts 전부 조회
    public List<PostsListResDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(p -> new PostsListResDto(p)).toList();
    }

    //Posts 단건 삭제
    @Transactional
    public void delete(Long postsId) {
        Posts posts = postsRepository.findById(postsId).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + postsId));
        postsRepository.delete(posts);
    }
}
