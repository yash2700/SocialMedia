package com.apiwiz.Social.Media.util;

import com.apiwiz.Social.Media.model.Post;
import com.apiwiz.Social.Media.model.User;
import com.apiwiz.Social.Media.request.PostDto;
import com.apiwiz.Social.Media.request.UserDto;

public class DtosConversion {
  public static UserDto getUserDto(User user) {
    return UserDto.builder()
        .phoneNumber(user.getPhoneNumber())
        .username(user.getUserName())
        .password(user.getPassword())
        .gender(user.getGender())
        .location(user.getLocation())
        .interests(user.getInterests())
        .age(user.getAge())
        .bio(user.getBio())
        .emailId(user.getEmailId())
        .image(user.getImageS3Url().getBytes())
        .fullName(user.getFullName())
        .build();
  }

  public static PostDto getPostDto(Post post) {
    return PostDto.builder()
        .id(post.getId())
        .postedBy(post.getPostedBy())
        .postDescription(post.getPostDescription())
        .imagesS3Url(post.getImagesS3Url())
        .videosS3Url(post.getVideosS3Url())
        .comments(post.getComments())
        .reactions(post.getReactions())
        .build();
  }
}
