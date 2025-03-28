package Projects.simulations.EcosystemSim;

public class Animal {
    private boolean sex;
    private int strength;

    public Animal(int strength, boolean sex) {
        this.strength = strength;
        this.sex = sex;
    }

    public String collide(Animal a) {
        if (a.getSex() != getSex()) {
            return "baby";
        } else {
            if (this.getStrength() > a.getStrength()) {
                return "beat";
            } else if (this.getStrength() < a.getStrength()) {
                return "die";
            } else {
                return "bounce";
            }
        }
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
