import java.util.Arrays;

class StringPermutation {
    public static void main(String[] args) {
        String test = "aabb";
        String test2 = "bbaa";
        System.out.println(String.format("s1=%s\ns2=%s", test, test2));
        System.out.println("Result: " + isPermutation(test, test2));
        test = "abbb";
        test2 = "bbaa";
        System.out.println(String.format("s1=%s\ns2=%s", test, test2));
        System.out.println("Result: " + isPermutation(test, test2));
    }

    static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Characters = s1.toCharArray();
        char[] s2Characters = s2.toCharArray();
        Arrays.sort(s1Characters);
        Arrays.sort(s2Characters);
        for (int i = 0; i < s1Characters.length; i++) {
            if (s1Characters[i] != s2Characters[i]) {
                return false;
            }
        }
        return true;
    }
}