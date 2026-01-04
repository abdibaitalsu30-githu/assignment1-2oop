import java.util.ArrayList;

public class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;
    private int experience;
    private Pet pet;
    private ArrayList<Veterinarian> veterinarians;

    public Veterinarian(int vetId, String name, String specialization, int experience) {            //constructor
        setVetId(vetId);
        setName(name);
        this.specialization = specialization;
        setExperience(experience);
        this.veterinarians = new ArrayList<>();
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
    public ArrayList<Veterinarian> getVeterinarians() {
        return veterinarians;
    }

    //setters
    public void setVetId(int vetId) {
        if (vetId >= 100000) {
            this.vetId = vetId;
        }
        else {
            System.out.println("Warning: Id cannot be less than 6 digit! Setting to 0.");
            this.vetId = 0;
        }
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public void setExperience(int experience) {
        if (experience >= 0) {
            this.experience = experience;
        } else {
            System.out.println("Warning: Experience cannot be negative. Setting to 0!");
            this.experience = 0;
        }
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

    public void addVeterinarian(Veterinarian veterinarian) {
        if (veterinarian != null) {
            veterinarians.add(veterinarian);
        }
    }

    @Override
    public String toString() {
        return "Veterinarian{Id=" + vetId + ", name= '" + name +
                "', specialization=" + specialization +  ", experience=" + getExperience() + "}";
    }

}
