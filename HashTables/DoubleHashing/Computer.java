package HashTables.DoubleHashing;

public class Computer {
    private String OS;
    private int year;
    private int serial;

    public Computer() {
        OS = "";
        year = -1;
        serial = -1;
    }

    public Computer(String OS, int year, int serial) {
        this.OS = OS;
        this.year = year;
        this.serial = serial;
    }

    public int getKey() {
        return serial;
    }

    public String toString() {
        return "A " + this.OS + " Computer created in " + this.year + ". [" + this.serial + "]";
    }
}