package main.edu.testdome.java.sortedsearch;

public class SortedSearchEfficient {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        if (sortedArray.length <= 1 || lessThan < sortedArray[0]) return 0;
        if (lessThan > sortedArray[sortedArray.length-1]) return sortedArray.length;

        int left = 0, right = sortedArray.length - 1, middle=0;
        while (left <= right) {
            middle = left + (right - left) / 2;

            // Check if lessThan is present at mid
            if (sortedArray[middle] == lessThan) {
                while (middle+1< sortedArray.length && sortedArray[middle+1]==lessThan){
                    middle++;
                }
                return middle;
            }

            // If lessThan greater, ignore left half
            if (sortedArray[middle] < lessThan) {
                left = middle + 1;
            }

            // If lessThan is smaller, ignore right half
            else {
                right = middle - 1;
            }
        }
        while (middle>-1 && sortedArray[middle]<lessThan)
            middle-- ;
        return middle;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearchEfficient.countNumbers(new int[] { 1, 3, 5, 7,10, 11, 11,11,13 }, 12));
    }
}
