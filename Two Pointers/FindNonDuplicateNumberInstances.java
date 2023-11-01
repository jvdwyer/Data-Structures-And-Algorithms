//Author: John Dwyer
// Date: 11/1/2023

/*
Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the array in-place. The relative order of the elements should be kept the same and you should not use any extra space so that the solution has constant space complexity i.e., .

Move all the unique number instances at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after moving element will be [2, 3, 6, 9].
Example 2:

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after moving elements will be [2, 11].
*/
public class FindNonDuplicateNumberInstances {
    private static int[] set1 = {2, 3, 3, 3, 6, 9, 9};
    private static int[] set2 = {2, 2, 2, 11};
    private static int[] set3 = {1, 1, 2, 2, 3, 3, 4, 4};

    public static int remove(int[] arr) {
        int next = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[next - 1] != arr[i]) {
                arr[next] = arr[i];
                next++;
            }
        }
        return next;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Test1:
        int result1 = remove(set1);
        System.out.println("Test1: Expected: 4, Actual: " + result1);
        printArray(set1);

        // Test2:
        int result2 = remove(set2);
        System.out.println("Test2: Expected: 2, Actual: " + result2);
        printArray(set2);

        // Test3
        int result3 = remove(set3);
        System.out.println("Test2: Expected: 4, Actual: " + result3);
        printArray(set3);
    }
}
