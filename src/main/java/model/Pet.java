package model;

public class Pet implements Healable {
    private int petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;

    public Pet(int petId, String name, String species, int age, String ownerName) {            //constructor
        setPetId(petId);
        setName(name);
        setSpecies(species);
        setAge(age);
        setOwnerName(ownerName);
    }

    public Pet() {                                                                           //default constructor
        this.petId = 676767;
        this.name = "Jass";
        this.species = "dog";
        this.age = 5;
        this.ownerName = "Tony";
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

                                                                                           //setters
    public void setPetId(int petId) {
        if (petId < 100000 || petId > 999999) {
            throw new IllegalArgumentException("PetId must be 6 digits");
        }
        this.petId = petId;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be empty");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("Pet name must be at least 2 characters");
        }
        this.name = name;
    }
    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Pet species cannot be empty");
        }
        if (species.length() < 3) {
            throw new IllegalArgumentException("Pet species must be at least 3 characters");
        }
        this.species = species;
    }
    public void setAge(int age) {
       if (age <= 0) {
           throw new IllegalArgumentException("Pet age cannot be negative");
       }
       this.age = age;
    }
    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        if (ownerName.length() < 2) {
            throw new IllegalArgumentException("Owner name must be at least 2 characters");
        }
        this.ownerName = ownerName;
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

    @Override
    public void heal() {
        System.out.println("Healing " + name + "...");
        System.out.println("Species: " + species);
        System.out.println("Age: " + getAge());
        System.out.println("✅ " + name + " is fully recovered!");
    }

    @Override
    public String getWay() {
        return "Method of healing for " + name + " (" + species + ")";
    }

    public void displayInfo() {
        System.out.println("Pet ID: " + petId);
        System.out.println("Pet name: " + name);
        System.out.println("Pet species: " + species);
        System.out.println("Pet age: " + age);
        System.out.println("Owner name: " + ownerName);
    }

    @Override
    public String toString() {
        return "Pet{Id=" + petId + ", name= '" + name +
                "', species=" + species + ", Age=" + getAge() + ", Owner name=" + ownerName + "}";
    }
}
