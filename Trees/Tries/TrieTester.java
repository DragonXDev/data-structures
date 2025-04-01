package Trees.Tries;

import java.util.Scanner;

public class TrieTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trie trie = new Trie();

        System.out.println("Enter the words you want in the Trie:");
        while (true) {
            String word = scanner.nextLine().trim().toUpperCase();
            if (word.isEmpty())
                break;
            trie.insert(word);
        }

        trie.printTrie();

        while (true) {
            System.out.println("\n1. Search for a String");
            System.out.println("2. Remove a String");
            System.out.println("3. Insert a new String");
            System.out.println("4. Print the Trie");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the String to search for: ");
                    scanner.nextLine();
                    String searchWord = scanner.nextLine().toUpperCase();
                    System.out
                            .print(searchWord + (trie.search(searchWord) != null ? " was found." : " was not found."));
                    break;

                case 2:
                    System.out.print("Enter the String to remove: ");
                    scanner.nextLine();
                    String removeWord = scanner.nextLine().toUpperCase();
                    System.out.print(removeWord + (trie.remove(removeWord) ? " was removed." : " was not found."));
                    break;

                case 3:
                    System.out.print("Enter the String to insert: ");
                    scanner.nextLine();
                    String insertWord = scanner.nextLine().toUpperCase();
                    trie.insert(insertWord);
                    System.out.print(insertWord + " was inserted.");
                    break;

                case 4:
                    trie.printTrie();
                    break;

                case 5:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
