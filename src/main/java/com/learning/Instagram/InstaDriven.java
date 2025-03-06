package com.learning.Instagram;

import java.time.LocalDateTime;
import java.util.List;

public class InstaDriven {

  public static void main(String[] args) {

    Instagram instagram = new InstagaramImp();
    UserPostDetails userPostDetails1 = new UserPostDetails();
    userPostDetails1.setUserId(1);
    userPostDetails1.setPostData("posting something user 1");
    userPostDetails1.setPostName("something");
    userPostDetails1.setPostTime(LocalDateTime.now());
    System.out.println("posting userPostDetails1 .....");
    instagram.userPost(userPostDetails1);

    UserPostDetails userPostDetails2 = new UserPostDetails();
    userPostDetails2.setUserId(2);
    userPostDetails2.setPostData("posting something user 2");
    userPostDetails2.setPostName("something");
    userPostDetails2.setPostTime(LocalDateTime.now());
    System.out.println("posting userPostDetails2.....");
    instagram.userPost(userPostDetails2);

    UserPostDetails userPostDetails3 = new UserPostDetails();
    userPostDetails3.setUserId(3);
    userPostDetails3.setPostData("posting something user 3");
    userPostDetails3.setPostName("something");
    userPostDetails3.setPostTime(LocalDateTime.now());
    System.out.println("posting userPostDetails3.....");
    instagram.userPost(userPostDetails3);

    UserPostDetails userPostDetails4 = new UserPostDetails();
    userPostDetails4.setUserId(4);
    userPostDetails4.setPostData("posting something user 4");
    userPostDetails4.setPostName("something");
    userPostDetails4.setPostTime(LocalDateTime.now());
    System.out.println("posting userPostDetails4.....");
    instagram.userPost(userPostDetails4);

/*    System.out.println("getting details .....");
    List<UserPostDetails> userdetails = instagram.getUserPostDetails(userPostDetails1.getUserId());*/

    System.out.println("following user 2 .....");
    FollowUserDetails followUserDetails2 = new FollowUserDetails();
    followUserDetails2.setUserId(2);
    followUserDetails2.setUserName("Manoj");
    followUserDetails2.setUserEmail("manojKmarSAI@gmail.com");
    instagram.followUser(userPostDetails1.getUserId(), followUserDetails2);

    System.out.println("following user 3 .....");
    FollowUserDetails followUserDetails3 = new FollowUserDetails();
    followUserDetails3.setUserId(3);
    followUserDetails3.setUserName("Manoj");
    followUserDetails3.setUserEmail("manojKmarSAI@gmail.com");
    instagram.followUser(userPostDetails1.getUserId(), followUserDetails3);


    System.out.println("following user2 to user3 .....");
    FollowUserDetails followUserDetails23 = new FollowUserDetails();
    followUserDetails23.setUserId(3);
    followUserDetails23.setUserName("Manoj");
    followUserDetails23.setUserEmail("manojKmarSAI@gmail.com");
    instagram.followUser(userPostDetails2.getUserId(), followUserDetails23);

    System.out.println("following user3 to user4 .....");
    FollowUserDetails followUserDetails34 = new FollowUserDetails();
    followUserDetails23.setUserId(4);
    followUserDetails23.setUserName("Manoj");
    followUserDetails23.setUserEmail("manojKmarSAI@gmail.com");
    instagram.followUser(userPostDetails3.getUserId(), followUserDetails23);


    List<UserPostDetails>userPostDetails=instagram.getUserPostDetails(3);

    System.out.println(userPostDetails);




  }

}
