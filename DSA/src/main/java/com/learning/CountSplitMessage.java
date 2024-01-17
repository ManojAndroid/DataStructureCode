package com.learning;

public class CountSplitMessage {

  static int countSplitMessage(String message, int maxCharSize) {
    String[] split = message.split("\\s");
    int result = 1;
    int tempCount = 0;
    for (String temp : split) {
      if (temp.length() > maxCharSize) {
        System.out.println("invalid word and max size");
        return -1;
      }
      tempCount = tempCount + temp.length();
      if (tempCount < maxCharSize) {
        tempCount++;
      } else {
        tempCount = temp.length();
        result = result + 1;
      }
    }
    System.out.println("count : " + result);
    return result;
  }

  public static void main(String[] args) {
    String value = "IT IS NOT NECESSARY FOR THIS SERVICE TO BE PERFORMED IN THIS SETTING";
    int maxCharSize = 6;
    countSplitMessage(value, maxCharSize);
  }
}


