package com.apiwiz.Social.Media.request;

import com.apiwiz.Social.Media.model.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String username;
    private String emailId;
    private String password;
    private String bio;
    private String fullName;
    private String phoneNumber;
    private int age;
    private String location;
    private String gender;
    private List<String> interests;
    private byte[] image;

}
