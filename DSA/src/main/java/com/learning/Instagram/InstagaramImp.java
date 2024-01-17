package com.learning.Instagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class InstagaramImp implements Instagram {

  Map<Integer, Stack<UserPostDetails>> addUserPostDetails = new HashMap<>();

  Map<Integer, List<FollowUserDetails>> userFollowerDetails = new HashMap<>();

  @Override
  public void userPost(UserPostDetails userPostDetails) {
    Stack<UserPostDetails> userPost = new Stack<>();
    userPost.push(userPostDetails);
    this.addUserPostDetails.put(userPostDetails.getUserId(), userPost);
  }

  @Override
  public List<UserPostDetails> getUserPostDetails(int userId) {
    return this.addUserPostDetails.get(userId);
  }

  @Override
  public List<FollowUserDetails> getAllFollowUserDetails(int userId) {
    return this.userFollowerDetails.get(userId);
  }

  @Override
  public void followUser(int loggedInUserId, FollowUserDetails UserPostDetails) {
    List<FollowUserDetails> followUserDetailsList = userFollowerDetails.get(loggedInUserId);
    if (followUserDetailsList != null && !followUserDetailsList.isEmpty()) {
      followUserDetailsList.add(UserPostDetails);
      userFollowerDetails.put(loggedInUserId, followUserDetailsList);
    } else {
      List<FollowUserDetails> add = new ArrayList<>();
      add.add(UserPostDetails);
      userFollowerDetails.put(loggedInUserId, add);
    }
  }

  @Override
  public boolean unFollowUser(int loggedInUserId, FollowUserDetails followUserDetails) {
    List<FollowUserDetails> followUserDetailsList = userFollowerDetails.get(loggedInUserId);
    if (followUserDetailsList.isEmpty()) {
      System.out.println("user doe not have follower");
      return false;
    } else {
      followUserDetailsList.remove(followUserDetails);
      System.out.println("user unfollowe succefully");
      return true;
    }
  }
}
