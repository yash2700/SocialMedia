package com.apiwiz.Social.Media.service;

import com.apiwiz.Social.Media.exceptions.StandardException;
import com.apiwiz.Social.Media.model.User;
import com.apiwiz.Social.Media.repository.UserRepository;
import com.apiwiz.Social.Media.request.UserDto;
import com.apiwiz.Social.Media.util.EntitiesConversion;
import com.apiwiz.Social.Media.util.ExceptionConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private static final Logger logger = LoggerFactory.getLogger(UserService.class);
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDto createUser(UserDto userDto) {
    if (userRepository.existsUserByUserNameOrEmailId(userDto.getUsername(), userDto.getEmailId())) {
      throw new StandardException(ExceptionConstants._19000);
    }

    userRepository.save(EntitiesConversion.toUser(userDto));
    logger.info("User saved with username {}", userDto.getUsername());
    return userDto;
  }

  public UserDto updateUser(UserDto userDto) {
    if (!userRepository.existsUserByUserNameOrEmailId(
        userDto.getUsername(), userDto.getEmailId())) {
      throw new StandardException(ExceptionConstants._19001);
    }
    User user = updateFromDto(userDto);
    userRepository.save(user);
    logger.info("User updated with username {}", userDto.getUsername());
    return userDto;
  }

  public User updateFromDto(UserDto userDto) {
    User user = new User();
    if (StringUtils.isNotEmpty(userDto.getUsername())) {
      user.setUserName(user.getUserName());
    }
    if (StringUtils.isNotEmpty(userDto.getEmailId())) {
      user.setEmailId(userDto.getEmailId());
    }
    if (StringUtils.isNotEmpty(userDto.getPassword())) {
      user.setPassword(userDto.getPassword());
    }
    if (StringUtils.isNotEmpty(userDto.getBio())) {
      user.setBio(userDto.getBio());
    }
    if (StringUtils.isNotEmpty(userDto.getFullName())) {
      user.setFullName(userDto.getFullName());
    }
    if (StringUtils.isNotEmpty(userDto.getPhoneNumber())) {
      user.setPhoneNumber(userDto.getPhoneNumber());
    }
    // Age is always updated as it's a primitive type
    if (userDto.getAge() > 0) {
      user.setAge(userDto.getAge());
    }
    if (StringUtils.isNotEmpty(userDto.getLocation())) {
      user.setLocation(userDto.getLocation());
    }
    if (StringUtils.isNotEmpty(userDto.getGender())) {
      user.setGender(userDto.getGender());
    }
    if (CollectionUtils.isNotEmpty(userDto.getInterests())) {
      user.setInterests(userDto.getInterests());
    }
    if (userDto.getImage() != null && userDto.getImage().length > 0) {
      user.setImageS3Url(userDto.getImage().toString());
    }
    return user;
  }
}
