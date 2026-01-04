public class Vaccination extends Treatment{
    private String vaccineName;
    private double doseMl;

    public Vaccination(int treatmentId, int petID, String date, String status, double price, String vaccineName, double doseMl) {
        super(treatmentId, petID, date, status, price);
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
        if (vaccineName != null && !vaccineName.trim().isEmpty()) {
            this.vaccineName = vaccineName;
        } else {
            System.out.println("Warning: Choose vaccine.");
        }
    }
    public void setDoseMl (double doseMl) {
        if (doseMl > 0.0) {
            this.doseMl = doseMl;
        } else {
            System.out.println("Warning: Dose cannot be negative. Setting it to zero");
            this.doseMl = doseMl;
        }
    }
    @Override
    public void Price() {
        System.out.println("Total price is " + getPrice() + " for this " + vaccineName + " vaccine.");
    }
    @Override
    public String getTreatment() {
        return "Vaccination";
    }

    public void Status(String status) {
        System.out.println("Vaccination is " + status + " with dose: " + getDoseMl());
    }
    public boolean isForBigAnimal() {
        return doseMl >= 5.0;
    }

    @Override
    public String toString() {
        return super.toString() + " | Vaccine name: " + vaccineName + " | Dose: " + getDoseMl();
    }
}
