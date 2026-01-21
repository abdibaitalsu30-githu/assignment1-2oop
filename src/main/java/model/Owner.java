package model;

import java.util.ArrayList;

public class Owner {
    private int ownerId;
    private String name;
    private int phone;
    private int numberOfPets;

    public Owner(int ownerId, String name, int phone, int numberOfPets) {                         //constructor
        setOwnerId(ownerId);
        setName(name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
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

    //setters
    public void setOwnerId(int ownerId) {
        if (ownerId < 100000 || ownerId > 999999) {
            throw new IllegalArgumentException("OwnerID must be 6 digits");
        }
        this.ownerId = ownerId;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("Owner name must be at least 2 characters");
        }
        this.name = name;
    }
    public void setPhone(int phone) {
        if (phone <= 0){
            throw new IllegalArgumentException("Owner phone must be positive");
        }
        this.phone = phone;
    }
    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets <= 0){
            throw new IllegalArgumentException("Owner number of pets must be positive");
        }
        this.numberOfPets = numberOfPets;
    }

    public boolean isFrequentClient() {
        return numberOfPets > 1;
    }

    public void displayInfo() {
        System.out.println("OwnerID: " + ownerId);
        System.out.println("Owner name: " + name);
        System.out.println("Owner phone: " + phone);
        System.out.println("Owner number of pets: " + numberOfPets);
    }

    @Override
    public String toString() {
        return "model.Owner{Id=" + ownerId + ", name= '" + name +
                "', phone=" + getPhone() +  ", number of pets=" + numberOfPets + "}";
    }

}
