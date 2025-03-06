package clientQuestion;

public class EquilibriumPointOfTheArray {
    /*  Given an array of integers, return the index of the equilibrium point of the array.
      An element is said to be Equilibrium point, when the sum of it's left elements is equal to sum of it's right elements.
              I/P : a={2,1,3,5,4,2}
      O/P : 5*/
    public static int findEquilibriumPoint(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum = totalSum - arr[i];
            if (leftSum == totalSum) {
                return arr[i];
            }
            leftSum = leftSum + arr[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] arr={2,1,3,5,4,2};
        System.out.println("EquilibriumPoint : "+findEquilibriumPoint(arr) );
    }
}
