package main.edu.testdome.java;
/*
A frog only moves forward, but it can move in steps 1 inch long or in jumps 2 inches long.
A frog can cover the same distance using different combinations of steps and jumps.

Write a function that calculates the number of different combinations
a frog can use to cover a given distance.

For example, a distance of 3 inches can be covered in three ways: step-step-step, step-jump, and jump-step.
 */
public class FrogProblem {
    // Fibonacci sequence
    public static int numberOfWays(int input) {
        if (input==1) return 1;
        if (input == 2) return 2;
        return numberOfWays(input-1)+ numberOfWays(input-2);
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(10));
    }
}
