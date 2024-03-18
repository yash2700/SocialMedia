package com.apiwiz.Social.Media.service;

import com.apiwiz.Social.Media.exceptions.StandardException;
import com.apiwiz.Social.Media.model.Friend;
import com.apiwiz.Social.Media.model.User;
import com.apiwiz.Social.Media.repository.FriendRepository;
import com.apiwiz.Social.Media.repository.FriendRequestRepository;
import com.apiwiz.Social.Media.repository.UserRepository;
import com.apiwiz.Social.Media.request.UserDto;
import com.apiwiz.Social.Media.util.DtosConversion;
import com.apiwiz.Social.Media.util.ExceptionConstants;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
  private final FriendRepository friendRepository;
  private final UserRepository userRepository;
  private final FriendRequestRepository friendRequestRepository;

  public FriendService(
      FriendRepository friendRepository,
      UserRepository userRepository,
      FriendRequestRepository friendRequestRepository) {
    this.friendRepository = friendRepository;
    this.userRepository = userRepository;
    this.friendRequestRepository = friendRequestRepository;
  }

  public List<UserDto> getFriends(String userName) {
    List<Friend> friends = friendRepository.findAllByUserNameOrFriendName(userName, userName);
    List<User> friendsList =
        userRepository.findAllByUserNameIn(
            friends.stream()
                .map(
                    friend -> {
                      if (friend.getUserName().equalsIgnoreCase(userName)) {
                        return friend.getFriendName();
                      } else {
                        return friend.getUserName();
                      }
                    })
                .collect(Collectors.toSet()));
    return friendsList.stream().map(DtosConversion::getUserDto).collect(Collectors.toList());
  }

  public String unfriend(String userName, String friendName) {
    Friend friend = friendRepository.findByUserNameOrFriendName(userName, friendName);
    if (ObjectUtils.isEmpty(friend)) {
      throw new StandardException(ExceptionConstants._19004);
    }
    if (friendRequestRepository.existsFriendRequestByUserNameAndToUser(userName, friendName)) {
      friendRequestRepository.deleteByUserNameAndToUser(userName, friendName);
    }
    friendRepository.deleteByUserNameAndFriendName(userName, friendName);
    return "Success";
  }
}
