package clientQuestion;

import java.util.*;
import java.util.LinkedList;

public class OpenTheLock {
    //https://leetcode.com/problems/open-the-lock/
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        String start = "0000";
        if (deadendSet.contains(start))
            return -1; // initial base case
        queue.add(start);
        deadendSet.add(start);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                if (current.equals(target))
                    return level;
                List<String> nextop = nextOptions(current);
                for (String op : nextop) {
                    if (!deadendSet.contains(op)) {// if not visited
                        queue.add(op);// add in que
                        deadendSet.add(op);// mark visited in same deadendSet
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private List<String> nextOptions(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = s.charAt(i);
            StringBuilder copy = new StringBuilder(s);
            copy.setCharAt(i, (c == '0' ? '9' : (char) (c - 1)));// decrement
            ans.add(copy.toString());
            copy.setCharAt(i, (c == '9' ? '0' : (char) (c + 1)));// increment
            ans.add(copy.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        /*Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
        Output: 6
        Explanation:
        A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
                Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
                because the wheels of the lock become stuck after the display becomes the dead end "0102".*/
    }
}
