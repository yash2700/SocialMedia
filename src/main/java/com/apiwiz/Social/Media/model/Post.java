package com.apiwiz.Social.Media.model;

import com.apiwiz.Social.Media.enums.PrivacyStatus;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  private String postedBy;
  private String postDescription;
  private String imagesS3Url;
  private String videosS3Url;

  @Enumerated(value = EnumType.STRING)
  private PrivacyStatus privacyStatus;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private List<Comment> comments;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private List<Reaction> reactions;

  @ManyToOne
  @JoinColumn(name = "user_name")
  private User user;
}
