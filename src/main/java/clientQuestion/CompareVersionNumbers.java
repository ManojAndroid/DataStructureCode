package clientQuestion;

public class CompareVersionNumbers {
    //https://leetcode.com/problems/compare-version-numbers/description/
    //TC o(n);

    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int maxLength = Math.max(s1.length, s2.length);
        for (int i = 0; i < maxLength; i++) {
            int v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int v2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            if (v1 > v2)
                return 1;
            else if (v1 < v2)
                return -1;
        }
        return 0;

    }

    public static void main(String[] args) {
       /* Example 1:
        Input: version1 = "1.01", version2 = "1.001"
        Output: 0
        Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
                Example 2:
        Input: version1 = "1.0", version2 = "1.0.0"
        Output: 0
        Explanation: version1 does not specify revision 2, which means it is treated as "0".
                Example 3:
        Input: version1 = "0.1", version2 = "1.1"
        Output: -1
        Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.*/
    }
}
