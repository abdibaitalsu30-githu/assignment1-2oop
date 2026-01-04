public class Treatment {
    protected int treatmentId;
    protected int petID;
    protected String date;
    protected String status;
    protected double price;


    public Treatment(int treatmentId, int petID, String date, String status, double price) {
        setTreatmentId(treatmentId);
        setPetID(petID);
        setDate(date);
        this.status = status;
        setPrice(price);
    }

    public int getTreatmentId() {
        return treatmentId;
    }
    public int gerPetID() {
        return petID;
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
        if (treatmentId >= 100000) {
            this.treatmentId = treatmentId;
        }
        else {
            System.out.println("Warning: Id cannot be less than 6 digit! Setting to 0.");
            this.treatmentId = 0;
        }
    }
    public void setPetID(int petID) {
        if (petID >= 100000) {
            this.petID = petID;
        }
        else {
            System.out.println("Warning: Id cannot be less than 6 digit! Setting to 0.");
            this.petID = 0;
        }
    }
    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()){
            this.date = date;
        } else {
            System.out.println("Warning: Choose the treatment date.");
        }
    }
    public void setStatus(String Status) {
        this.status = status;
    }
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Warning: Price cannot be negative! Setting to 0.");
            this.price = 0;
        }
    }

    public void Price() {
        System.out.println("Total price for treatment is " + getPrice());
    }
    public String getTreatment() {
        return "Treatment";
    }

    public boolean IsCompleted() {
        if (status.equals("Scheduled")) {
            return false;
        } else {
            return true;
        }
    }
    public boolean isExpensive() {
        return price > 200;
    }

    @Override
    public String toString() {
        return "[" + getTreatment() + "]" + " (treatmentId: " + treatmentId + ", petID: " + petID + ", date: '" + date +
                "', status: '" + status +  "', price: " + getPrice() + ")";
    }
}
