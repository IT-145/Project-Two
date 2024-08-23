public class Monkey extends RescueAnimal {

    // Instance variables specific to monkeys
    private String species;
    private float tailLength;
    private float height;
    private float bodyLength;

    // Default constructor
    public Monkey() {
        // Default constructor logic (if needed)
    }

    // Detailed constructor
    public Monkey(String name, String species, String gender, String age, String weight, String acquisitionDate,
                  String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry,
                  float bodyLength, float height, float tailLength) {
        // Setting values through superclass methods
        setName(name);
        setAnimalType("Monkey");  // Assuming that we need to set the animal type as "Monkey"
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionCountry(acquisitionCountry);  // Changed to setAcquisitionCountry
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

        // Setting monkey-specific values
        this.species = species;
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
    }

    // Accessor and Mutator methods
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public float getTailLength() {
        return tailLength;
    }

    public void setTailLength(float tailLength) {
        this.tailLength = tailLength;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(float bodyLength) {
        this.bodyLength = bodyLength;
    }
}
