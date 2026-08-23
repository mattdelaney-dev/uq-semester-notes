public class nextVowel {

    static char NextVowel(char c){
        return switch (c) {
            case 'A' -> 'E';
            case 'E' -> 'I';
            case 'I' -> 'O';
            case 'O' -> 'U';
            case 'U' -> 'A';
            case 'a' -> 'e';
            case 'e' -> 'i';
            case 'i' -> 'o';
            case 'o' -> 'u';
            case 'u' -> 'a';
            default -> c;
        };
    }
}
