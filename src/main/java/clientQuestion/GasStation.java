package clientQuestion;

public class GasStation {
    //https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
    //O(n)
    //https://www.youtube.com/watch?v=PX7wYSqDIMQ
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalDiff = 0;
        int fuel = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];//current fuel- required
            totalDiff += diff;
            fuel += diff;
            if (fuel < 0) {//if fuel is negative then this is not correct index
                index = i + 1;// change index current +1;
                fuel = 0;//set fuel 0 to start from nex sttaion
            }
        }
        return totalDiff < 0 ? -1 : index;

    }

    public static void main(String[] args) {
      /*  Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        Output: 3*/
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("index : " + canCompleteCircuit(gas, cost));
    }
}