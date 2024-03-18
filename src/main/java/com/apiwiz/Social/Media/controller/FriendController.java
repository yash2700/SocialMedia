package com.apiwiz.Social.Media.controller;

import com.apiwiz.Social.Media.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
public class FriendController {
  private final FriendService friendService;

  public FriendController(FriendService friendService) {
    this.friendService = friendService;
  }

  @GetMapping("/getAll/{userName}")
  public ResponseEntity getAllFriends(@PathVariable("userName") String userName) {
    return ResponseEntity.ok(friendService.getFriends(userName));
  }

  @DeleteMapping("/unfriend/{userName}/{friendName}")
  public ResponseEntity unfriend(
      @PathVariable("userName") String userName, @PathVariable("friendName") String friendName) {
    return ResponseEntity.ok(friendService.unfriend(userName, friendName));
  }
}
