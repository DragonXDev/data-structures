package Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> myS = new MyStack<Integer>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("(1) Push a value\n(2) Pop a value\n(3) Show size\n(4) Quit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to push: ");
                    int number = scanner.nextInt();
                    myS.push(number);
                    break;
                case 2:
                    if (myS.isEmpty()) {
                        System.out.println("No elements could be popped!");
                    } else {
                        System.out.println("Removed " + myS.pop());
                    }
                    break;
                case 3:
                    System.out.println("Current size is " + myS.size());
                    break;
                case 4:
                    System.out.println("Thanks for stacking~!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}