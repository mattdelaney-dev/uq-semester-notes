import java.util.Scanner;

// Day 5 — Loops
// Covers: for loop, while loop, do-while, nested loops
public class Loops {
    public static void main(String[] args) throws InterruptedException {

        // for Loop = execute some code a CERTAIN amount of times.

//        for(int i = 1; i <= 10; i += 3){
//            System.out.println(i);
//        }

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter a number of times you wish to loop: ");
//        int max = scanner.nextInt();
//
//        for(int i = 1;i < max;i++){
//            System.out.println(i);
//        }
//
//        scanner.close();

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many seconds to count down from: ");

        int start = scanner.nextInt();

        for(int i = start; i > 0; i --){
            System.out.println(i);
            Thread.sleep(1000);
        }


        System.out.println("HAPPY NEW YEARS!");
    }
}
