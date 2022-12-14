package com.example.springawswebservice.web;

import com.example.springawswebservice.config.auth.LoginUser;
import com.example.springawswebservice.config.auth.dto.SessionUser;
import com.example.springawswebservice.service.posts.PostsService;
import com.example.springawswebservice.web.dto.PostsResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{postsId}")
    public String postsUpdate(@PathVariable Long postsId, Model model) {
        PostsResDto dto = postsService.findById(postsId);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
