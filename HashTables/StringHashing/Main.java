package HashTables.StringHashing;

import java.util.*;

public class Main {
    private static void test2() {
        MyStringHashTable test = new MyStringHashTable(-1);
        test.insert("WOW");
        test.insert("SAD");
        test.insert("MUG");
        test.insert("LOT");
        int res = test.find("UMM");
        System.out.println(res);
        res = test.find("MUG");
        System.out.println(res);
        test.remove("HUH");
        test.remove("SAD");
    }

    private static void test3() {
        MyStringHashTable test = new MyStringHashTable(10);
        test.insert("AB0");
        test.insert("AB1");
        test.insert("AB2");
        test.insert("AB3");
        test.insert("AB4");
        test.insert("AB5");
        test.insert("AB6");
        test.insert("AB7");
        test.insert("AB8");
        test.insert("AB9");
        int result = test.findIndex("AB9");
        System.out.println(result);
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length: ");
        int length = scanner.nextInt();

        MyStringHashTable table = new MyStringHashTable(length);

        while (true) {
            System.out.print("1. Insert a new element\n"
                    + "2. Remove an element\n"
                    + "3. Find an element\n"
                    + "4. Quit\n");
            int op = scanner.nextInt();

            String key;
            switch (op) {
                case 1:
                    System.out.print("Enter element value: ");
                    scanner.nextLine();
                    String val = scanner.nextLine();

                    table.insert(val);
                    break;
                case 2:
                    System.out.print("Enter element value: ");
                    scanner.nextLine();
                    key = scanner.nextLine();
                    table.remove(key);

                    break;
                case 3:
                    System.out.print("Enter element value: ");
                    scanner.nextLine();
                    key = scanner.nextLine();

                    int idx = table.findIndex(key);
                    if (idx >= 0) {
                        System.out.println(String.format("Found in bucket %d!", idx));
                    } else {
                        System.out.println("Not found!");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}