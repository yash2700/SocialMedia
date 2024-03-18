package com.apiwiz.Social.Media.request;

import com.apiwiz.Social.Media.enums.PrivacyStatus;
import com.apiwiz.Social.Media.model.Comment;
import com.apiwiz.Social.Media.model.Reaction;
import com.apiwiz.Social.Media.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private String id;

    private String postedBy;
    private String postDescription;
    private String imagesS3Url;
    private String videosS3Url;
    private PrivacyStatus privacyStatus;
    private List<Comment> comments;
    private List<Reaction> reactions;
}
