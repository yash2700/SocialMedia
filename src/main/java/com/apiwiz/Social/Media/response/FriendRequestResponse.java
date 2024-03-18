package com.apiwiz.Social.Media.response;

import com.apiwiz.Social.Media.enums.FriendRequestStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FriendRequestResponse {
  private Timestamp timestamp;
  private String userName;
  private String toUser;

  @Enumerated(value = EnumType.STRING)
  private FriendRequestStatus status;
}
