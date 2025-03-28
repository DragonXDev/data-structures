package Projects.simulations.EcosystemSim;

import java.util.Random;

public class EcosystemSimulator {

    private static final int ECOSYSTEM_SIZE = 100;
    private static final int SIMULATION_STEPS = 10;
    private static final int MOVE_PROBABILITY_LIMIT = 3;

    private static final int BEAR_PROBABILITY = 5;
    private static final int FISH_PROBABILITY = 15;

    private static Random rand = new Random();

    public static void main(String[] args) {
        Animal[] animals = initializeEcosystem();
        simulateEcosystem(animals);
    }

    private static Animal[] initializeEcosystem() {
        Animal[] animals = new Animal[ECOSYSTEM_SIZE];
        for (int i = 0; i < animals.length; i++) {
            int probability = rand.nextInt(100) + 1;
            animals[i] = createAnimal(probability);
        }
        return animals;
    }

    private static Animal createAnimal(int probability) {
        int strength = rand.nextInt(9) + 1;
        boolean gender = rand.nextBoolean();

        if (probability <= BEAR_PROBABILITY) {
            return new Bear(gender, strength);
        } else if (probability <= FISH_PROBABILITY) {
            return new Fish(gender, strength);
        } else {
            return null;
        }
    }

    private static void simulateEcosystem(Animal[] animals) {
        for (int step = 1; step <= SIMULATION_STEPS; step++) {
            System.out.println("Simulation Round " + step);
            printEcosystem(animals);
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] != null) {
                    moveOrCollide(animals, i);
                }
            }
            System.out.println();
        }
    }

    private static void moveOrCollide(Animal[] animals, int index) {
        int probability = rand.nextInt(MOVE_PROBABILITY_LIMIT) + 1;
        if (index > 0 && probability == 1) {
            moveOrCollideWithNeighbor(animals, index, index - 1);
        } else if (index < animals.length - 1 && probability == 2) {
            moveOrCollideWithNeighbor(animals, index, index + 1);
        }
    }

    private static void moveOrCollideWithNeighbor(Animal[] animals, int currentIndex, int neighborIndex) {
        if (animals[neighborIndex] == null) {
            animals[neighborIndex] = animals[currentIndex];
            animals[currentIndex] = null;
        } else {
            String option = animals[currentIndex].collide(animals[neighborIndex]);
            if (option.equals("baby")) {
                System.out.println(animals[currentIndex] + " and " + animals[neighborIndex] + " make a baby "
                        + animals[currentIndex].getClass().getName().toLowerCase());
                while (true) {
                    int probability = rand.nextInt(100) + 1;
                    if (animals[probability] == null) {
                        int strength = rand.nextInt(9) + 1;
                        boolean gender = rand.nextBoolean();
                        if (animals[currentIndex] instanceof Bear) {
                            animals[probability] = new Bear(gender, strength);
                        } else {
                            animals[probability] = new Fish(gender, strength);
                        }
                        break;
                    }
                }
            } else if (option.equals("beat")) {
                System.out.println(animals[currentIndex] + " beat " + animals[neighborIndex]);
                animals[neighborIndex] = animals[currentIndex];
                animals[currentIndex] = null;
            } else if (option.equals("die")) {
                System.out.println(animals[currentIndex] + " died to  " + animals[neighborIndex]);
                animals[currentIndex] = null;
            } else if (option.equals("bounce")) {
                System.out.println(animals[currentIndex] + " bounced to  " + animals[neighborIndex]);
            } else if (option.equals("eaten")) {
                System.out.println(animals[currentIndex] + "  was eaten by  " + animals[neighborIndex]);
                animals[currentIndex] = null;
            } else if (option.equals("eat")) {
                System.out.println(animals[currentIndex] + "  eats  " + animals[neighborIndex]);
                animals[neighborIndex] = animals[currentIndex];
                animals[currentIndex] = null;
            }
        }
    }

    private static void printEcosystem(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal != null) {
                System.out.print(animal);
            } else {
                System.out.print("~");
            }
        }
        System.out.println();
    }
}
