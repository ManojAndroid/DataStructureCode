package clientQuestion;

public class CarPolling {
    //https://leetcode.com/problems/car-pooling/submissions/1272942691/
    //tc o(n)
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] length = new int[1001];
        for (int[] trip : trips) {
            length[trip[1]] += trip[0];// 2 1
            length[trip[2]] -= trip[0];// -2
        }
        int count = 0;
        for (int i = 0; i < length.length; i++) {
            count = count + length[i];
            if (capacity < count)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int [][] arr={{2,1,5},{3,3,7}};
       boolean ans= carPooling(arr,4);
        System.out.println(" ans"+ ans);
    }
}
