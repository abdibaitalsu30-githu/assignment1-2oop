import database.DatabaseConnection;
import database.TreatmentDAO;
import menu.Menu;
import menu.VetclinicMenu;
import model.Vaccination;
import model.Treatment;

import javax.xml.crypto.Data;
import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreatmentDAO treatmentDAO = new TreatmentDAO();
        List<Treatment> treatmentList = treatmentDAO.getAllTreatment();
        for (Treatment treatment : treatmentList) {
            System.out.println(treatment);
        }
        Menu menu = new VetclinicMenu();
        menu.run();
    }

}
