package clientQuestion;

public class LongestPalindromicSubstring {
    // O(n^2)
    public static String longestPalindrome(String s) {

        if (s.length() <= 1)
            return s;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {

            String odd = expendeFromCenter(s, i, i);
            String even = expendeFromCenter(s, i, i + 1);

            if (odd.length() > result.length()) {
                result = odd;
            }
            if (even.length() > result.length()) {
                result = even;
            }

        }
        return result;

    }

    private static String expendeFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(str + "=" + longestPalindrome(str));

        String str1 = "cbbd";
        System.out.println(str1 + "=" + longestPalindrome(str1));
    }
}
