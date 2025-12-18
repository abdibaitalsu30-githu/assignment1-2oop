public class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;
    private int experience;
    private Pet pet;

    public Veterinarian(int vetId, String name, String specialization, int experience) {            //constructor
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
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

                                                           //setters
    public void setVetId(int vetId) {
        this.vetId = vetId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

                                                         //additional methods
    public boolean canTreat() {
        if (pet == null || specialization == null || pet.getSpecies() == null) return false;
        String species = pet.getSpecies().trim().toLowerCase();
        if (specialization.equals("Dermatology")) {
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

    @Override
    public String toString() {
        return "Veterinarian{Id=" + vetId + ", name= '" + name +
                "', specialization=" + specialization +  ", experience=" + getExperience() + "}";
    }

}
