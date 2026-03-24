package clientQuestion;

public class SquareRoot {

    public static int sqrt(int number) {
        int result = 0;
        for (int i = 1; i < number; i++) {
            int temp = (i * i);
            if (temp == number) {
                result = i;
               // break;
            }
            //System.out.print(i +" ,");

        }
        return result;
    }

    public static void main(String[] args) {
        int number = 36;
        System.out.println("Result :" + SquareRoot.sqrt(number));
    }
}
