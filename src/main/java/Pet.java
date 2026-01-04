import java.util.ArrayList;

public class Pet {
    private int petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;
    private ArrayList<Pet> pets;


    public Pet(int petId, String name, String species, int age, String ownerName) {            //constructor
        setPetId(petId);
        setName(name);
        this.species = species;
        setAge(age);
        setOwnerName(ownerName);
        this.pets = new ArrayList<>();
    }

    public Pet() {                                                                           //default constructor
        this.petId = 676767;
        this.name = "Jass";
        this.species = "dog";
        this.age = 5;
        this.ownerName = "Tony";
        this.pets = new ArrayList<>();
    }

                                                                                            //getters
    public int getPetId() {
        return petId;
    }
    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public String getAge() {
        return age + " years";
    }
    public String getOwnerName() {
        return ownerName;
    }
    public ArrayList<Pet> getPets() {
        return pets;
    }

                                                                                           //setters
    public void setPetId(int petId) {
        if (petId >= 100000) {
            this.petId = petId;
        }
        else {
            System.out.println("Warning: Id cannot be less than 6 digit! Setting to 0.");
            this.petId = 0;
        }
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Warning: Age cannot be negative. Setting to 0!");
            this.age = 0;
        }
    }
    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.trim().isEmpty()) {
            this.ownerName = ownerName;
        } else {
            System.out.println("Warning: Pet cannot be without owner!");
        }
    }

                                                                                          //additional methods
    public boolean isYoung() {
        return age < 3;
    }

    public String getLifeStage() {
        if(age < 3) {
            return "Young";
        } else if(age < 6) {
            return "Adult";
        } else {
            return "Senior";
        }
    }

    public void addPet(Pet pet) {
        if (pet != null) {
            pets.add(pet);
        }
    }

    @Override
    public String toString() {
        return "Pet{Id=" + petId + ", name= '" + name +
                "', species=" + species + ", Age=" + getAge() + ", Owner name=" + ownerName + "}";
    }
}
