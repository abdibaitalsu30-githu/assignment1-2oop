public class Checkup extends Treatment{
    private int conditionScore;

    public Checkup(int treatmentId, int petID, String date, String status, double price, int conditionScore) {
        super(treatmentId, petID, date, status, price);
        setConditionScore(conditionScore);
    }

    public int getConditionScore() {
        return conditionScore;
    }
    public void setConditionScore(int conditionScore) {
        if(this.conditionScore > 0 && this.conditionScore < 10) {
            this.conditionScore = this.conditionScore;
        }
        else {
            System.out.println("Warning: Condition score must be between 1 and 9!");
        }
    }

    @Override
    public void Price() {
        System.out.println("Total price is " + getPrice() + " for this checkup.");
    }
    @Override
    public String getTreatment() {
        return "Checkup";
    }

    public void Condition(int conditionScore) {
        System.out.println("After checkup " + petID + " is on " + conditionScore + " condition");
    }
    public boolean isSick() {
        return conditionScore < 4;
    }

    @Override
    public String toString() {
        return super.toString() + " | Condition score: " + conditionScore;
    }
}
