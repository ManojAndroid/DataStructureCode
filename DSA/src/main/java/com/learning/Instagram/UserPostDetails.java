package com.learning.Instagram;

import java.time.LocalDateTime;

public class UserPostDetails {

  private int userId;
  private String postName;
  private LocalDateTime postTime;
  private String postData;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getPostName() {
    return postName;
  }

  public void setPostName(String postName) {
    this.postName = postName;
  }

  public LocalDateTime getPostTime() {
    return postTime;
  }

  public void setPostTime(LocalDateTime postTime) {
    this.postTime = postTime;
  }

  public String getPostData() {
    return postData;
  }

  public void setPostData(String postData) {
    this.postData = postData;
  }

  @Override
  public String toString() {
    return "UserPostDetails{" +
        "userId=" + userId +
        ", postName='" + postName + '\'' +
        ", postTime=" + postTime +
        ", postData='" + postData + '\'' +
        '}';
  }
}
