package com.learning.Instagram;

import java.util.List;

public interface Instagram {

  void userPost(UserPostDetails userPostDetails);

  List<UserPostDetails> getUserPostDetails(int userId);

  List<FollowUserDetails> getAllFollowUserDetails(int userId);

  void followUser(int loggedInUserId, FollowUserDetails UserPostDetails);

  boolean unFollowUser(int loggedInUserId, FollowUserDetails UserPostDetails);

}
