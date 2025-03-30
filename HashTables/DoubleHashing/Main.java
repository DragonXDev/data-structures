package HashTables.DoubleHashing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        MyHashTable hashTable;

        if (length == -1) {
            hashTable = new MyHashTable();
        } else {
            hashTable = new MyHashTable(length);
        }

        int choice;
        do {
            System.out.println("1. Insert a new element");
            System.out.println("2. Remove an element");
            System.out.println("3. Find an element");
            System.out.println("4. Quit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Insert a new element
                    System.out.print("Enter Operating System: ");
                    scanner.nextLine();
                    String os = scanner.nextLine();

                    System.out.print("Enter Manufacture Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Serial Number: ");
                    int serialNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Computer computer = new Computer(os, year, serialNumber);
                    hashTable.insert(computer);
                    break;

                case 2: // Remove an element
                    System.out.print("Enter key: ");
                    scanner.nextLine(); // Consume newline
                    break;

                case 3: // Find an element
                    System.out.print("Enter key: ");
                    int findKey = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    int index = hashTable.findIndex(findKey);
                    if (index != -1) {
                        System.out.println("Found in bucket " + index + "!");
                        System.out.println(hashTable.get(findKey));
                    } else {
                        System.out.println("Not found!");
                    }
                    break;

                case 4: // Quit
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
