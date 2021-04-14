package team10spring2021cmpe272.petgohome.UserDAL;

import java.sql.PreparedStatement;
import team10spring2021cmpe272.petgohome.MySQLConnector.MySQLConnector;
import java.sql.SQLException;

public class UserCreate {
    public static PreparedStatement preparedStatement = null;

    public static int createUser(String userName, String hPassword, String phone, MySQLConnector databaseConnector) {

        try {
            // MySQL Select Query Tutorial
            String createQueryStatement = "SELECT username, hash_password, phone FROM Users WHERE username = ? AND hash_password" +
                    " = ? AND phone = ?"; //TODO write query statement with "?" to be filled in

            preparedStatement = databaseConnector.team10spring2021cmpe272.prepareStatement(createQueryStatement);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, hPassword);
            preparedStatement.setString(3, phone);

            // Execute the Query, and get a java ResultSet
            preparedStatement.executeUpdate();

            return 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }

    }
}
