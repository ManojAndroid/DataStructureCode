package com.learning;

public class ConvertNumberToXlsheetColumn {
 /* Time Complexity: O(log26n), as we are using a loop and in each traversal, we decrement by floor division of 26.
  Auxiliary Space: O(50), as we are using extra space for storing the result.*/

  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static void getColumnName(int columnNumber) {
    if (columnNumber <= 0) {
      throw new IllegalArgumentException("Column number must be positive.");
    }
    StringBuilder columnName = new StringBuilder();
    while (columnNumber > 0) {
      int remainder = (columnNumber - 1) % 26;
      columnName.insert(0, ALPHABET.charAt(remainder));
      columnNumber = (columnNumber - 1) / 26;
    }
    System.out.println(columnName);
  }

  public static void main(String[] args) {
    getColumnName(52);
  }

}
