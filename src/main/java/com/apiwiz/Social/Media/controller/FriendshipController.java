package com.apiwiz.Social.Media.controller;

import com.apiwiz.Social.Media.request.FriendRequestDto;
import com.apiwiz.Social.Media.service.FriendshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friendRequest")
public class FriendshipController {
  private final FriendshipService friendshipService;

  public FriendshipController(FriendshipService friendshipService) {
    this.friendshipService = friendshipService;
  }

  @PostMapping("/send")
  public ResponseEntity sendFriendRequest(@RequestBody FriendRequestDto dto) {
    return ResponseEntity.ok(friendshipService.sendFriendRequest(dto));
  }

  @PutMapping("/update")
  public ResponseEntity updateFriendRequest(@RequestBody FriendRequestDto friendRequestDto) {
    return ResponseEntity.ok(friendshipService.updateFriendship(friendRequestDto));
  }
}
