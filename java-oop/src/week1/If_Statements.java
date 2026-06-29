import java.util.Scanner;

public class If_Statements {
    public static void main(String[] args) {

        // if statements = performs a block of code if its condition is true

        Scanner scanner = new Scanner(System.in);

        String name;
        int age;
        boolean isStudent;

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Enter your age: ");
        age = scanner.nextInt();

        System.out.print("Are you a student (true/false)");
        isStudent = scanner.nextBoolean();

        // Group 1
        if(name.isEmpty()){
            System.out.println("Name is empty");
        }
        else{
            System.out.println("Name is " + name);
        }

        // Group 2
        if(age >= 18){
            System.out.println("You are a adult");
        }
        else if(age < 0){
            System.out.println("You are neither");
        }
        else if(age == 0){
            System.out.println("You are 0");
        }
        else{
            System.out.println("You are a child");
        }

        // Group 3
        if(isStudent){
            System.out.println("You are a student");
        }
        else{
            System.out.println("You are not student");
        }

        scanner.close();
    }
}
