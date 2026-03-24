package ConcurrencyProblem;

// Class responsible for printing odd and even numbers using two threads
class PrintOddEven {

    int number = 1;     // Shared variable between threads
    int limit = 10;     // Maximum number to print

    // Method for printing odd numbers
    public synchronized void printOdd() throws InterruptedException {

        // Loop until number exceeds limit
        while(number <= limit) {

            // If number is even, odd thread should wait
            if(number % 2 == 0) {
                wait();   // Release lock and wait until notified
            }

            // Print the current odd number
            System.out.println("Odd Thread : " + number);

            // Increment number for next iteration
            number++;

            // Notify waiting thread (even thread) to continue
            notify();
        }
    }

    // Method for printing even numbers
    public synchronized void printEven() throws InterruptedException {

        // Loop until number exceeds limit
        while(number <= limit) {

            // If number is odd, even thread should wait
            if(number % 2 == 1) {
                wait();   // Release lock and wait
            }

            // Print the current even number
            System.out.println("Even Thread : " + number);

            // Increment number for next iteration
            number++;

            // Notify waiting thread (odd thread)
            notify();
        }
    }
}

public class Test {

    public static void main(String[] args) {

        // Create shared object used by both threads
        PrintOddEven obj = new PrintOddEven();

        // Thread responsible for printing odd numbers
        Thread odd = new Thread(() -> {
            try {
                obj.printOdd();
            } catch(Exception e) {}
        });

        // Thread responsible for printing even numbers
        Thread even = new Thread(() -> {
            try {
                obj.printEven();
            } catch(Exception e) {}
        });

        // Start both threads
        odd.start();
        even.start();
    }
}
