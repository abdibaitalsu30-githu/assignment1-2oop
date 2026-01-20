package model;

public class Vaccination extends Treatment {
    private String vaccineName;
    private double doseMl;

    public Vaccination(int treatmentId, int petid, String date, String status, double price, String vaccineName, double doseMl) {
        super(treatmentId, petid, date, status, price);
        setVaccineName(vaccineName);
        setDoseMl(doseMl);
    }

    public String getVaccineName() {
        return vaccineName;
    }
    public String getDoseMl() {
        return doseMl + "ml";
    }

    public void setVaccineName(String vaccineName) {
        if (vaccineName== null || vaccineName.trim().isEmpty()) {
            throw new IllegalArgumentException("Vaccine name cannot be empty");
        }
        if (vaccineName.length() < 3) {
            throw new IllegalArgumentException("Vaccine name must be at least 3 characters");
        }
        this.vaccineName = vaccineName;
    }
    public void setDoseMl (double doseMl) {
        if (doseMl < 0.0) {
            throw new IllegalArgumentException("Dose cannot be negative ml");
        }
        if (doseMl == 0.0) {
            throw new IllegalArgumentException("Dose cannot be zero ml");
        }
        this.doseMl = doseMl;
    }
    @Override
    public void Price() {
        System.out.println("Total price is " + getPrice() + " for this " + vaccineName + " vaccine.");
    }

    @Override
    public String getAppointment() {
        return "Vaccination";
    }

    public void Status(String status) {
        System.out.println("Vaccination is " + status + " with dose: " + getDoseMl());
    }
    public boolean isForBigAnimal() {
        return doseMl >= 5.0;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Appointment: Vaccination");
        System.out.println("Vaccine name: " + vaccineName);
        System.out.println("Dose: " + getDoseMl());
        if (isForBigAnimal()) {
            System.out.println("Big animal");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Vaccine name: " + vaccineName + " | Dose: " + getDoseMl();
    }
}
