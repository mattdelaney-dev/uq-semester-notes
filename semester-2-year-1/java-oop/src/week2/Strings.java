// Day 10 — String methods
// Covers: length, toUpperCase, substring, contains, replace, equals
public class Strings {
    public static void main(String[] args) {
        String name = "Broski";

        int length = name.length();
        char letter = name.charAt(0);
        int index = name.indexOf("e");
        int lastIndex = name.lastIndexOf("t");

        // name = name.toUpperCase();
        // name = name.toLowerCase();
        // name = name.trim();
        // name = name.replace("e", "a");

        // name.isEmpty();

//        if(name.isEmpty()){
//            System.out.println("Empty String");
//        }
//        else{
//            System.out.println("String");
//        }

//        if(name.contains(" ")){
//            System.out.println("your name contains spaces");
//        }
//        else{
//            System.out.println("your name doesnt contain any spaces");
//        }

        if(name.equalsIgnoreCase("password")){
            System.out.println("Your name cant be password");
        }
        else{
            System.out.println("Hello " + name);
        }
    }
}
