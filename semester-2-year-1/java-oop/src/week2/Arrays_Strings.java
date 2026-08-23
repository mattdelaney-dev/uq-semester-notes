public class Arrays_Strings {

    public static void main(String[] args) {
        int[] numbers = {10, 11, 12};
        System.out.println(sum(numbers));
        System.out.println(max(numbers));
    }

    public static int sum(int[] nums) {
        int total = 0;
        for(int number : nums){
            total += number;
        }
        return total;
    }

    public static int max(int[] number) {
        int max_value = number[0];
        for(int num : number){
            if(num > max_value) {
                max_value = num;
            }
        }
        return max_value;
    }

    public static String cipher(String text) {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m",  "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z"};

        StringBuilder result = new StringBuilder();

        for(int i = 0; 1 < text.length(); i++){
            char c = text.charAt(i);
            String letter = String.valueOf(c);

            int index = -1;
            for (int j = 0; j < alphabet.length; j++){
                if (alphabet[j].equals(letter)){
                    index = j;
                    break;
                }
            }

            if (index == -1){
                result.append(c);
            } else {
                int newIndex = (index + 3) % alphabet.length;
                result.append(alphabet[newIndex]);
            }
        }
        return result.toString();
    }


}