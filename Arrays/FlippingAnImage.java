import java.util.Random;

/**
 * 832. Flipping an Image. 
 * Problem from LeetCode https://leetcode.com/problems/flipping-an-image/
 */
class FlippingAnImage {

    public static void main(String[] args) {
        int[][] input = generateInput();
        String inputString = String.format("INPUT:\n %s", Utils.array2DtoString(input));
        System.out.println(inputString);
        int[][] output = flipAndInvertImage(input);
        String  outputString = String.format("OUTPUT:\n %s", Utils.array2DtoString(output));
        System.out.println(outputString);
    }

    /**
     * Given a binary matrix A, returns an inversed and horizontally flipped matrix.
     * @param A The binary matrix to inverse and flip.
     * @return An inversed an horizontally flipped matrix.
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int index = 0; index < A.length; index++) {
            int i = 0;
            int j = A.length-1;
            while(i <= j) {
                int auxiliar = A[index][i];
                A[index][i] = A[index][j];
                A[index][j] = auxiliar;
                i++;
                j--;
            }
            i = 0;
            while(i < A.length) {
                A[index][i] = A[index][i] == 0 ? 1 : 0;
                i++;
            }
        }
        return A;
    }

    /* Auxiliar function to generate a random input. */
    private static int[][] generateInput() {
        Random r = new Random();
        int length = r.nextInt(20);
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                array[i][j] = r.nextInt(2);
            }
        }
        return array;
    }
}