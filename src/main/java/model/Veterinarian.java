package model;

public class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;
    private int experience;
    private Pet pet;

    public Veterinarian(int vetId, String name, String specialization, int experience) {            //constructor
        setVetId(vetId);
        setName(name);
        setSpecialization(specialization);
        setExperience(experience);
    }

    public Veterinarian() {                                 //default constructor
        this.vetId = 232425;
        this.name = "Noah";
        this.specialization = "cardiology";
        this.experience = 23;
    }

    //getters
    public int getVetId() {
        return vetId;
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }
    public String getExperience() {
        return experience + " years";
    }

    public void setVetId(int vetId) {
        if (vetId < 100000 || vetId > 999999) {
            throw new IllegalArgumentException("VetId must be 6 digits");
        }
        this.vetId = vetId;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Veterinarian name cannot be empty");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("Veterinarian name must be at least 2 characters");
        }
        this.name = name;
    }
    public void setSpecialization(String specialization) {
        if (specialization == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Veterinarian specialization cannot be empty");
        }
        this.specialization = specialization;
    }
    public void setExperience(int experience) {
        if (experience <= 0) {
            throw new IllegalArgumentException("Veterinarian experience must be positive");
        }
        this.experience = experience;
    }

                                                         //additional methods
    public boolean canTreat() {
        if (pet == null || specialization == null || pet.getSpecies() == null) return false;
        String species = pet.getSpecies().trim().toLowerCase();
        if (specialization.equals("Surgeon")) {
            return species.equals("cat") || species.equals("dog");
        }
        if (specialization.equals("Exotology")) {
            return species.equals("hedgehog");
        }
        if (specialization.equals("Ichthyologist")) {
            return species.equals("golden fish");
        }
        return false;
    }

    public boolean isExperienced() {
        return experience > 6;
    }

    public void displayInfo() {
        System.out.println("Vet ID: " + vetId);
        System.out.println("Vet name: " + name);
        System.out.println("Vet specialization: " + specialization);
        System.out.println("Vet experience: " + experience);
    }

    @Override
    public String toString() {
        return "model.Veterinarian{Id=" + vetId + ", name= '" + name +
                "', specialization=" + specialization +  ", experience=" + getExperience() + "}";
    }

}
