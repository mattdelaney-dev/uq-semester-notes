// Day 6 — Arrays
// Covers: declare, initialise, loop through, modify 1D arrays
public class Arrays {
    public static void main(String[] args) {

        // array = a collection of values of the same data type.

        String[] fruits = {"apple", "orange", "banana", "coconut"};

        // fruits[0] = "pineapple";
        // int numOfFruits = fruits.length;

//        for(int i = 0; i < fruits.length; i ++){
//            System.out.print(fruits[i] + " ");
//        }
        // Arrays.sort(fruits); # Sorts them alphabetically
        // Arrays.fill(fruits, "pineapple") # Replaces all values in the fruit array with the new variable.

        for(String fruit : fruits){
            System.out.println(fruit);
        }

    }
}
