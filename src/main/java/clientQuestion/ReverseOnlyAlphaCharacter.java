package clientQuestion;

public class ReverseOnlyAlphaCharacter {
    /* Only reverse English letters (lowercase or uppercase) [a-z and A-Z] should be reversed
     Any other letters should remain in same position
     Example:
     Input: s = “aA-bB”
     Output:  “Bb-Aa”
     Input: s = “aB-”
     Output: “Ba-”*/
    public static String reverseOnlyLetters(String str) {
        if (str.isEmpty())
            return "Invalid String input";
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            //return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                //swap
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            if (!Character.isAlphabetic(chars[left])) {
                left++;
            }
            if (!Character.isAlphabetic(chars[right])) {
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s1 = "aA-bB";
        System.out.println(reverseOnlyLetters(s1)); // Output: "Bb-Aa"

        String s2 = "aB-";
        System.out.println(reverseOnlyLetters(s2)); // Output: "Ba-"
    }
}
