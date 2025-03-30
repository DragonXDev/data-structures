package HashTables.BirdCatalogueHashTable;

/*
Species (in bird)
Sex (M or F)
Age (in years)
Weight (in oz)
Serial Number (assigned by the scientists - each bird's serial number is unique. The serial numbers will be in the range 1000 - 9999.)

Constructor
The constructor takes in parameters in the order listed above for each of the attributes

hashCode()
The Bird class overrides the hashCode() method and returns the bird's serial number

toString()
The toString return value should be in the following format:

A <male/female> <species>, age <age>, weight <weight> oz.

For example: A male Robin, age 2, weight 2.4 oz.

A <male/female> <species>, age <age>, weight <weight> oz.
*/

class Bird {
    private String species;
    private String sex;
    private int age;
    private double weight;
    private int serialNo;

    public Bird(
            String species,
            String sex,
            int age,
            double weight,
            int serialNo) {
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.serialNo = serialNo;

    }

    @Override
    public int hashCode() {
        return serialNo;
    }

    public String toString() {
        String sexStr = "";
        switch (sex) {
            case "M":
                sexStr = "male";
                break;
            case "F":
                sexStr = "female";
        }

        return String.format(
                "A %1$s %2$s age %3$d, weight %4$.1f oz.",
                sexStr, species, age, weight);
    }
}
