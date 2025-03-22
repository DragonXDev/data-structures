package Queues.Queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<String>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("(1) Enqueue a value (2) Dequeue a value (3) Show size (4) Quit");
            int choice = scanner.nextInt();
            

            switch (choice) {
                case 1:
                    System.out.print("Enter a word to enqueue: ");
                    scanner.nextLine(); 
                    String word = scanner.nextLine();
                    myQueue.enqueue(word);
                    break;
                case 2:
                    if (myQueue.isEmpty()) {
                        System.out.println("No elements could be dequeued!");
                    } else {
                        System.out.println("Removed " + myQueue.dequeue());
                    }
                    break;
                case 3:
                    System.out.println("Current size is " + myQueue.size());
                    break;
                case 4:
                    System.out.println("Thanks for queueing~!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
