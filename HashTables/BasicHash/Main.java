package HashTables.BasicHash;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length: ");
        int len = scanner.nextInt();
        MyHashTable hashTable;
        if (len == -1) {
            hashTable = new MyHashTable();
        } else {
            hashTable = new MyHashTable(len);
        }

        int choice;
        do {
            System.out.println("1. Insert a new element");
            System.out.println("2. Remove an element");
            System.out.println("3. Find an element");
            System.out.println("4. Quit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element value: ");
                    int insertValue = scanner.nextInt();
                    hashTable.insert(insertValue);
                    break;
                case 2:
                    System.out.print("Enter element value: ");
                    int removeValue = scanner.nextInt();
                    hashTable.remove(removeValue);
                    break;
                case 3:
                    System.out.print("Enter element value: ");
                    int findValue = scanner.nextInt();
                    int foundIndex = hashTable.find(findValue);
                    if (foundIndex != -1) {
                        System.out.println("Found in bucket " + foundIndex + "!");
                    } else {
                        System.out.println("Not found!");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}