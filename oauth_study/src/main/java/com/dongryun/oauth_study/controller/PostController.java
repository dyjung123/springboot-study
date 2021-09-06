package com.dongryun.oauth_study.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PostController {

  @GetMapping("/post")
  public String getPostListPage(@RequestParam(defaultValue = "10") int limit,
      @RequestParam(defaultValue = "0") int offset, Model model) {
    return "pagination";
  }
}
