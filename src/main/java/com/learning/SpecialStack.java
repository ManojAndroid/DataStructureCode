package com.learning;

import java.util.Stack;

public class SpecialStack extends Stack<Integer> {

  Stack<Integer> min = new Stack<>();

  void push(int x) {
    if (super.isEmpty()) {
      super.push(x);
      min.push(x);
    } else {
      super.push(x);
      int y = min.pop();
      min.push(x > y ? y : x);
    }
  }

  public int popElement() {
    int x = super.pop();
    min.pop();
    return x;
  }
  public int getMinElement()
  {
    return min.peek();
    /*int x=min.pop();
    min.push(x);
    return x;*/
  }

  public static void main(String[] args) {
    SpecialStack specialStack=new SpecialStack();
     specialStack.push(2);
    specialStack.push(5);
    specialStack.push(8);
    specialStack.push(17);
    specialStack.push(9);
    specialStack.push(1);

    System.out.println(specialStack.getMinElement());
  }
}
