package Heaps.MinHeap;

import java.util.Scanner;

public class HeapTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMinHeap heap = new MyMinHeap();
        int option = 0;

        while (true) {
            System.out.println("1. Insert a new value");
            System.out.println("2. Remove a value");
            System.out.println("3. Peek at the top");
            System.out.println("4. Quit");

            // Read the user's option
            if (sc.hasNextInt()) {
                option = sc.nextInt();
                // sc.nextLine(); // Consume the newline left-over
            } else {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("Enter the new value: ");
                    sc.nextLine();
                    String newValue = sc.nextLine();
                    heap.insert(newValue);
                    break;
                case 2:
                    String removed = heap.remove();
                    System.out.println("\nRemoved " + removed);
                    break;
                case 3:
                    System.out.println(heap.peek());
                    break;
                case 4:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
            System.out.println();
        }
    }
}
