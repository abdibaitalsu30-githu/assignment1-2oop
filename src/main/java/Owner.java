import java.util.ArrayList;

public class Owner {
    private int ownerId;
    private String name;
    private int phone;
    private int numberOfPets;
    private ArrayList<Pet> pets;
    private ArrayList<Owner> owners;

    public Owner(int ownerId, String name, int phone, int numberOfPets) {                         //constructor
        setOwnerId(ownerId);
        setName(name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
        this.pets = new ArrayList<>();
        this.owners = new ArrayList<>();
    }

    //getters
    public int getOwnerId() { return ownerId; }
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
    public ArrayList<Owner> getOwners() {
        return owners;
    }

    //setters
    public void setOwnerId(int ownerId) {
        if (ownerId >= 100000) {
            this.ownerId = ownerId;
        }
        else {
            System.out.println("Warning: Id cannot be less than 6 digit! Setting to 0.");
            this.ownerId = 0;
        }
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }
    public void setPhone(int phone) {
        if (phone >= 0) {
            this.phone = phone;
        }
        else if (phone >= 9999999){
            System.out.println("Warning: Phone cannot be more than 7 digits. Setting to 0!");
            this.phone = 0;
        } else {
            System.out.println("Warning: Phone cannot be less than 7 digits. Setting to 0!");
            this.phone = 0;
        }
    }
    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets >= 0) {
            this.numberOfPets = numberOfPets;
        }
        else {
            System.out.println("Warning: Number of pers cannot be negative! Setting to 0.");
            this.numberOfPets = 0;
        }
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

    public void addOwner(Owner owner) {
        if (owner != null) {
            owners.add(owner);
        }
    }
    @Override
    public String toString() {
        return "Owner{Id=" + ownerId + ", name= '" + name +
                "', phone=" + getPhone() +  ", number of pets=" + numberOfPets + "}";
    }

}
