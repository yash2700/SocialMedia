package com.apiwiz.Social.Media.controller;

import com.apiwiz.Social.Media.request.UserDto;
import com.apiwiz.Social.Media.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  public ResponseEntity createUser(
      @ModelAttribute UserDto userDto, @RequestPart MultipartFile file) {
    userDto = userService.createUser(userDto);
    return ResponseEntity.ok(userDto);
  }

  @PutMapping("/update")
  public ResponseEntity updateUser(@RequestBody UserDto userDto) {
    userDto = userService.updateUser(userDto);
    return ResponseEntity.ok(userDto);
  }
}
