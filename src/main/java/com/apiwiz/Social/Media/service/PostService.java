package com.apiwiz.Social.Media.service;

import com.apiwiz.Social.Media.exceptions.StandardException;
import com.apiwiz.Social.Media.model.Post;
import com.apiwiz.Social.Media.model.Reaction;
import com.apiwiz.Social.Media.model.User;
import com.apiwiz.Social.Media.repository.PostRepository;
import com.apiwiz.Social.Media.repository.ReactionRepository;
import com.apiwiz.Social.Media.repository.UserRepository;
import com.apiwiz.Social.Media.request.PostDto;
import com.apiwiz.Social.Media.request.ReactionDto;
import com.apiwiz.Social.Media.util.DtosConversion;
import com.apiwiz.Social.Media.util.EntitiesConversion;
import com.apiwiz.Social.Media.util.ExceptionConstants;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private final PostRepository postRepository;
  private final UserRepository userRepository;
  private final ReactionRepository reactionRepository;

  public PostService(
      PostRepository postRepository, UserRepository userRepository, ReactionRepository repository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
    this.reactionRepository = repository;
  }

  public PostDto createPost(PostDto postDto) {
    Post post = EntitiesConversion.toPost(postDto);
    post.setComments(new ArrayList<>());
    post.setReactions(new ArrayList<>());
    postRepository.save(post);
    postDto.setId(post.getId());
    return postDto;
  }

  public PostDto updatePost(PostDto postDto) {
    Optional<Post> optionalPost = postRepository.findById(postDto.getId());
    if (!optionalPost.isPresent()) {
      throw new StandardException(ExceptionConstants._19004);
    }
    Post post = optionalPost.get();
    post.setPostDescription(postDto.getPostDescription());
    post.setImagesS3Url(postDto.getImagesS3Url());
    post.setVideosS3Url(postDto.getVideosS3Url());
    postRepository.save(post);
    return postDto;
  }

  public PostDto getPostById(String postId) {
    Optional<Post> optionalPost = postRepository.findById(postId);
    if (optionalPost.isEmpty()) throw new StandardException(ExceptionConstants._19004);
    PostDto postDto = DtosConversion.getPostDto(optionalPost.get());
    return postDto;
  }

  public ReactionDto addReaction(ReactionDto reactionDto) {
    Reaction reaction = EntitiesConversion.toReaction(reactionDto);
    Optional<Post> optionalPost = postRepository.findById(reactionDto.getPostId());
    if (optionalPost.isEmpty()) throw new StandardException(ExceptionConstants._19005);
    Optional<User> optionalUser = userRepository.findById(reactionDto.getUserId());
    if (optionalUser.isEmpty()) throw new StandardException(ExceptionConstants._19001);
    reaction.setPost(optionalPost.get());
    reaction.setUser(optionalUser.get());
    reactionRepository.save(reaction);
    reactionDto.setId(reaction.getId());
    return reactionDto;
  }
}
