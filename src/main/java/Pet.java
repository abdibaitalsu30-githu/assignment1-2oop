public class Pet {
    private int petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;

    public Pet(int petId, String name, String species, int age, String ownerName) {            //constructor
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
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
        this.petId = petId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setOwnerName(String ownerName) {
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
    public String toString() {
        return "Pet{Id=" + petId + ", name= '" + name +
                "', species=" + species + ", Age=" + getAge() + ", Owner name=" + ownerName + "}";
    }
}
