package model;

public abstract class Treatment {
    protected int treatmentId;
    protected int petid;
    protected String date;
    protected String status;
    protected double price;


    public Treatment(int treatmentId, int petid, String date, String status, double price) {
        setTreatmentId(treatmentId);
        setPetid(petid);
        setDate(date);
        setStatus(status);
        setPrice(price);
    }

    public int getTreatmentId() {
        return treatmentId;
    }
    public int getPetID() {
        return petid;
    }
    public String getDate() {
        return date;
    }
    public String getStatus() {
        return status;
    }
    public String getPrice() {
        return "$" + price;
    }

    public void setTreatmentId(int treatmentId) {
        if (treatmentId < 100000 || treatmentId > 999999) {
            throw new IllegalArgumentException("TreatmentID must be 6 digits");
        }
        this.treatmentId = treatmentId;
    }
    public void setPetid(int petid) {
        if (petid < 100000 || petid > 999999) {
            throw new IllegalArgumentException("PetID must be 6 digits");
        }
        this.petid = petid;
    }
    public void setDate(String date) {
        if (date == null || date.trim().isEmpty()){
            throw new IllegalArgumentException("Date cannot be empty");
        }
        if (date.length() < 3) {
            throw new IllegalArgumentException("Date must be at least 3 characters");
        }
        this.date = date;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status cannot be empty ");
        }
        if (status.length() < 5) {
            throw new IllegalArgumentException("Status must be at least 3 characters");
        }
        this.status = status;
    }
    public void setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (price == 0.0) {
            throw new IllegalArgumentException("Price cannot be zero");
        }
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("model.Treatment ID: " + treatmentId);
        System.out.println("PetID: " + petid);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
        System.out.println("Price: " + getPrice());
    }

    public boolean isExpensive() {
        return price > 200;
    }

    public abstract void Price();
    public abstract String getAppointment();

    @Override
    public String toString() {
        return "[" + getAppointment() + "]" + " (treatmentId: " + treatmentId + ", petID: " + petid + ", date: '" + date +
                "', status: '" + status +  "', price: " + getPrice() + ")";
    }
}
