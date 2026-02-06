package database;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatmentDAO {
    public void insertTreatment(Treatment treatment) {
        String sql = "INSERT INTO treatment (patient_name, date, status, price) VALUES (?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, treatment.getPatientName());
            statement.setString(2, treatment.getDate());
            statement.setString(3, treatment.getStatus());
            statement.setDouble(4, treatment.getPrice());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Treatment inserted successfully!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public boolean insertVaccination(Vaccination vaccination) {
        String sql = "INSERT INTO treatment1 (patient_name, date, status, price, treatment_type, vaccineName, dose, conditionScore) " +
                "VALUES(?, ?, ?, ?, 'VACCINATION', ?, ?, NULL)";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vaccination.getPatientName());
            statement.setString(2, vaccination.getDate());
            statement.setString(3, vaccination.getStatus());
            statement.setDouble(4, vaccination.getPrice());
            statement.setString(5, vaccination.getVaccineName());
            statement.setDouble(6, vaccination.getDoseMl());
            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("Vaccination inserted: " + vaccination.getPatientName());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean insertCheckup (Checkup checkup) {
        String sql = "INSERT INTO treatment1 (pet_id, date, status, price, treatment_type, vaccineName, dose, conditionScore) "
                + "VALUES(?, ?, ?, ?, 'CHECKUP', NULL, NULL, ?)";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, checkup.getPatientName());
            statement.setString(2, checkup.getDate());
            statement.setString(3, checkup.getStatus());
            statement.setDouble(4, checkup.getPrice());
            statement.setInt(5, checkup.getConditionScore());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("Checkup inserted: " + checkup.getPatientName());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Insert checkup failed!");
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

        public List<Treatment> getAllTreatment() {
        List<Treatment> treatmentList = new ArrayList<>();
        String sql = "SELECT * FROM treatment1 ORDER BY treatment_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return treatmentList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Treatment treatment = extractTreatmentFromResultSet(resultSet);
                if (treatment != null) {
                    treatmentList.add(treatment);
                }
            }
            resultSet.close();
            statement.close();

            System.out.println("Retrieved " + treatmentList.size() + " treatment from database");
        } catch (SQLException e) {
            System.out.println("Select all treatment failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return treatmentList;
    }

    public Treatment getTreatmentById(int treatmentId) {
        String sql = "SELECT * FROM treatment1 WHERE treatment_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, treatmentId);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                Treatment treatment = extractTreatmentFromResultSet(resultSet);
                resultSet.close();
                statement.close();

                if (treatment != null) {
                    System.out.println("Found treatment with ID: " + treatmentId);
                }

                return treatment;
            }
            System.out.println("No treatment found with ID: " + treatmentId);

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return null;
    }

    public List<Vaccination> getAllVaccinations() {
        List<Vaccination> vaccinations = new ArrayList<>();
        String sql = "SELECT * FROM treatment1 WHERE treatment_type = 'VACCINATION' ORDER BY treatment_id";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return vaccinations;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Treatment treatment = extractTreatmentFromResultSet(resultSet);
                if (treatment instanceof Vaccination) {
                    vaccinations.add((Vaccination) treatment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Retrieved: " + vaccinations.size() + "vaccinations");
        } catch (SQLException e) {
            System.out.println("Select vaccinations failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return vaccinations;
    }

    public List<Checkup> getAllCheckups() {
        List<Checkup> checkups = new ArrayList<>();
        String sql = "SELECT * FROM treatment1 WHERE treatment_type = 'CHECKUP' ORDER BY treatment_id";
        Connection connection = DatabaseConnection.getConnection();
        if(connection == null) return checkups;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Treatment treatment = extractTreatmentFromResultSet(resultSet);
                if(treatment instanceof Checkup) {
                    checkups.add((Checkup) treatment);
                }
            }
            resultSet.close();
            statement.close();

            System.out.println("Retrieved: " + checkups.size() + " checkups");
        } catch (SQLException e) {
            System.out.println("Select checkups failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return checkups;
    }

    public boolean updateVaccination(Vaccination vaccination) {
        String sql = "UPDATE treatment1 SET patient_name = ?, date = ?, status = ?, price = ?, vaccineName = ?, dose = ? " +
                "WHERE treatment_id = ? and treatment_type = 'VACCINATION'";
        Connection connection = DatabaseConnection.getConnection();
        if(connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vaccination.getPatientName());
            statement.setString(2, vaccination.getDate());
            statement.setString(3, vaccination.getStatus());
            statement.setDouble(4, vaccination.getPrice());
            statement.setString(5, vaccination.getVaccineName());
            statement.setDouble(6, vaccination.getDoseMl());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Vaccination updated for: " + vaccination.getPatientName());
                return true;
            } else {
                System.out.println("No vaccination found with ID: " + vaccination.getTreatmentId());
            }
        } catch (SQLException e) {
            System.out.println("Update Vaccination failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public boolean updateCheckup(Checkup checkup) {
            String sql = "UPDATE treatment1 SET patient_name = ?, date = ?, status = ?, price = ?, conditionScore = ?" +
                    "WHERE treatment_num = ? AND treatment_type = 'CHECKUP'";
            Connection connection = DatabaseConnection.getConnection();
            if (connection == null) return false;

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, checkup.getPatientName());
                statement.setString(3, checkup.getDate());
                statement.setString(4, checkup.getStatus());
                statement.setDouble(5, checkup.getPrice());
                statement.setInt(6, checkup.getConditionScore());

                int rowsUpdated = statement.executeUpdate();
                statement.close();

                if (rowsUpdated > 0) {
                    System.out.println("Checkup updated for " + checkup.getPatientName());
                    return true;
                } else {
                    System.out.println("No checkup found with ID: " + checkup.getTreatmentId());
                }
            } catch (SQLException e) {
                System.out.println("Update checkup failed");
                e.printStackTrace();
            } finally {
                DatabaseConnection.closeConnection(connection);
            }
            return false;
    }

    public boolean deleteTreatment(int treatmentId) {
            String sql = "DELETE FROM treatment1 WHERE treatment_id = ?";

            Connection connection = DatabaseConnection.getConnection();
            if (connection == null) return false;

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, treatmentId);

                int rowsDeleted = statement.executeUpdate();
                statement.close();

                if (rowsDeleted > 0) {
                    System.out.println("Treatment deleted (ID: " + treatmentId + ")");
                    return true;
                } else {
                    System.out.println("No treatment found with ID: " + treatmentId);
                }
            } catch (SQLException e) {
                System.out.println("Delete treatment failed!");
                e.printStackTrace();
            } finally {
                DatabaseConnection.closeConnection(connection);
            }
            return false;
    }

    public List<Treatment> searchByPatientName(String patientName) {
            List<Treatment> treatmentList = new ArrayList<>();

            String sql = "SELECT * FROM treatment1 WHERE patient_name ILIKE ? ORDER BY patient_name";
            Connection connection = DatabaseConnection.getConnection();
            if (connection == null) return treatmentList;

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + patientName + "%"); //wildcard -

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Treatment treatment = extractTreatmentFromResultSet(resultSet);
                    if (treatment != null) {
                        treatmentList.add(treatment);
                    }
                }

                resultSet.close();
                statement.close();

                System.out.println("Found " + treatmentList.size() + " treatment matching '" + patientName + "'");
            } catch (SQLException e) {
                System.out.println("Search by name failed!");
                e.printStackTrace();
            } finally {
                DatabaseConnection.closeConnection(connection);
            }
            return treatmentList;
    }

    public List<Treatment> searchByPriceRange(double minPrice, double maxPrice) {
            List<Treatment> treatmentList = new ArrayList<>();
            String sql = "SELECT * FROM treatment1 WHERE price BETWEEN ? AND ? ORDER BY ? DESK";
            Connection connection = DatabaseConnection.getConnection();
            if (connection == null) return treatmentList;

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setDouble(1, minPrice);
                statement.setDouble(2, maxPrice);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Treatment treatment = extractTreatmentFromResultSet(resultSet);
                    if (treatment != null) {
                        treatmentList.add(treatment);
                    }
                }

                resultSet.close();
                statement.close();

                System.out.println("Found " + treatmentList.size() + " treatment in price range " + minPrice + " - " + maxPrice);
            } catch (SQLException e) {
                System.out.println("Search by price range failed!");
            } finally {
                DatabaseConnection.closeConnection(connection);
            }
            return treatmentList;
    }

    public List<Treatment> searchByMinPrice(double minPrice) {
        List<Treatment> treatmentList = new ArrayList<>();
        String sql = "SELECT * FROM treatment1 WHERE price >= ? ORDER BY price DESK";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return treatmentList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Treatment treatment = extractTreatmentFromResultSet(resultSet);
                if (treatment != null) {
                    treatmentList.add(treatment);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("Found " + treatmentList.size() + " treatment pricing >= " + minPrice);
        } catch (SQLException e) {
            System.out.println("Search by minPrice failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return treatmentList;
    }

    private Treatment extractTreatmentFromResultSet(ResultSet resultSet) throws SQLException {
            int treatmentId = resultSet.getInt("treatment_id");
            String patientName = resultSet.getString("patient_name");
            String date = resultSet.getString("date");
            String status = resultSet.getString("status");
            double price = resultSet.getDouble("price");
            String treatmentType = resultSet.getString("treatment_type");

            Treatment treatment = null;

            if("VACCINATION".equals(treatmentType)) {
                String vaccineName = resultSet.getString("vaccine_name");
                double dose = resultSet.getDouble("dose");
                treatment = new Vaccination(treatmentId, patientName, date, status, price, vaccineName, dose);
            } else if("CHECKUP".equals(treatmentType)) {
                int conditionScore = resultSet.getInt("condition_score");
                treatment = new Checkup(treatmentId, patientName, date, status, price, conditionScore);
            }

            return treatment;
    }

    public void displayAllTreatment() {
            List<Treatment> treatmentList = getAllTreatment();

            System.out.println("\n========================================");
            System.out.println("   ALL TREATMENT FROM DATABASE");
            System.out.println("========================================");

            if(treatmentList.isEmpty()) {
                System.out.println("No treatments in database.");
            } else {
                for(int i = 0; i < treatmentList.size(); i++) {
                    Treatment t = treatmentList.get(i);
                    System.out.print((i + 1) + ". ");
                    System.out.print("[" + t.getAppointment() + "]");
                    System.out.println(t.toString());
                }
            }
            System.out.println("========================================\n");
    }

    public void demonstratePolymorphism() {
            List<Treatment> treatmentList = getAllTreatment();

            System.out.println("\n========================================");
            System.out.println("  POLYMORPHISM: Treatment from Database");
            System.out.println("========================================");

            if(treatmentList.isEmpty()) {
                System.out.println("No treatment to demonstrate");
            } else {
                for (Treatment t : treatmentList) {
                    t.Price();
                }
            }
            System.out.println("========================================\n");
    }
}
