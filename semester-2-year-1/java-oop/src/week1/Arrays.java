import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Day 6 — Arrays
// Covers: declare, initialise, loop through, modify 1D arrays
public class Arrays {
    public static void main(String[] args) {

        // array = a collection of values of the same data type.

//        String[] fruits = {"apple", "orange", "banana", "coconut"};

        // fruits[0] = "pineapple";
        // int numOfFruits = fruits.length;

//        for(int i = 0; i < fruits.length; i ++){
//            System.out.print(fruits[i] + " ");
//        }
        // Arrays.sort(fruits); # Sorts them alphabetically
        // Arrays.fill(fruits, "pineapple") # Replaces all values in the fruit array with the new variable.

//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }

        // ArrayList = A resizeable array that stores objects (autoboxing).

//        ArrayList<String> fruits = new ArrayList<>();
//
//        fruits.add("Apple");
//        fruits.add("Banana");
//        fruits.add("Coconut");

//        fruits.remove(1);
//        fruits.set(0, "Pineapple");


//        System.out.println(fruits.get(1));

//        System.out.println(fruits.size());

//        Collections.sort(fruits);
//
//        for(String fruit : fruits){
//            System.out.println(fruit);
//        }

//        Scanner scanner = new Scanner(System.in);
//
//        ArrayList<String> foods = new ArrayList<>();
//
//        System.out.print("Enter the number of food items: ");
//        int numOfFood = scanner.nextInt();
//        scanner.nextLine();
//
//        for(int i = 1; i <= numOfFood; i++){
//            System.out.print("Enter food item #" + i + ": ");
//            String food =  scanner.nextLine();
//            foods.add(food);
//        }
//
//        Collections.sort(foods);
//        System.out.println(foods);
//
//        scanner.close();

        // 2D Array = An array where each element is an array

//        String[] fruits = {"apple", "orange", "banana"};
//        String[] vegetables = {"potato", "onion", "carrot"};
//        String[] meats = {"chicken", "pork", "beef", "fish"};
//
//        String[][] groceries = {fruits, vegetables, meats};
//
//        groceries[0][0] = "pineapple";
//
//        for(String[] foods : groceries){
//            for(String food : foods){
//                System.out.print(food + " ");
//            }
//            System.out.println();
//        }

        char[][] telephone =  {{'1', '2', '3'},
                               {'4', '5', '6'},
                               {'7', '8', '9'},
                               {'*', '0', '#'}};

        for(char[] row : telephone){
            for(char number : row){
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
