package HashTables.Resizing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyHashTable hashTable;

        // Prompt the user for the hash table length
        System.out.print("Enter length: ");
        int length = scanner.nextInt();
        if (length == -1) {
            hashTable = new MyHashTable(); // Use default constructor
        } else {
            hashTable = new MyHashTable(length);
        }

        int choice = 0;
        while (choice != 4) {
            // Display the menu
            System.out.println("1. Insert a new element");
            System.out.println("2. Remove an element");
            System.out.println("3. Find an element");
            System.out.println("4. Quit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Operating System: ");
                    scanner.nextLine();
                    String os = scanner.nextLine();
                    System.out.print("Enter Manufacture Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Serial Number: ");
                    int serialNumber = scanner.nextInt();
                    Computer newComputer = new Computer(os, year, serialNumber);
                    hashTable.insert(newComputer);
                    break;

                case 2:
                    System.out.print("Enter key: ");
                    break;

                case 3:
                    System.out.print("Enter key: ");
                    int findKey = scanner.nextInt();
                    int bucketIndex = hashTable.findIndex(findKey);
                    if (bucketIndex == -1) {
                        System.out.println("Not found!");
                    } else {
                        System.out.println("Found in bucket " + bucketIndex + "!");
                        System.out.println(hashTable.get(findKey));
                    }
                    break;

                case 4: // Quit
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close(); // Close the scanner
    }
}
