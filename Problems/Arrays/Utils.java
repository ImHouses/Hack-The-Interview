import java.lang.StringBuilder;

/**
 * Class that contains util functions for int arrays.
 */
class Utils {

    /**
     * Prints the given int array.
     * @param array The array to print.
     */
    static void printArray(int[] array) {
        System.out.print(arrayToString(array));
    }
    
    /**
     * Prints the given 2D int array.
     * @param array The array to print.
     */
    static void print2DArray(int[][] array) {
        System.out.print(array2DtoString(array));
    }

    /**
     * Returns a String representation of the given array.
     * @param array The array to "convert" to String.
     * @return A String representation of the given array.
     */
    static String arrayToString(int[] array) {
        StringBuilder arrayString = new StringBuilder();
        arrayString.append("[");
        for (int i = 0; i < array.length-1; i++) {
            arrayString.append(String.format("%d, ", array[i]));
        }
        arrayString.append(String.format("%d]", array[array.length-1]));
        return arrayString.toString();
    }

    /**
     * Returns a String representation of the given 2D array.
     * @param array The array to "convert" to String.
     * @return A String representation of the given 2D array.
     */
    static String array2DtoString(int[][] array) {
        StringBuilder arrayString = new StringBuilder();
        int i = 0;
        while (i < array.length-1) {
            int[] arrayAtIndex = array[i];
            arrayString.append(arrayToString(arrayAtIndex));
            arrayString.append("\n");
            i++;
        }
        arrayString.append(String.format("%s", arrayToString(array[i])));
        return arrayString.toString();
    }
}