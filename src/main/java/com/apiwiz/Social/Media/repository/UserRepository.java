package com.apiwiz.Social.Media.repository;

import com.apiwiz.Social.Media.model.User;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  boolean existsUserByUserNameOrEmailId(String userName, String emailId);

  List<User> findAllByUserNameIn(Set<String> userNames);
}
