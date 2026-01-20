package menu;

import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;
public class VetclinicMenu implements Menu {
    private ArrayList<Treatment> allTreatment;
    private ArrayList<Pet> pets;
    private ArrayList<Owner> owners;
    private ArrayList<Veterinarian> veterinarians;
    private Scanner scanner;

    public VetclinicMenu() {
        this.allTreatment = new ArrayList<>();
        this.pets = new ArrayList<>();
        this.owners = new ArrayList<>();
        this.veterinarians = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        try {
            allTreatment.add(new Vaccination(484854, 385678, "01.12.25", "Completed", 234.4, "Rabies", 4.2));
            allTreatment.add(new Checkup(897656, 285342, "02.11.25", "Completed", 50.6, 7));

            pets.add(new Pet(244554, "Jane", "dog", 6, "Mark"));
            pets.add(new Pet(385678, "Minny", "cat", 12, "Mark"));
            pets.add(new Pet(253574, "Ozhik", "hedgehog", 2, "Alsu"));
            pets.add(new Pet(285342, "Wink", "golden fish", 3, "Diana"));

            owners.add(new Owner(131234, "Mark", 756843198, 2));
            owners.add(new Owner(364845, "Alsu", 283746232, 1));
            owners.add(new Owner(223554, "Diana", 354333645, 1));

            veterinarians.add(new Veterinarian(446554, "Pamela", "Dermatology", 6));
            veterinarians.add(new Veterinarian(897987, "Marcus", "Exotology", 5));
            veterinarians.add(new Veterinarian(495733, "Botagoz", "Ichthyologist", 12));

        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

        @Override
        public void displayMenu() {
            System.out.println("\n========================================");
            System.out.println("    VETCLINIC MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Vaccination");
            System.out.println("2. Add Checkup");
            System.out.println("3. View all treatment");
            System.out.println("4. View Vaccination only");
            System.out.println("5. View Checkup only");
            System.out.println("6. Give all treatment price");
            System.out.println("7. Add pet");
            System.out.println("8. View all pets");
            System.out.println("9. Add owner");
            System.out.println("10. View all owners");
            System.out.println("11. Heal pet");
            System.out.println("0. Exit");
            System.out.println("========================================");
        }

        @Override
        public void run() {
            boolean running = true;

            while (running) {
                displayMenu();
                System.out.print("Enter your choice: ");
                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            addVaccination();
                            break;
                        case 2:
                            addCheckup();
                            break;
                        case 3:
                            viewAllTreatment();
                            break;
                        case 4:
                            viewVaccinations();
                            break;
                        case 5:
                            viewCheckups();
                            break;
                        case 6:
                            demonstratePolymorphism();
                            break;
                        case 7:
                            addPet();
                            break;
                        case 8:
                            viewAllPets();
                            break;
                        case 9:
                            addOwner();
                            break;
                        case 10:
                            viewAllOwners();
                            break;
                        case 11:
                            healPet();
                            break;
                        case 0:
                            running = false;
                            System.out.println("\nThank you for using Vetclinic Management System!");
                            System.out.println("Goodbye! ");
                            break;
                        default:
                            System.out.println("\n Invalid choice! Please select 0-11.");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number!");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    scanner.nextLine();
                }
            }
            scanner.close();
        }

    private void addVaccination() {
        try {
            System.out.println("\n--- ADD VACCINATION ---");

            System.out.print("Enter treatmentId: ");
            int treatmentId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter petID: ");
            int petid = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter date: ");
            String date = scanner.nextLine();

            System.out.print("Enter status: ");
            String status = scanner.nextLine();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter vaccine name: ");
            String vaccineName = scanner.nextLine();

            System.out.print("Enter dose: ");
            double doseMl = scanner.nextDouble();
            scanner.nextLine();

            Vaccination vaccination = new Vaccination(treatmentId, petid, date, status, price, vaccineName, doseMl);
            allTreatment.add(vaccination);
            System.out.println("Vaccination added successfully!");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid Input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void addCheckup() {
        try {
        System.out.println("\n--- ADD CHECKUP ---");

        System.out.print("Enter treatmentId: ");
        int treatmentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter petID: ");
        int petid = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter date: ");
        String date = scanner.nextLine();

        System.out.print("Enter status: ");
        String status = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter condition score: ");
        int conditionScore = scanner.nextInt();
        scanner.nextLine();

        Checkup checkup = new Checkup(treatmentId, petid, date, status, price, conditionScore);
        allTreatment.add(checkup);
        System.out.println("Checkup added successfully!");

    } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid Input type!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewAllTreatment() {
        System.out.println("\n========================================");
        System.out.println("           ALL TREATMENT");
        System.out.println("========================================");
        if (allTreatment.isEmpty()) {
            System.out.println("No treatment found.");
            return;
        }

        for (int i = 0; i < allTreatment.size(); i++) {
            Treatment t = allTreatment.get(i);
            System.out.println((i + 1) + ". ");
            if (t instanceof Vaccination) {
                System.out.print("[VACCINATION]");
                Vaccination vaccination = (Vaccination) t; // Downcast
                if (vaccination.isForBigAnimal()) {
                    System.out.println(" for big animal!");
                }
            } else if (t instanceof Checkup) {
                System.out.print("[CHECKUP]");
                Checkup checkup = (Checkup) t; // Downcast
                if (checkup.isSick()) {
                    System.out.println(" is sick!");
                }
            } else {
                System.out.print("[TREATMENT]");
            }

            System.out.println(t.toString());
        }
    }

    private void viewVaccinations() {
        System.out.println("\n========================================");
        System.out.println("          VACCINATIONS ONLY");
        System.out.println("========================================");
        boolean foundVaccination = false;
        for (Treatment t : allTreatment) {
            if (t instanceof Vaccination) {
                Vaccination vaccination = (Vaccination) t;
                System.out.println(vaccination.toString());
                System.out.println(" Vaccine name: " + vaccination.getVaccineName());
                System.out.println(" Dose: " + vaccination.getDoseMl());
                if (vaccination.isForBigAnimal()) {
                    System.out.println(" for big animal!");
                }
                System.out.println();
                foundVaccination = true;
            }
        }
        if (!foundVaccination) {
            System.out.println("No vaccinations found.");

        }
    }

    private void viewCheckups() {
        System.out.println("\n========================================");
        System.out.println(" CHECKUPS ONLY");
        System.out.println("========================================");
        boolean foundCheckup = false;
        for (Treatment t : allTreatment) {
            if (t instanceof Checkup) {
                Checkup checkup = (Checkup) t;
                System.out.println(checkup.toString());
                System.out.println(" Condition score: " + checkup.getConditionScore());
                if (checkup.isSick()) {
                    System.out.println(" is sick!");
                }
                System.out.println();
                foundCheckup = true;
            }
        }
        if (!foundCheckup) {
            System.out.println("No checkups found.");

        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println(" POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        if (allTreatment.isEmpty()) {
            System.out.println("No treatment to demonstrate. ");
            return;
        }

        for (Treatment t : allTreatment) {
            t.Price();
        }
        System.out.println(" Notice: Same method name (price), different output!");
        System.out.println(" This is POLYMORPHISM in action!");
    }

    private void addPet() {
        try {
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

            Pet pet = new Pet(petId, name, species, age, ownerName);
            pets.add(pet);
            System.out.println("Pet added successfully!");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewAllPets() {
        System.out.println("\n========================================");
        System.out.println("             ALL PETS");
        System.out.println("========================================");
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }

        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.println((i + 1) + ". " + pets.get(i).toString());
        }
    }

    private void addOwner() {
        try {
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

        Owner owner = new Owner(ownerId, name, phone, numberOfPets);
        owners.add(owner);
        System.out.println("Owner added successfully!");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewAllOwners() {
        System.out.println("\n========================================");
        System.out.println(" ALL OWNERS");
        System.out.println("========================================");
        if (owners.isEmpty()) {
            System.out.println("No owners found.");
            return;
        }
        for (int i = 0; i < owners.size(); i++) {
            Owner owner = owners.get(i);
            System.out.println((i + 1) + ". " + owners.get(i).toString());
        }
    }

    private void healPet() {
        System.out.println("\n--- Heal Pet ---");

        if (pets.isEmpty()) {
            System.out.println("No pets available to heal");
            return;
        }

        System.out.println("Available items: ");
        for(int i = 0; i < pets.size(); i++) {
            System.out.println((i+1) + ". " + pets.get(i).getName());
        }

        try {
            System.out.print("Select pet number to heal: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > pets.size()) {
                throw new InvalidInputException("Invalid item number!");
            }

            Pet pet = pets.get(choice - 1);
            pet.heal();
            System.out.println("Way to heal: " + pet.getWay());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a valid number!");
            scanner.nextLine();
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
