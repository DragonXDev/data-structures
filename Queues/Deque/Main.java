package Queues.Deque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyDeque myDeque = new MyDeque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "(1) Push a value (2) Pop a value (3) View a value (4) Show size (5) Print Deque (6) Quit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("(1) Push to the front (2) Push to the back");
                    int pushChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the word to push: ");
                    String value = scanner.nextLine();
                    if (pushChoice == 1) {
                        myDeque.pushFront(value);
                    } else if (pushChoice == 2) {
                        myDeque.pushBack(value);
                    }
                }
                case 2 -> {
                    System.out.println("(1) Pop from the front (2) Pop from the back");
                    int popChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String removedValue = (popChoice == 1) ? myDeque.popFront() : myDeque.popBack();
                    if (removedValue == null) {
                        System.out.println("No elements could be popped!");
                    } else {
                        System.out.println("Removed " + removedValue);
                    }
                }
                case 3 -> {
                    System.out.println("(1) View the front (2) View the back");
                    int viewChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String viewedValue = (viewChoice == 1) ? myDeque.peekFront() : myDeque.peekBack();
                    if (viewedValue == null) {
                        System.out.println("No elements to peek at!");
                    } else {
                        System.out.println(viewedValue + " is at the " + (viewChoice == 1 ? "front" : "back"));
                    }
                }
                case 4 -> {
                    System.out.println("Current size is " + myDeque.size());
                }
                case 5 -> {
                    System.out.println(myDeque);
                }
                case 6 -> {
                    System.out.println("Thanks for dequeing~!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
