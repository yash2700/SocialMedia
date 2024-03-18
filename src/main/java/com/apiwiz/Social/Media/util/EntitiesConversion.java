package com.apiwiz.Social.Media.util;

import com.apiwiz.Social.Media.model.Friend;
import com.apiwiz.Social.Media.model.Post;
import com.apiwiz.Social.Media.model.Reaction;
import com.apiwiz.Social.Media.model.User;
import com.apiwiz.Social.Media.request.FriendRequestDto;
import com.apiwiz.Social.Media.request.PostDto;
import com.apiwiz.Social.Media.request.ReactionDto;
import com.apiwiz.Social.Media.request.UserDto;

public class EntitiesConversion {

  public static Friend toFriend(FriendRequestDto friendRequestDto) {
    return Friend.builder()
        .friendName(friendRequestDto.getToUser())
        .userName(friendRequestDto.getUserName())
        .build();
  }

  public static User toUser(UserDto userDto) {
    return User.builder()
        .userName(userDto.getUsername())
        .bio(userDto.getBio())
        .age(userDto.getAge())
        .emailId(userDto.getEmailId())
        .fullName(userDto.getFullName())
        .interests(userDto.getInterests())
        .location(userDto.getLocation())
        .gender(userDto.getGender())
        .password(userDto.getPassword())
        .phoneNumber(userDto.getPhoneNumber())
        .build();
  }

  public static Post toPost(PostDto postDto) {
    return Post.builder()
        .postedBy(postDto.getPostedBy())
        .postDescription(postDto.getPostDescription())
        .privacyStatus(postDto.getPrivacyStatus())
        .build();
  }

  public static Reaction toReaction(ReactionDto reactionDto) {
    return Reaction.builder().reactionType(reactionDto.getReactionType()).build();
  }
}
