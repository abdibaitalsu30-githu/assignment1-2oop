import java.util.ArrayList;

public class Owner {
    private int ownerId;
    private String name;
    private int phone;
    private int numberOfPets;
    private ArrayList<Pet> pets;

    public Owner(int ownerId, String name, int phone, int numberOfPets) {                         //constructor
        this.ownerId = ownerId;
        this.name = name;
        this.phone = phone;
        this.numberOfPets = numberOfPets;
        this.pets = new ArrayList<>();
    }

    //getters
    public double getOwnerId() {
        return ownerId;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return "+7" + phone;
    }
    public int getNumberOfPets() {
        return numberOfPets;
    }
    public ArrayList<Pet> getPets() {
        return pets;
    }

                                                                                              //setters
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }
    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    //additional methods
    public Owner() {
        pets = new ArrayList<>();
    }

    public boolean isFrequentClient() {
        return numberOfPets > 1;
    }

    @Override
    public String toString() {
        return "Owner{Id=" + ownerId + ", name= '" + name +
                "', phone=" + getPhone() +  ", number of pets=" + numberOfPets + "}";
    }

}
