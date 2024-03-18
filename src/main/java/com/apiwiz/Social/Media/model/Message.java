package com.apiwiz.Social.Media.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  private String messageText;

  @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
  private List<Reaction> reactions;
}
