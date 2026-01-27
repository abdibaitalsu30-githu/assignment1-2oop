package database;

import model.Treatment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TreatmentDAO {
    public void insertTreatment(Treatment treatment) {
        String sql = "INSERT INTO treatment (treatmentId, petid, date, status, price) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, treatment.getTreatmentId());
            statement.setInt(2, treatment.getPetid());
            statement.setString(3, treatment.getDate());
            statement.setString(4, treatment.getStatus());
            statement.setDouble(5, treatment.getPrice());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Staff inserted successfully!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllTreatment() {
        String sql = "SELECT * FROM treatment";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- ALL TREATMENT FROM DATABASE ---");
            while (resultSet.next()) { //move to next row
                int treatmentId = resultSet.getInt("treatment_id"); //get column value
                int petid = resultSet.getInt("pet_id");
                String date = resultSet.getString("date");
                String status = resultSet.getString("status");
                double price = resultSet.getDouble("price");

                System.out.println("model.Treatment ID: " + treatmentId);
                System.out.println("PetID: " + petid);
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
    }
}
