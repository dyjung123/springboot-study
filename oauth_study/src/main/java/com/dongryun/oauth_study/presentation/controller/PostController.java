package com.dongryun.oauth_study.presentation.controller;

import com.dongryun.oauth_study.application.service.PostService;
import com.dongryun.oauth_study.presentation.controller.model.PostFormModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PostController {
  private final PostService postService;

  @GetMapping("/post")
  public String getPostListPage(@RequestParam(defaultValue = "10") int limit,
      @RequestParam(defaultValue = "0") int offset, Model model) {
    return "pagination";
  }

  @PostMapping("/post")
  public String createPost(PostFormModel postFormModel) {
    postService.create();
    return "pagination";
  }
}
