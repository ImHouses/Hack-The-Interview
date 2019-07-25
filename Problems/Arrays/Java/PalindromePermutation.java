import java.util.Arrays;
import java.util.HashMap;

class PalindromePermutation {
    public static void main(String[] args) {
        String test = "taco cat";
        performTest(test, true);
        test = "anita lava la tina";
        performTest(test, true);
        test = "aabba";
        performTest(test, true);
    }

    public static boolean isPalindromePermutation(String s) {
        char[] characters = s.replaceAll("\\s+", "").toCharArray();
        HashMap<Character, Integer> occurences = new HashMap<>();
        for (char character : characters) {
            if (occurences.containsKey(character)) {
                int occurencesNumber = occurences.get(character);
                occurences.put(character, occurencesNumber+1);
            } else {
                occurences.put(character, 1);
            }
        }
        int oddOccurences = 0;
        for (int occurence : occurences.values()) {
            if (occurence % 2 != 0) {
                oddOccurences++;
            }
            if (oddOccurences > 1) {
                return false;
            }
        }
        return true;
    }

    static void performTest(String test, boolean expected) {
        System.out.println(String.format("Test: %s\nExpected: %b", test, expected));
        System.out.println(String.format("Result: %b\n\n", isPalindromePermutation(test)));
    }
}