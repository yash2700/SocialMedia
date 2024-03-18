package com.apiwiz.Social.Media.repository;

import com.apiwiz.Social.Media.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, String> {}
