import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Veterinarian> veterinarians = new ArrayList<>();
    private static ArrayList<Treatment> allTreatment = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* week three output
        System.out.println("=== Vetclinic Management System ===");
        System.out.println();

        Pet pet1 = new Pet(438748, "Johnny", "dog", 4, "Mark");
        Pet pet2 = new Pet(385678, "Minny", "cat", 12, "Mark");
        Pet pet3 = new Pet(253574, "Ozhik", "hedgehog", 2, "Alsu");
        Pet pet4 = new Pet(285342, "Wink", "golden fish", 3, "Diana");
        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        pets.add(pet4);

        Owner owner1 = new Owner(131234, "Mark", 756843198, 2);
        Owner owner2 = new Owner(364845, "Alsu", 283746232, 1);
        Owner owner3 = new Owner(223554, "Diana", 354333645, 1);
        Owner owner = new Owner();
        owner.getPets().add(pet2);
        owners.add(owner1);
        owners.add(owner2);
        owners.add(owner3);

        Veterinarian veterinarian1 = new Veterinarian(446554, "Pamela", "Surgeon", 6);
        Veterinarian veterinarian2 = new Veterinarian(323122, "Marcus", "Exotology", 5);
        Veterinarian veterinarian3 = new Veterinarian(495733, "Botagoz", "Ichthyologist", 12);
        veterinarians.add(veterinarian1);
        veterinarians.add(veterinarian2);
        veterinarians.add(veterinarian3);

        boolean running = true;
        while (running) {
            displayVetclinic();
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addPet();
                    break;
                case 2:
                    viewAllPets();
                    break;
                case 3:
                    addOwner();
                    break;
                case 4:
                    viewAllOwners();
                    break;
                case 0:
                    System.out.println("\nGoodbye! ");
                    running = false; // Exit loop
                    break;
                default:
                    System.out.println("\n Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine(); // Wait for user
            }
        }
        scanner.close(); // Clean up

        displayVetclinic();*/


        allTreatment.add(new Treatment(323333, 438748, "01.02.26", "Scheduled", 123.9));
        allTreatment.add(new Vaccination(484854, 385678, "01.12.25", "Completed", 234.4, "Rabies", 4.2));
        allTreatment.add(new Checkup(897656, 285342, "02.11.25", "Completed", 50.6, 7));

        boolean running = true;
        while (running) {
            displayTreatment();
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addTreatment();
                    break;
                case 2:
                    addVaccination();
                    break;
                case 3:
                    addCheckup();
                    break;
                case 4:
                    viewAllTreatment();
                    break;
                case 5:
                    demonstratePolymorphism();
                    break;
                case 6:
                    viewVaccinations();
                    break;
                case 7:
                    viewCheckups();
                    break;
                case 0:
                    System.out.println("\nGoodbye! ");
                    running = false; // Exit loop
                    break;
                default:
                    System.out.println("\n Invalid choice!");
            }
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine(); // Wait for user
            }
        }
        scanner.close();

        displayTreatment();
    }

    /*week3
    private static void displayVetclinic() {
        System.out.println("\n========================================");
        System.out.println("VET CLINIC MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Pet");
        System.out.println("2. View Pets");
        System.out.println("3. Add Owner");
        System.out.println("4. View All Owners");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void addPet() {
        System.out.println("\n--- ADD PET ---");

        System.out.print("Enter petId: ");
        int petId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter species: ");
        String species = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter owner name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Is young? (true/false): ");
        boolean isYoung = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("On which Life Stage: ");
        String getLifeStage = scanner.nextLine();

        Pet pet = new Pet();
        pets.add(pet);

        System.out.println(" Pet added successfully!");
    }

    private static void viewAllPets() {
        System.out.println("\n========================================");
        System.out.println(" ALL PETS");
        System.out.println("========================================");
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }
        System.out.println("Total pets: " + pets.size());
        System.out.println();
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.println((i + 1) + ". " + pet.getPetId() +
                    " - " + pet.getName());
            System.out.println("Species: " + pet.getSpecies());
            System.out.println("Age: " + pet.getAge());
            System.out.println("Owner name: " + pet.getOwnerName());
            System.out.println("Is young: " +
                    (pet.isYoung() ? " Yes" : " No"));
            System.out.println("ON this life stage: " + pet.getLifeStage());
            System.out.println();
        }
    }

    private static void addOwner() {
        System.out.println("\n--- ADD OWNER ---");

        System.out.print("Enter ownerId: ");
        int ownerId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone: ");
        int phone = scanner.nextInt();

        System.out.print("Enter number of pets: ");
        int numberOfPets = scanner.nextInt();

        System.out.print("Is frequent client? (true/false): ");
        boolean isFrequentClient = scanner.nextBoolean();
        scanner.nextLine();

        Owner owner = new Owner();
        owners.add(owner);

        System.out.println("Owner added successfully!");
    }

    private static void viewAllOwners() {
        System.out.println("\n========================================");
        System.out.println(" ALL OWNERS");
        System.out.println("========================================");
        if (owners.isEmpty()) {
            System.out.println("No owners found.");
            return;
        }
        System.out.println("Total clients: " + owners.size());
        System.out.println();
        for (int i = 0; i < owners.size(); i++) {
            Owner owner = owners.get(i);
            System.out.println((i + 1) + ". " + owner.getOwnerId() + " - " + owner.getName());
            System.out.println("Phone: " + owner.getPhone());
            System.out.println("Number of pets: " + owner.getNumberOfPets());
            System.out.println("Is frequent client: " +
                    (owner.isFrequentClient() ? " Yes" : " No"));
            System.out.println();
        }
    }
*/

    private static void displayTreatment() {
        System.out.println("\n========================================");
        System.out.println("VET CLINIC MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Treatment (General)");
        System.out.println("2. Add Vaccination");
        System.out.println("3. Add Checkup");
        System.out.println("4. View all treatment (polymorphic)");
        System.out.println("5. Give all treatment price");
        System.out.println("6. View Vaccination only");
        System.out.println("7. View Checkup only");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private static void addTreatment() {
        System.out.println("\n--- ADD TREATMENT ---");

        System.out.print("Enter treatmentId: ");
        int treatmentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter petID: ");
        int PetID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter date: ");
        String date = scanner.nextLine();

        System.out.println("Enter status: ");
        String status = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Treatment treatment7 = new Treatment(232323, 334334, "01.04.26", "Completed", 120.0);
        allTreatment.add(treatment7);

        System.out.println(" Treatment added successfully!");
    }

    private static void addVaccination() {
        System.out.println("\n--- ADD VACCINATION ---");

        System.out.print("Enter treatmentId: ");
        int treatmentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter petID: ");
        int PetID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter date: ");
        String date = scanner.nextLine();

        System.out.println("Enter status: ");
        String status = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter vaccine name: ");
        String vaccineName = scanner.nextLine();

        System.out.print("Enter dose: ");
        double doseMl = scanner.nextDouble();
        scanner.nextLine();

        Treatment treatment5 = new Vaccination(787878,334336,"12.02.26","Scheduled",127.6, "Bordetella", 3.2);
        allTreatment.add(treatment5);

        System.out.println(" Vaccination added successfully!");
    }

    private static void addCheckup() {
        System.out.println("\n--- ADD CHECKUP ---");

        System.out.print("Enter treatmentId: ");
        int treatmentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter petID: ");
        int PetID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter date: ");
        String date = scanner.nextLine();

        System.out.println("Enter status: ");
        String status = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter condition score: ");
        int conditionScore = scanner.nextInt();
        scanner.nextLine();

        Treatment treatment6 = new Checkup(787878,334336,"12.02.26","Scheduled",127.6, 9);
        allTreatment.add(treatment6);

        System.out.println(" Checkup added successfully!");
    }

    private static void viewAllTreatment() {
        System.out.println("\n========================================");
        System.out.println(" ALL TREATMENT (POLYMORPHIC LIST)");
        System.out.println("========================================");
        if (allTreatment.isEmpty()) {
            System.out.println("No treatment members found.");
            return;
        }
        System.out.println("Total treatment: " + allTreatment.size());
        System.out.println();
        for (int i = 0; i < allTreatment.size(); i++) {
            Treatment t = allTreatment.get(i);
            System.out.println((i + 1) + ". " + t);
            if (t instanceof Vaccination) {
                Vaccination vaccination = (Vaccination) t; // Downcast
                if (vaccination.isForBigAnimal()) {
                    System.out.println(" for big animal!");
                }
            } else if (t instanceof Checkup) {
                Checkup checkup = (Checkup) t; // Downcast
                if (checkup.isSick()) {
                    System.out.println(" is sick!");
                }
            }
            System.out.println();
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println(" POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling price() on all treatment:");
        System.out.println();
        for (Treatment t : allTreatment) {
            t.Price();
        }
        System.out.println();
        System.out.println(" Notice: Same method name (price), different output!");
        System.out.println(" This is POLYMORPHISM in action!");
    }

    private static void viewVaccinations() {
        System.out.println("\n========================================");
        System.out.println(" VACCINATIONS ONLY");
        System.out.println("========================================");
        int vaccinationCount = 0;
        for (Treatment t : allTreatment) {
            if (t instanceof Vaccination) {
                Vaccination vaccination = (Vaccination) t;
                vaccinationCount++;
                System.out.println(vaccinationCount + ". " + vaccination.getVaccineName());
                System.out.println(" TreatmentId: " + vaccination.getTreatmentId());
                System.out.println(" Dose: " + vaccination.getDoseMl());
                if (vaccination.isForBigAnimal()) {
                    System.out.println(" for big animal!");
                }
                System.out.println();
            }
        }
        if (vaccinationCount == 0) {
            System.out.println("No vaccinations found.");
        }
    }

    private static void viewCheckups() {
        System.out.println("\n========================================");
        System.out.println(" CHECKUPS ONLY");
        System.out.println("========================================");
        int checkupCount = 0;
        for (Treatment t : allTreatment) {
            if (t instanceof Checkup) {
                Checkup checkup = (Checkup) t;
                checkupCount++;
                System.out.println(checkupCount + ". " + checkup.getTreatmentId());
                System.out.println(" Status: " + checkup.getStatus());
                System.out.println(" Dose: " + checkup.getConditionScore());
                if (checkup.isSick()) {
                    System.out.println(" is sick!");
                }
                System.out.println();
            }
        }
        if (checkupCount == 0) {
            System.out.println("No checkups found.");
        }
    }

}
