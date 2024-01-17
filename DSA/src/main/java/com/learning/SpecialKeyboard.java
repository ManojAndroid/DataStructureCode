package com.learning;

public class SpecialKeyboard {
    static int optimalKeys(int n){
        // The optimal string length
        // is N when N is smaller than 6
        if(n<=6)
            return n;


        // TRY ALL POSSIBLE BREAK-POINTS
        // For any keystroke N, we need
        // to loop from N-3 keystrokes
        // back to 1 keystroke to find
        // a breakpoint 'b' after which
        // we will have Ctrl-A, Ctrl-C
        // and then only Ctrl-V all the way.
        int max=0;
        int b;
        for(b=n-3;b>=1;b--)
        {
            int current=(n-b-1)*optimalKeys(b); // If the breakpoint is s
            // at b'th keystroke then
            // the optimal string would
            // have length (n-b-1)*screen[b-1];
            if(current>max)
                max=current;
        }
        return max;
    }

    public static void main(String[] args) {
        int n=11;
        System.out.println("Maximum Number of A's with "+n+" keystrokes is "+optimalKeys(n));
    }
}
