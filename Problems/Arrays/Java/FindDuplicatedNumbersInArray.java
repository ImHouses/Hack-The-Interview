import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Given an array of integers, 1 <= a[i] <= n where n is the size of the array.
 * Some elements appear twice and others appear once.
 * Seen at: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Status: SOLVED on O(n) time and O(1) space.
 */
class FindDuplicatedNumbersInArray {
    public static void main(String[] args) {
        int[] test = new int[] {4,3,2,7,8,2,3,1};
        System.out.println("Test: " + Arrays.toString(test));
        System.out.println("Result: " + findDuplicatedNumbers(test));
    }

    static List<Integer> findDuplicatedNumbers(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[i] == i+1) {
                i++;
            } else if (nums[i] == nums[nums[i]-1]) {
                result.add(nums[i]);
                nums[nums[i]-1] = 0;
                i++;
            } else {
                int aux = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = aux;
            }
        }
        return result;
    }
}