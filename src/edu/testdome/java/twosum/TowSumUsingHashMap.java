package edu.testdome.java.twosum;
/*Write a function that, when passed a list and a target sum,
returns, efficiently with respect to time used,
two distinct zero-based indices of any two of the numbers,
whose sum is equal to the target sum. If there are no two numbers, the function should return null.

        For example, findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10)
        should return a single dimensional array
        with two elements and contain any of the following pairs of indices:

        0 and 3 (or 3 and 0) as 3 + 7 = 10
        1 and 5 (or 5 and 1) as 1 + 9 = 10
        2 and 4 (or 4 and 2) as 5 + 5 = 10
 Time complexity : n
 Space complexity is high relative to Loops
 */

import java.util.HashMap;
import java.util.Map;

public class TowSumUsingHashMap {
    public static int[] findTwoSum(int[] list, int sum) {
        if (list == null || list.length < 2 ) return null;
        Map<Integer,Integer> twoSumMap = new HashMap<>();
        for (int i=0;i<list.length;i++){
            if (twoSumMap.containsKey(list[i]))
                return new int[]{i, twoSumMap.get(list[i])};
            twoSumMap.put(sum-list[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
