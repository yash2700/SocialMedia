package com.apiwiz.Social.Media.repository;

import com.apiwiz.Social.Media.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, String> {
  boolean existsFriendRequestByUserNameAndToUser(String userName, String toUser);

  FriendRequest findByUserNameAndToUser(String userName, String toUser);

  void deleteByUserNameAndToUser(String userName, String toUser);
}
