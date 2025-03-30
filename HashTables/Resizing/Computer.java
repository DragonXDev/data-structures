package HashTables.Resizing;

public class Computer {

    private String os;
    private int year;
    private int SerialNumber;

    public Computer() {
        this.os = "";
        this.year = -1;
        this.SerialNumber = -1;
    }

    public Computer(String os, int year, int SerialNumber) {
        this.os = os;
        this.year = year;
        this.SerialNumber = SerialNumber;
    }

    public String getOs() {
        return this.os;
    }

    public int getYear() {
        return this.year;
    }

    public int getSerialNumber() {
        return this.SerialNumber;
    }

    public int getKey() {
        return this.SerialNumber;
    }

    public String toString() {
        return "A " + this.os + " Computer created in " + this.year + ". [" + this.SerialNumber + "]";
    }
}