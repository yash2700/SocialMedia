package com.apiwiz.Social.Media.repository;

import com.apiwiz.Social.Media.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {}
