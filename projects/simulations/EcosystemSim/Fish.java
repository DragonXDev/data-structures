package projects.simulations.EcosystemSim;

public class Fish extends Animal {
    public Fish(boolean sex, int strength) {
        super(strength, sex);
    }

    public String collide(Animal a) {
        if (a instanceof Bear) {
            return "eaten";
        }
        return super.collide(a);

    }

    public String collide(Fish a) {
        return super.collide(a);
    }

    public String toString() {
        return "|" + (getSex() ? "f" : "m") + getStrength() + "F|";
    }
}