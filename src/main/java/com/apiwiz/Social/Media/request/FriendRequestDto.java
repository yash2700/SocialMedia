package com.apiwiz.Social.Media.request;

import com.apiwiz.Social.Media.enums.FriendRequestStatus;
import com.apiwiz.Social.Media.model.FriendRequest;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendRequestDto {
  private Timestamp timestamp;
  private String userName;
  private String toUser;
  private FriendRequestStatus status;

  public static FriendRequest toEntity(FriendRequestDto friendRequestDto) {
    return FriendRequest.builder()
        .status(FriendRequestStatus.PENDING)
        .toUser(friendRequestDto.getToUser())
        .userName(friendRequestDto.getUserName())
        .timestamp(friendRequestDto.getTimestamp())
        .build();
  }

  public static FriendRequest updateEntity(FriendRequestDto friendRequestDto) {
    return FriendRequest.builder()
        .status(friendRequestDto.getStatus())
        .toUser(friendRequestDto.getToUser())
        .userName(friendRequestDto.getUserName())
        .timestamp(friendRequestDto.getTimestamp())
        .build();
  }
}
