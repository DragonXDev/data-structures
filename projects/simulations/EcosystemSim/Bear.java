package projects.simulations.EcosystemSim;

public class Bear extends Animal {

    public Bear(boolean sex, int strength) {
        super(strength, sex);
    }

    public String collide(Animal a) {
        if (a instanceof Fish) {
            return "eat";
        }
        return super.collide(a);
    }

    public String toString() {
        return "|" + (getSex() ? "f" : "m") + getStrength() + "B|";
    }
}