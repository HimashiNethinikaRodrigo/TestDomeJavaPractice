package main.edu.testdome.java.sortedsearch;

public class SortedSearchRecursive {
    public static int countNumbers(int[] sortedArray,int left, int right, int lessThan) {
        int middle = left + (right - left) / 2;

            // Check if lessThan is present at mid
        if (sortedArray[middle] == lessThan) return middle;
        if (middle <= left) return left + 1;
        if (middle >= right) return right + 1;
            // If lessThan greater, ignore left half
        if (sortedArray[middle] < lessThan)
            return countNumbers(sortedArray, middle , right, lessThan);
            // If lessThan is smaller, ignore right half
        else return countNumbers(sortedArray, left, middle , lessThan);


    }
    public static int countNumbers(int[] sortedArray, int lessThan) {
        if (sortedArray.length <= 1 || lessThan < sortedArray[0]) return 0;

        if (lessThan > sortedArray[sortedArray.length-1]) return sortedArray.length;

        return countNumbers(sortedArray,0,sortedArray.length-1, lessThan);
    }

    public static void main(String[] args) {
        System.out.println(SortedSearchEfficient.countNumbers(new int[] { 1, 3, 5, 7,10, 11, 11,11,13 }, 12));
    }
}
