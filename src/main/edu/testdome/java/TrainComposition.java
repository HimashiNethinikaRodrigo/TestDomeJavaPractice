package main.edu.testdome.java;
/*
A TrainComposition is built by attaching and detaching wagons from the left and the right sides, efficiently with respect to time used.

For example, if we start by attaching wagon 7 from the left followed by attaching wagon 13,
 again from the left, we get a composition of two wagons (13 and 7 from left to right).
 Now the first wagon that can be detached from the right is 7 and the first that can be detached from the left is 13.

Implement a TrainComposition that models this problem.


 */
public class TrainComposition {
    Wagon head; // head of list
    Wagon finalWagon;
    public void attachWagonFromLeft(int wagonId) {
        Wagon wagon = new Wagon(wagonId);
        if (head == null )
        {
            head = wagon;
            if  (finalWagon == null)
                finalWagon =wagon;
        }
        else {
            wagon.next = head;
            head.prev = wagon;
            head =  wagon;
        }

    }

    public void attachWagonFromRight(int wagonId) {
        Wagon wagon = new Wagon(wagonId);

        if (finalWagon== null){
            finalWagon = wagon;
            if (head == null)
                head = wagon;
        }
        else
        {
            finalWagon.next =wagon;
            wagon.prev = finalWagon;
            finalWagon = wagon;
        }
    }

    public int detachWagonFromLeft() {
        int val = head.data;
        Wagon wagon = head.next;
        if (wagon == null)
            finalWagon = null;
        head = wagon;

        return val;
    }

    public int detachWagonFromRight() {
        int val = finalWagon.data;
        Wagon wagon = finalWagon.prev;
        if (wagon == null)
            head = null;
        finalWagon = wagon;

        return val;

    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }

    class Wagon {
        int data;
        Wagon prev;
        Wagon next;

        Wagon(int d) { data = d; }
    }
}