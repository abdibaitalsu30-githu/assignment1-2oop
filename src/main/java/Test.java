import database.DatabaseConnection;
import database.TreatmentDAO;
import model.Checkup;
import  model.Vaccination;
import model.Treatment;

import java.util.List;
import java.sql.Connection;

public class Test {
    public void main() {
        Checkup testCheckup = new Checkup(8, "Dog", "01.02.34", "Canceled", 230.6, 6);
        TreatmentDAO treatmentDAO = new TreatmentDAO();
        treatmentDAO.insertCheckup(testCheckup);

        List<Checkup> checkups = treatmentDAO.getAllCheckups();
        for (Checkup checkup : checkups) {
            System.out.println(checkup);
        }
    }
}
