package com.apiwiz.Social.Media.request;

import com.apiwiz.Social.Media.enums.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReactionDto {
  private String id;
  private String postId;
  private ReactionType reactionType;
  private String userId;
}
