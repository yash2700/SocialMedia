package com.apiwiz.Social.Media.service;

import com.apiwiz.Social.Media.enums.FriendRequestStatus;
import com.apiwiz.Social.Media.exceptions.StandardException;
import com.apiwiz.Social.Media.model.Friend;
import com.apiwiz.Social.Media.model.FriendRequest;
import com.apiwiz.Social.Media.repository.FriendRepository;
import com.apiwiz.Social.Media.repository.FriendRequestRepository;
import com.apiwiz.Social.Media.request.FriendRequestDto;
import com.apiwiz.Social.Media.util.EntitiesConversion;
import com.apiwiz.Social.Media.util.ExceptionConstants;
import org.springframework.stereotype.Service;

@Service
public class FriendshipService {
  private final FriendRequestRepository friendRequestRepository;
  private final FriendRepository friendRepository;

  public FriendshipService(
      FriendRequestRepository friendRequestRepository, FriendRepository friendRepository) {
    this.friendRequestRepository = friendRequestRepository;
    this.friendRepository = friendRepository;
  }

  public FriendRequestDto sendFriendRequest(FriendRequestDto friendRequestDto) {
    if (friendRequestRepository.existsFriendRequestByUserNameAndToUser(
        friendRequestDto.getUserName(), friendRequestDto.getToUser())) {
      throw new StandardException(ExceptionConstants._19002);
    }
    FriendRequest request = FriendRequestDto.toEntity(friendRequestDto);
    friendRequestRepository.save(request);
    friendRequestDto.setStatus(request.getStatus());
    return friendRequestDto;
  }

  public FriendRequestDto updateFriendship(FriendRequestDto friendRequestDto) {
    if (!friendRequestRepository.existsFriendRequestByUserNameAndToUser(
        friendRequestDto.getToUser(), friendRequestDto.getUserName())) {
      throw new StandardException(ExceptionConstants._19003);
    }
    FriendRequest friendRequest =
        friendRequestRepository.findByUserNameAndToUser(
            friendRequestDto.getUserName(), friendRequestDto.getToUser());
    switch (friendRequestDto.getStatus()) {
      case FriendRequestStatus.REJECTED -> {
        friendRequestDto.setStatus(FriendRequestStatus.REJECTED);
        friendRequest = FriendRequestDto.updateEntity(friendRequestDto);
        friendRequestRepository.save(friendRequest);
      }
      case FriendRequestStatus.ACCEPTED -> {
        friendRequestDto.setStatus(FriendRequestStatus.ACCEPTED);
        friendRequest = FriendRequestDto.updateEntity(friendRequestDto);
        friendRequestRepository.save(friendRequest);
        Friend friend = EntitiesConversion.toFriend(friendRequestDto);
        friendRepository.save(friend);
      }
    }
    return friendRequestDto;
  }
}
