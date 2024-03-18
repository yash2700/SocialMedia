package com.apiwiz.Social.Media.model;

import com.apiwiz.Social.Media.enums.ReactionType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "reactions")
public class Reaction {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  @Enumerated(EnumType.STRING)
  private ReactionType reactionType;

  @ManyToOne
  @JoinColumn(name = "user_name")
  private User user;
  @ManyToOne
  @JoinColumn(name = "message_id")
  private Message message;
}
