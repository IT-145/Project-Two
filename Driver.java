import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // List to hold dog objects
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // List to hold monkey objects
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();

        Scanner scanner = new Scanner(System.in);
        String selection = "";

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        // For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods
        // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        while (!selection.equalsIgnoreCase("q")) {
            displayMenu();
            selection = scanner.nextLine();

            // Menu selection
            switch (selection) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Exiting application");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    // Optional for testing
    public static void initializeMonkeyList() {
        // Add test monkeys here if needed
    }

    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        System.out.println("Enter the breed:");
        String breed = scanner.nextLine();
        System.out.println("Enter the gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter the age:");
        String age = scanner.nextLine();
        System.out.println("Enter the weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the acquisition date:");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter the in-service country:");
        String inServiceCountry = scanner.nextLine();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);
        System.out.println("New dog added successfully.");
    }

    // Complete intakeNewMonkey
    // Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; // returns to the menu
            }
        }

        // Collect other attributes for the new monkey
        System.out.println("Enter the species (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin):");
        String species = scanner.nextLine();
        System.out.println("Enter the gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter the age:");
        String age = scanner.nextLine();
        System.out.println("Enter the weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the acquisition date:");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the monkey reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter the in-service country:");
        String inServiceCountry = scanner.nextLine();
        System.out.println("Enter the tail length:");
        float tailLength = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter the height:");
        float height = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter the body length:");
        float bodyLength = Float.parseFloat(scanner.nextLine());

        Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry, bodyLength, height, tailLength);
        monkeyList.add(newMonkey);
        System.out.println("New monkey added successfully.");
    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    // and ensure it is fully trained and not already reserved
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter animal type (dog/monkey):");
        String animalType = scanner.nextLine();
        System.out.println("Enter the in-service country:");
        String inServiceCountry = scanner.nextLine();

        boolean found = false;

        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry)
                        && dog.getTrainingStatus().equalsIgnoreCase("in service")
                        && !dog.getReserved()) {
                    dog.setReserved(true);
                    found = true;
                    System.out.println("Dog reserved successfully.");
                    break;
                }
            }
        } else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry)
                        && monkey.getTrainingStatus().equalsIgnoreCase("in service")
                        && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    found = true;
                    System.out.println("Monkey reserved successfully.");
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No available animals found for reservation.");
        }
    }

    // Helper method to reserve an animal from the list
    public static <T extends RescueAnimal> boolean reserveAnimalHelper(ArrayList<T> animalList, String inServiceCountry) {
        for (T animal : animalList) {
            if (animal.getInServiceLocation().equalsIgnoreCase(inServiceCountry)
                    && animal.getTrainingStatus().equalsIgnoreCase("in service")
                    && !animal.getReserved()) {
                animal.setReserved(true);
                System.out.println(animal.getAnimalType() + " reserved successfully.");
                return true;
            }
        }
        return false;
    }

    // Helper method to print animal details
    public static <T extends RescueAnimal> void printAnimalDetails(ArrayList<T> animalList) {
        for (T animal : animalList) {
            System.out.println(animal.getName() + " | " + animal.getTrainingStatus() + " | " + animal.getAcquisitionCountry() + " | " + (animal.getReserved() ? "Reserved" : "Available"));
        }
    }

    // Complete printAnimals
    // Include the animal name, status, acquisition country and if the animal is reserved.
    // Remember that this method connects to three different menu items.
    // The printAnimals() method has three different outputs
    // based on the listType parameter
    // dog - prints the list of dogs
    // monkey - prints the list of monkeys
    // available - prints a combined list of all animals that are
    // fully trained ("in service") but not reserved
    // Remember that you only have to fully implement ONE of these lists.
    // The other lists can have a print statement saying "This option needs to be implemented".
    // To score "exemplary" you must correctly implement the "available" list.
    public static void printAnimals(String listType) {
        switch (listType) {
            case "dog":
                printAnimalDetails(dogList);
                break;
            case "monkey":
                printAnimalDetails(monkeyList);
                break;
            case "available":
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                        System.out.println(dog.getName() + " | " + dog.getTrainingStatus() + " | " + dog.getAcquisitionCountry() + " | " + (dog.getReserved() ? "Reserved" : "Available"));
                    }
                }
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                        System.out.println(monkey.getName() + " | " + monkey.getTrainingStatus() + " | " + monkey.getAcquisitionCountry() + " | " + (monkey.getReserved() ? "Reserved" : "Available"));
                    }
                }
                break;
            default:
                System.out.println("This option needs to be implemented");
                break;
        }
