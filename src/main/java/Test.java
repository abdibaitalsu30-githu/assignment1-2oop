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
/*public void getAllTreatment() {
        String sql = "SELECT * FROM treatment";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- ALL TREATMENT FROM DATABASE ---");
            while (resultSet.next()) { //move to next row
                int treatmentId = resultSet.getInt("treatment_id"); //get column value
                String patientName = resultSet.getString("patient_name");
                String date = resultSet.getString("date");
                String status = resultSet.getString("status");
                double price = resultSet.getDouble("price");

                System.out.println("Treatment ID: " + treatmentId);
                System.out.println("PatientName: " + patientName);
                System.out.println("Date: " + date);
                System.out.println("Status: " + status);
                System.out.println("Price: " + price);
                System.out.println("---");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }*/

