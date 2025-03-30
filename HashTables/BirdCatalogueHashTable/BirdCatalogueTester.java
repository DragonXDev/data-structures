package HashTables.BirdCatalogueHashTable;

import java.util.*;
import java.io.*;

public class BirdCatalogueTester {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        BirdCatalogue catalogue = new BirdCatalogue();
        boolean success = loadBirds(catalogue);
        if (!success) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1) Search for a bird\n" +
                            "2) A bird died\n" +
                            "3) Quit");
            int op = scanner.nextInt();

            switch (op) {
                case 1: {
                    System.out.print("Enter the serial number: ");
                    int serial = scanner.nextInt();
                    Bird bird = catalogue.get(serial);
                    if (bird == null) {
                        System.out.println("No bird was found with that serial number!");

                        System.out.print("Enter the bird species: ");
                        scanner.nextLine();
                        String species = scanner.nextLine();

                        System.out.print("Enter the bird sex: ");
                        String sex = scanner.nextLine();

                        System.out.print("Enter the bird age: ");
                        int age = scanner.nextInt();

                        System.out.print("Enter the bird weight: ");
                        double weight = scanner.nextDouble();

                        catalogue.insert(new Bird(species, sex, age, weight, serial));
                        break;
                    }
                    System.out.println(bird);
                    break;
                }
                case 2: {
                    System.out.print("Enter the serial number: ");
                    int serial = scanner.nextInt();
                    Bird bird = catalogue.remove(serial);
                    if (bird == null) {
                        System.out.println("No bird was found with that serial number!");
                        break;
                    }
                    System.out.println("Removed " + bird);
                    break;
                }
                case 3:
                    return;
            }
        }
    }

    private static boolean loadBirds(BirdCatalogue catalogue) {
        System.out.println("Importing bird database!");

        try {
            File file = new File("birdList.txt");
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();
            while (line != null) {
                Bird bird = parseBird(line);
                catalogue.insert(bird);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        System.out.println("Import complete!");
        return true;
    }

    private static Bird parseBird(String line) {
        // 0 - Species (in bird)
        // 1 - Sex (M or F)
        // 2 - Age (in years)
        // 3 - Weight (in oz)
        // 4 - Serial Number (assigned by the scientists - each bird's serial number is
        // unique. The serial numbers will be in the range 1000 - 9999.)

        String species = "";
        String sex = "";
        String ageStr = "";
        String weightStr = "";
        String serialNoStr = "";

        int state = 0;
        String buf = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c != ",".charAt(0)) {
                buf += c;
                continue;
            }

            switch (state) {
                case 0:
                    species = buf;
                    break;
                case 1:
                    sex = buf;
                    break;
                case 2:
                    ageStr = buf;
                    break;
                case 3:
                    weightStr = buf;
                    break;
            }
            buf = "";
            state++;
        }
        if (state == 4) {
            serialNoStr = buf;
        }

        int age = Integer.parseInt(ageStr);
        double weight = Double.parseDouble(weightStr);
        int serialNo = Integer.parseInt(serialNoStr);

        return new Bird(species, sex, age, weight, serialNo);
    }
}
