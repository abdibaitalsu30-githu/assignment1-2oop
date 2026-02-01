package menu;

import model.*;
import exception.InvalidInputException;
import database.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VetclinicMenu implements Menu {
    private ArrayList<Pet> pets;
    private ArrayList<Owner> owners;
    private ArrayList<Veterinarian> veterinarians;
    private Scanner scanner;
    private TreatmentDAO treatmentDAO;

    public VetclinicMenu() {
        this.pets = new ArrayList<>();
        this.owners = new ArrayList<>();
        this.veterinarians = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.treatmentDAO = new TreatmentDAO();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  RESTAURANT MANAGEMENT SYSTEM v2.0     ║");
        System.out.println("║  Week 8: Fully Database-Driven         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("✅ All data is stored in PostgreSQL");
        System.out.println("✅ No in-memory ArrayLists for treatment");
        System.out.println("✅ Complete CRUD operations");

        try {
            pets.add(new Pet(244554, "Jaja", "dog", 6, "Mark"));
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
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║         MAIN MENU - Week 8             ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("┌─ STAFF MANAGEMENT ─────────────────────┐");
            System.out.println("│ 1. Add Vaccination                     │");
            System.out.println("│ 2. Add Checkup                         │");
            System.out.println("│ 3. View All Treatment                  │");
            System.out.println("│ 4. View Vaccinations Only              │");
            System.out.println("│ 5. View Checkups Only                  │");
            System.out.println("│ 6. Update Treatment                    │");
            System.out.println("│ 7. Delete Treatment                    │");
            System.out.println("├─ SEARCH & FILTER ──────────────────────┤");
            System.out.println("│ 8. Search by Patient Name              │");
            System.out.println("│ 9. Search by Price Range               │");
            System.out.println("│10. High-Costed Treatment (Price >= X)  │");
            System.out.println("├─ DEMO & OTHER ─────────────────────────┤");
            System.out.println("│11. Polymorphism Demo                   │");
            System.out.println("│12. Add Pet                             │");
            System.out.println("│13. View all pets                       │");
            System.out.println("│14. Add Owner                           │");
            System.out.println("│15. View all owners                     │");
            System.out.println("│16. View all veterinarians              │");
            System.out.println("│17. Heal pet                            │");
            System.out.println("│ 0. Exit                                │");
            System.out.println("└────────────────────────────────────────┘");
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
                            updateTreatment();
                            break;
                        case 7:
                            deleteTreatment();
                            break;
                        case 8:
                            searchByPatientName();
                            break;
                        case 9:
                            searchByPriceRange();
                            break;
                        case 10:
                            searchHighCostedTreatment();
                            break;
                        case 11:
                            demonstratePolymorphism();
                            break;
                        case 12:
                            addPet();
                            break;
                        case 13:
                            viewAllPets();
                            break;
                        case 14:
                            addOwner();
                            break;
                        case 15:
                            viewAllOwners();
                            break;
                        case 16:
                            viewAllVeterinarians();
                            break;
                        case 17:
                            healPet();
                            break;
                        case 0:
                            running = false;
                            System.out.println("\n╔════════════════════════════════════════╗");
                            System.out.println("║  Thank you for using our system!      ║");
                            System.out.println("║  Goodbye! 👋                          ║");
                            System.out.println("╚════════════════════════════════════════╝");
                            break;
                        default:
                            System.out.println("❌ Invalid choice! Please select 0-17.");
                    }

                    if (choice != 0) {
                        pressEnterToContinue();
                    }

                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number!");
                    scanner.nextLine();
                    pressEnterToContinue();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    scanner.nextLine();
                    pressEnterToContinue();
                }
            }
            scanner.close();
        }

    private void addVaccination() {
        try {
            System.out.println("\n┌─ ADD VACCINATION ──────────────────────┐");

            System.out.print("| Enter Vaccination ID: ");
            int treatmentId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("| Enter patient name: ");
            String patientName = scanner.nextLine();

            System.out.print("| Enter date: ");
            String date = scanner.nextLine();

            System.out.print("| Enter status: ");
            String status = scanner.nextLine();

            System.out.print("| Enter price (KZT): ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("| Enter vaccine name: ");
            String vaccineName = scanner.nextLine();

            System.out.print("| Enter dose (ml): ");
            double doseMl = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("└────────────────────────────────────────┘");

            Vaccination vaccination = new Vaccination(treatmentId, patientName, date, status, price, vaccineName, doseMl);
            treatmentDAO.insertVaccination(vaccination);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid Input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void addCheckup() {
        try {
            System.out.println("\n┌─ ADD CHECKUP ──────────────────────────┐");

            System.out.print("| Enter Checkup ID: ");
            int treatmentId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("| Enter patient name: ");
            String patientName = scanner.nextLine();

            System.out.print("| Enter date: ");
            String date = scanner.nextLine();

            System.out.print("| Enter status: ");
            String status = scanner.nextLine();

            System.out.print("| Enter price (KZT): ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("| Enter condition score (1-9): ");
            int conditionScore = scanner.nextInt();
            scanner.nextLine();

            System.out.println("└────────────────────────────────────────┘");

            Checkup checkup = new Checkup(treatmentId, patientName, date, status, price, conditionScore);
            treatmentDAO.insertCheckup(checkup);

    } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid Input type!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewAllTreatment() {
        treatmentDAO.displayAllTreatment();
    }

    private void viewVaccinations() {
        List<Vaccination> vaccinations = treatmentDAO.getAllVaccinations();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          VACCINATIONS ONLY             ║");
        System.out.println("╚════════════════════════════════════════╝");

        if(vaccinations.isEmpty()) {
            System.out.println(" No vaccinations in database.");
        } else {
            for (int i = 0; i < vaccinations.size(); i++) {
                Vaccination vaccination = vaccinations.get(i);
                System.out.println((i+1) + ". " + vaccination.toString());
                System.out.println("   Vaccine name: " + vaccination.getVaccineName());
                System.out.println("   Dose: " + vaccination.getDoseMl() + "ml");
                if (vaccination.isForBigAnimal()) {
                    System.out.println(vaccination.getPatientName() + " is a big one ;)");
                }
                System.out.println();
            }
            System.out.println("Total vaccinations: " + vaccinations.size());
        }
    }

    private void viewCheckups() {
        List<Checkup> checkups = treatmentDAO.getAllCheckups();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          CHECKUPS ONLY                 ║");
        System.out.println("╚════════════════════════════════════════╝");

        if(checkups.isEmpty()) {
            System.out.println("No checkups in database.");
        } else {
            for (int i = 0; i < checkups.size(); i++) {
                Checkup checkup = checkups.get(i);
                System.out.println((i+1) + ". " + checkup.toString());
                System.out.println("  Condition score: " + checkup.getConditionScore());
                if (checkup.isSick()) {
                    System.out.println(checkup.getPatientName() + " is sick :(. ");
                }
                System.out.println();
            }
            System.out.println("Total checkups: " + checkups.size());
        }
    }

    private void updateTreatment() {
        System.out.println("\\n┌─ UPDATE TREATMENT ─────────────────────┐");
        System.out.println("| Enter Treatment ID to update: ");

        try {
            int treatmentId = scanner.nextInt();
            scanner.nextLine();

            Treatment existingTreatment = treatmentDAO.getTreatmentById(treatmentId);

            if(existingTreatment == null) {
                System.out.println("No treatment found with ID: " + treatmentId);
                return;
            }

            System.out.println("| Current Info:");
            System.out.println("| " + existingTreatment.toString());
            System.out.println("└────────────────────────────────────────┘");

            System.out.println("\\n┌─ ENTER NEW VALUES ─────────────────────┐");
            System.out.println("│ (Press Enter to keep current value)   │");

            System.out.print("│ New Name [" + existingTreatment.getPatientName() + "]: ");
            String newPatientName = scanner.nextLine();
            if (newPatientName.trim().isEmpty()) {
                newPatientName = existingTreatment.getPatientName();
            }
            System.out.print("| New Date [" + existingTreatment.getDate() + "]: ");
            String newDate = scanner.nextLine();
            if (newDate.trim().isEmpty()) {
                newDate = existingTreatment.getDate();
            }
            System.out.print("| New Status [" + existingTreatment.getStatus() + "]: ");
            String newStatus = scanner.nextLine();
            if (newStatus.trim().isEmpty()) {
                newStatus = existingTreatment.getStatus();
            }
            System.out.print("| New Price [" + existingTreatment.getPrice() + "]: ");
            String priceInput = scanner.nextLine();
            double newPrice = priceInput.trim().isEmpty() ?
                existingTreatment.getPrice() : Double.parseDouble(priceInput);

            if (existingTreatment instanceof Vaccination) {
                Vaccination vaccination = (Vaccination) existingTreatment;
                System.out.print("| New Vaccine Name: [" + vaccination.getVaccineName() + "]: ");
                String newVaccineName = scanner.nextLine();
                if(newVaccineName.trim().isEmpty()) {
                    newVaccineName = vaccination.getVaccineName();
                }
                System.out.print("| New dose(ml): [" + vaccination.getDoseMl() + "]: ");
                String doseInput = scanner.nextLine();
                double newDose = doseInput.trim().isEmpty() ?
                        vaccination.getDoseMl() : Double.parseDouble(doseInput);
                Vaccination updatedVaccination = new Vaccination(treatmentId, newPatientName, newDate, newStatus, newPrice, newVaccineName, newDose);
                treatmentDAO.updateVaccination(updatedVaccination);
            }

            else if(existingTreatment instanceof Checkup) {
                Checkup checkup = (Checkup) existingTreatment;
                System.out.print("| New Condition Score: [" + checkup.getConditionScore() + "]: ");
                String conditionScoreInput = scanner.nextLine();
                int newConditionScore = conditionScoreInput.trim().isEmpty() ?
                        checkup.getConditionScore() : Integer.parseInt(conditionScoreInput);
                Checkup updatedCheckup = new Checkup(treatmentId, newPatientName, newDate, newStatus, newPrice, newConditionScore);
                treatmentDAO.updateCheckup(updatedCheckup);
            }
            System.out.println("└────────────────────────────────────────┘");


        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Validaion Error: " + e.getMessage());
        }
    }

    private void deleteTreatment() {
        System.out.println("\n┌─ DELETE TREATMENT ─────────────────────┐");
        System.out.print("│ Enter Treatment ID to delete: ");

        try {
            int treatmentId = scanner.nextInt();
            scanner.nextLine();

            Treatment treatment = treatmentDAO.getTreatmentById(treatmentId);

            if (treatment == null) {
                System.out.println("No treatment found with ID: " + treatmentId);
                return;
            }

            System.out.println("| Treatment to delete: ");
            System.out.println("|" + treatment.toString());
            System.out.println("└────────────────────────────────────────┘");

            System.out.print(" Are you sure?? (yes/no): ");
            String confirmation = scanner.nextLine();

            if(confirmation.equalsIgnoreCase("yes")) {
                treatmentDAO.deleteTreatment(treatmentId);
            } else {
                System.out.println("Deletion cancelled!");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input!");
            scanner.nextLine();
        }
    }

    private void searchByPatientName() {
         try {
             System.out.println("\n┌─ SEARCH BY PATIENT NAME ───────────────┐");
             System.out.print("│ Enter patient name to search: ");
             String patientName = scanner.nextLine();
             System.out.println("└────────────────────────────────────────┘");

             List<Treatment> results = treatmentDAO.searchByPatientName(patientName);
             displaySearchResults(results, "Search: '" + patientName + "'");
         } catch (java.util.InputMismatchException e) {
             System.out.println("Error: Invalid data type!");
             scanner.nextLine();
         }
    }

    private void searchByPriceRange() {
        try {
            System.out.println("\n┌─ SEARCH BY PRICE RANGE  ───────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minPrice = scanner.nextDouble();

            System.out.print("│ Enter maximum price: ");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<Treatment> results = treatmentDAO.searchByPriceRange(minPrice, maxPrice);

            displaySearchResults(results, "Price: " + minPrice + " - " + maxPrice + " KZT");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid number!");
            scanner.nextLine();
        }
    }

    private void searchHighCostedTreatment() {
        try {
            System.out.println("\n┌─ HIGH-COSTED TREATMENT ────────────────┐");
            System.out.print("│ Enter minimum price: ");
            double minPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<Treatment> results = treatmentDAO.searchByMinPrice(minPrice);

            displaySearchResults(results, "Price >= " + minPrice + " KZT");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid number!");
            scanner.nextLine();
        }
    }

    private void displaySearchResults(List<Treatment> results, String criteria) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SEARCH RESULTS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Criteria: " + criteria);
        System.out.println("─────────────────────────────────────────");

        if(results.isEmpty()) {
            System.out.println("No treatment found matching criteria.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                Treatment t = results.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + t.getAppointment() + "] ");
                System.out.println(t.toString());
            }
            System.out.println("─────────────────────────────────────────");
            System.out.println("Total results: " + results.size());
        }
    }

    private void demonstratePolymorphism() {
        treatmentDAO.demonstratePolymorphism();
    }

    private void addPet() {
        try {
            System.out.println("\n┌─ ADD PET ──────────────────────────────┐");

            System.out.print("| Enter pet ID: ");
            int petId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("| Enter name: ");
            String name = scanner.nextLine();

            System.out.print("| Enter species: ");
            String species = scanner.nextLine();

            System.out.print("| Enter age (years): ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("| Enter owner name: ");
            String ownerName = scanner.nextLine();

            System.out.print("| Is young? (true/false): ");
            boolean isYoung = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("| On which Life Stage: ");
            String getLifeStage = scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            Pet pet = new Pet(petId, name, species, age, ownerName);
            pets.add(pet);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewAllPets() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║               ALL PETS                 ║");
        System.out.println("╚════════════════════════════════════════╝");
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
            System.out.println("\n┌─ ADD OWNER ────────────────────────────┐");

            System.out.print("| Enter Owner ID: ");
            int ownerId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("| Enter name: ");
            String name = scanner.nextLine();

            System.out.print("| Enter phone (+7..): ");
            int phone = scanner.nextInt();

            System.out.print("| Enter number of pets: ");
            int numberOfPets = scanner.nextInt();

            System.out.print("| Is frequent client? (true/false): ");
            boolean isFrequentClient = scanner.nextBoolean();
            scanner.nextLine();

            Owner owner = new Owner(ownerId, name, phone, numberOfPets);
            owners.add(owner);
            System.out.println("└────────────────────────────────────────┘");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input type!");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewAllOwners() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║              ALL OWNERS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        if (owners.isEmpty()) {
            System.out.println("No owners found.");
            return;
        }
        for (int i = 0; i < owners.size(); i++) {
            Owner owner = owners.get(i);
            System.out.println((i + 1) + ". " + owners.get(i).toString());
        }
    }

    private void viewAllVeterinarians() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          ALL VETERINARIANS             ║");
        System.out.println("╚════════════════════════════════════════╝");
        if (veterinarians.isEmpty()) {
            System.out.println("No veterinarians found.");
            return;
        }
        for (int i = 0; i < veterinarians.size(); i++) {
            Veterinarian veterinarian = veterinarians.get(i);
            System.out.println((i + 1) + ". " + veterinarians.get(i).toString());
        }
    }

    private void healPet() {
        System.out.println("\n┌─ HEAL PET ────────────────────────────┐");

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
            System.out.println("└────────────────────────────────────────┘");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a valid number!");
            scanner.nextLine();
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void pressEnterToContinue() {
        System.out.println("\n[Press Enter to continue...]");
        scanner.nextLine();
    }
}
