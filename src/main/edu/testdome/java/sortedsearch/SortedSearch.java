package main.edu.testdome.java.sortedsearch;
/*
Implement function countNumbers that accepts a sorted array of unique integers and,
efficiently with respect to time used,
counts the number of array elements that are less than the parameter lessThan.

For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4)
should return 2 because there are two array elements less than 4.

Test case pass rate: 25%
 */
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int count = 0;
        for (int val:sortedArray) {
            if (val>lessThan) return count;
            else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }

}
