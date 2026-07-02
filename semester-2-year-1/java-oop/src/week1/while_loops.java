import java.util.Scanner;

public class while_loops {
    public static void main(String[] args) {

        // while loop = repeat some code forever
        //              while some condition remains true

        Scanner scanner = new Scanner(System.in);

//        String name = "";
//
//        while (name.isEmpty()){
//            System.out.print("Please enter your name: ");
//            name = scanner.nextLine();
//        }
//
//        System.out.println("Hello, " + name);
        
//        String response = "";
//
//        while(!response.equals("Q")){
//            System.out.println("You are playing a game");
//            System.out.print("Press Q to Quit: ");
//            response = scanner.next().toUpperCase();
//        }
//
//        System.out.println("You quit the game");

        int number = 0;

        do{
            System.out.print("Enter a number between 1 and 10: ");
            number = scanner.nextInt();
        } while(number < 1 || number > 10);

        System.out.println("You picked " + number);

        scanner.close();

    }
}
