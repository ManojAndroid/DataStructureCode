package clientQuestion;

public class BracketReverseToMactch {
    /*Given an expression with only '}' and '{'. The expression may not be balanced. Find min no of bracket reversals to make the expression balanced

    Input: "}{"
    Output: 2

    Input: "{{{"
    Output: N/A*/
    public static  int count(String exp)
    {
        if(exp.length()%2!=0)
            return -1;

        int open=0,close=0;

        for(char ch: exp.toCharArray())
        {
            if(ch=='{')
            {
                open++;// unmatched open bracket
            }
            else {
                if(open>0)
                    open--;// found a match for a previous open
                else
                    close++;// unbalanced closing bracket
            }
        }
       /* This formula gives the minimum reversals:
        To balance open unclosed { → we need (open + 1)/2 flips.
            To balance close extra } → we need (close + 1)/2 flips.
            It works because:
        2 unbalanced { → need 1 reversal to make one into }.
        Similarly for }.*/
        return (open+1)/2+(close+1)/2;

    }

    public static void main(String[] args) {
        System.out.println(count("}{"));
        System.out.println(count("{{{"));
    }
}
