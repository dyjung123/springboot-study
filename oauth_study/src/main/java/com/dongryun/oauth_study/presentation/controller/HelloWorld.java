package com.dongryun.oauth_study.presentation.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HelloWorld {

  @GetMapping("/hello")
  public String helloWorld() {
    return "hello";
  }
}
