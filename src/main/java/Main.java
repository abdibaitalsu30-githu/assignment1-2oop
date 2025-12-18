public class Main {
    public static void main(String[] args) {
        System.out.println("=== Vetclinic Management System ===");
        System.out.println();


        Pet pet1 = new Pet(438748, "Johnny", "dog", 4, "Mark");
        Pet pet2 = new Pet(385678, "Minny", "cat", 12, "Mark");
        Pet pet3 = new Pet(253574, "Ozhik", "hedgehog", 2, "Alsu");
        Pet pet4 = new Pet(285342, "Wink", "golden fish", 3, "Diana");

        Owner owner1 = new Owner(131234, "Mark", 756843198, 2);
        Owner owner2 = new Owner(364845, "Alsu", 283746232, 1);
        Owner owner3 = new Owner(223554, "Diana", 354333645, 1);
        Owner owner = new Owner();
        owner.getPets().add(pet2);

        Veterinarian veterinarian1 = new Veterinarian(446554, "Pamela", "Dermatology", 6);
        Veterinarian veterinarian2 = new Veterinarian(323122, "Marcus", "Exotology", 5);
        Veterinarian veterinarian3 = new Veterinarian(495733, "Botagoz", "Ichthyologist", 12);


        System.out.println("--- PETS ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);
        System.out.println(pet4);
        System.out.println();

        System.out.println("--- OWNERS ---");
        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println(owner3);
        System.out.println();

        System.out.println("--- VETERINARIANS ---");
        System.out.println(veterinarian1);
        System.out.println(veterinarian2);
        System.out.println(veterinarian3);
        System.out.println();


        System.out.println("--- TESTING GETTERS ---");

        System.out.println("Pet 1 name: " + pet1.getName());
        System.out.println("Pet 1 age: " + pet1.getAge());

        System.out.println("Owner 1 phone: " + owner1.getPhone());

        System.out.println("Veterinarian 1 experience: " + veterinarian1.getExperience());
        System.out.println();


        System.out.println("--- TESTING SETTERS ---");

        System.out.println("Updating pet2...");
        pet4.setPetId(473655);
        pet4.setName("Rocky");
        pet4.setSpecies("horse");
        pet4.setAge(11);
        pet4.setOwnerName("Warren");
        System.out.println("Updated: " + pet4);
        System.out.println();

        System.out.println("Changing owner2 Id...");
        owner2.setOwnerId(525252);
        System.out.println("Updated: " + owner2);
        System.out.println();


        System.out.println("--- TESTING PET METHODS ---");
        System.out.println(pet1.getName() + " is young: " + pet1.isYoung());
        System.out.println(pet3.getName() + " is on " + pet1.getLifeStage() + " life stage");
        System.out.println();

        System.out.println("--- TESTING OWNER METHODS ---");
        System.out.println(owner1.getName() + " has more pets: " + owner1.getPets().add(pet3));
        System.out.println(owner1.getName() + " is frequent client: " + owner1.isFrequentClient());
        System.out.println();

        System.out.println("--- TESTING VETERINARIAN METHODS ---");
        System.out.println(veterinarian2.getName() + " can treat: " + veterinarian2.canTreat());
        System.out.println(veterinarian3.getName() + " is experienced: " + veterinarian3.isExperienced());
        System.out.println();


        System.out.println("--- FINAL STATE ---");
        System.out.println("Pets:");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);
        System.out.println(pet4);
        System.out.println();
        System.out.println("Owners:");
        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println(owner3);
        System.out.println();
        System.out.println("Veterinarians:");
        System.out.println(veterinarian1);
        System.out.println(veterinarian2);
        System.out.println(veterinarian3);
        System.out.println("\n=== Program Complete ===");
    }
}
