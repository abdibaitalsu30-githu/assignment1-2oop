package model;

public class Checkup extends Treatment {
    private int conditionScore;

    public Checkup(int treatmentId, int petid, String date, String status, double price, int conditionScore) {
        super(treatmentId, petid, date, status, price);
        setConditionScore(conditionScore);
    }

    public int getConditionScore() {
        return conditionScore;
    }
    public void setConditionScore(int conditionScore) {
        if(this.conditionScore < 0 || this.conditionScore > 11) {
            throw new IllegalArgumentException("Condition score must be between 0 and 10");
        }
        this.conditionScore = this.conditionScore;
    }

    @Override
    public void Price() {
        System.out.println("Total price is $" + price + " for this checkup.");
    }
    @Override
    public String getAppointment() {
        return "Checkup";
    }

    public void Condition(int conditionScore) {
        System.out.println("After checkup " + petid + " is on " + conditionScore + " condition");
    }
    public boolean isSick() {
        return conditionScore < 4;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Appointment: Checkup");
        System.out.println("Condition score: " + conditionScore);
        if (isSick()) {
            System.out.println("Pet is sick.");
        }

    }
    @Override
    public String toString() {
        return super.toString() + " | Condition score: " + conditionScore;
    }
}
