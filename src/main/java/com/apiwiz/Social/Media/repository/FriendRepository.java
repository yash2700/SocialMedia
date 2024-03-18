package com.apiwiz.Social.Media.repository;

import com.apiwiz.Social.Media.model.Friend;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, String> {
  List<Friend> findAllByUserNameOrFriendName(String userName, String friendName);

  Friend findByUserNameOrFriendName(String userName, String friendName);

  void deleteByUserNameAndFriendName(String userName, String friendName);
}
