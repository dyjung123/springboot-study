package com.dongryun.oauth_study.application.service;

import com.dongryun.oauth_study.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  public Post create() {
    return new Post();
  }
}
