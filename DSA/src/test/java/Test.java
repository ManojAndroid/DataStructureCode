
public class Test {
    int absorbeTheValue() {
        try {
            int a = 10 / 0;
            //System.exit(1);// finally bloc will not execute
             return 4;
        } catch (Exception e) {
            //return 45;
            throw new RuntimeException("something happend");
        } finally {
            return 34;
        }
    }

    public static void main(String[] args) {
        int result = new Test().absorbeTheValue();
        System.out.println(result);
    }
}


