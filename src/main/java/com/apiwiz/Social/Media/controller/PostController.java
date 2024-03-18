package com.apiwiz.Social.Media.controller;

import com.apiwiz.Social.Media.request.PostDto;
import com.apiwiz.Social.Media.request.ReactionDto;
import com.apiwiz.Social.Media.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/post")
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping("/create")
  public ResponseEntity createPost(
      @ModelAttribute PostDto postDto,
      @RequestPart MultipartFile image,
      @RequestPart MultipartFile video) {
    return ResponseEntity.ok(postService.createPost(postDto));
  }

  @PutMapping("/update")
  public ResponseEntity updatePost(
      @ModelAttribute PostDto postDto,
      @RequestPart MultipartFile image,
      @RequestPart MultipartFile video) {
    return ResponseEntity.ok(postService.updatePost(postDto));
  }

  @GetMapping("/getById/{postId}")
  public ResponseEntity getPostById(@PathVariable("postId") String postId) {
    return ResponseEntity.ok(postService.getPostById(postId));
  }

  @PostMapping("/addReaction")
  public ResponseEntity addReaction(@RequestBody ReactionDto reactionDto) {
    return ResponseEntity.ok(postService.addReaction(reactionDto));
  }
  
}
