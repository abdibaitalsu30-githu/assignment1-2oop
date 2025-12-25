import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Veterinarian> veterinarians = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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

        Veterinarian veterinarian1 = new Veterinarian(446554, "Pamela", "Dermatology", 6);
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

        displayVetclinic();
    }

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

}
