import java.util.Random;

/**
 * 867. Transpose Matrix. 
 * Problem from LeetCode https://leetcode.com/problems/transpose-matrix/
 */
class TransposeMatrix {

    public static void main(String[] args) {
        int[][] input = generateInput(new Random().nextInt(5), new Random().nextInt(5)); 
        System.out.println("Input: " + Utils.array2DtoString(input));
        int[][] output = transposeMatrix(input);
        System.out.println("Output: " + Utils.array2DtoString(output));
    }

    /**
     * Given a matrix 'input', return the transpose of 'input'.
     * 
     * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row 
     * and column indices of the matrix.
     * @param input The matrix input.
     * @return The transpose of the input.
     */
    private static int[][] transposeMatrix(int[][] input) {
        if(input.length == 0) {
            return new int[][]{};
        }
        int outputRows = input[0].length;
        int outputColumns = input.length;
        int[][] output = new int[outputRows][outputColumns];
        for (int i = 0; i < outputRows; i++) {
            for (int j = 0; j < outputColumns; j++) {
                output[i][j] = input[j][i];
            }
        }
        return output;
    }

    /* Auxiliar function to return a random input. */
    private static int[][] generateInput(int row, int column) {
        Random r = new Random();
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = r.nextInt(10);
            }
        }
        return matrix;
    }
}