package com.apiwiz.Social.Media.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String emailId;
    private String password;
    private String bio;
    private String fullName;
    private String phoneNumber;
    private int age;
    private String location;
    private String gender;
    private List<String> interests;
    private String imageS3Url;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Reaction> reactions;
    @ManyToMany(mappedBy = "users")
    private List<Group> groups;
}
