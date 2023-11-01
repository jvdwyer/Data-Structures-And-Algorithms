// Author: John Dwyer
// Date: 11/1/2023

/*
Given an array of numbers sorted in ascending order and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
Example 2:

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */

import java.util.HashMap;

class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int num = arr[i];
      int diff = targetSum - num;
      
      if (map.containsKey(diff)) {
        return new int[] {i, map.get(diff)};
      }
      map.put(num, i);
    }
    return new int[] { -1, -1 };
  }

  public static String printSolution(int[] arr) {
    StringBuilder result = new StringBuilder("[");
    for (int i = 0; i < arr.length; i++) {
        result.append(arr[i]);
        if (i < arr.length - 1) {
            result.append(", ");
        }
    }
    result.append("]");
    return result.toString();
  }

  public static void main(String args[]) {
    
    // Test1: solution exists
    int[] set1 = {1, 2, 3, 4, 6};
    int target1 = 6;
    int[] solution1 = search(set1, target1);
    System.out.println("Test1: Expected: [3, 1], Actual: " + printSolution(solution1));

    // Test2: solution exists
    int[] set2 = {2, 5, 9, 11};
    int target2 = 11;
    int[] solution2 = search(set2, target2);
    System.out.println("Test2: Expected: [2, 0], Actual: " + printSolution(solution2));

    // Test3: solution does not exist
    int[] set3 = {1, 3, 5, 7, 9};
    int target3 = 19;
    int[] solution3 = search(set3, target3);
    System.out.println("Test3: Expected: [-1, -1], Actual: " + printSolution(solution3));
  }
}