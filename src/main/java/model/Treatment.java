package model;

public abstract class Treatment {
    protected int treatmentId;
    protected String patientName;
    protected String date;
    protected String status;
    protected double price;


    public Treatment(int treatmentId, String patientName, String date, String status, double price) {
        setTreatmentId(treatmentId);
        setPatientName(patientName);
        setDate(date);
        setStatus(status);
        setPrice(price);
    }

    public int getTreatmentId() {
        return treatmentId;
    }
    public String getPatientName() {
        return patientName;
    }
    public String getDate() {
        return date;
    }
    public String getStatus() {
        return status;
    }
    public double getPrice() {
        return price;
    }

    public void setTreatmentId(int treatmentId) {
        if (treatmentId < 0) {
            throw new IllegalArgumentException("TreatmentID must be positive");
        }
        this.treatmentId = treatmentId;
    }
    public void setPatientName(String patientName) {
        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be empty");
        }
        if (patientName.length() < 2) {
            throw new IllegalArgumentException("Pet name must be at least 2 characters");
        }
        this.patientName = patientName;
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
        System.out.println("Treatment ID: " + treatmentId);
        System.out.println("Patient name: " + patientName);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
        System.out.println("Price: $" + price);
    }

    public boolean isExpensive() {
        return price > 200;
    }

    public abstract void Price();
    public abstract String getAppointment();

    @Override
    public String toString() {
        return "[" + getAppointment() + "]" + " (treatmentId: " + treatmentId + ", Patient name: " + patientName + ", date: '" + date +
                "', status: '" + status +  "', price:$ " + price + ")";
    }
}
