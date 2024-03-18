package com.apiwiz.Social.Media.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "user_group")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  @ManyToMany
  private List<User> users;
}
