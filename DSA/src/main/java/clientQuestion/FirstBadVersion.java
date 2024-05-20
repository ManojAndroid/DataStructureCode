package clientQuestion;

public class FirstBadVersion {
    //https://leetcode.com/problems/first-bad-version/submissions/1262952475/
    //tc=(logn)
    public static int firstBadVersion(char [] version,int n) {
        int l = 0;
        int r = n;
        int ans = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;
           // if (isBadVersion(mid)) {//this method is in leetcode
            if (version[mid]=='B') {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
                        //1 , 2 , 3 , 4 , 5 , 6 version
        char [] version={'A','A','A','B','B','B'};
        int ans=firstBadVersion(version,6);
        System.out.println(ans);

    }

}
