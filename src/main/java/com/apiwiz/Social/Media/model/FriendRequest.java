package com.apiwiz.Social.Media.model;

import com.apiwiz.Social.Media.enums.FriendRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FriendRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  private Timestamp timestamp;

  @Enumerated(value = EnumType.STRING)
  private FriendRequestStatus status;

  private String userName;
  private String toUser;
}
