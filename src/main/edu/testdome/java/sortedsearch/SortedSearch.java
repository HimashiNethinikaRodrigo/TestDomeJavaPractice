package main.edu.testdome.java.sortedsearch;

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
