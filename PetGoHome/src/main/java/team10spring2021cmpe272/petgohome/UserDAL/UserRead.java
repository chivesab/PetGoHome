package team10spring2021cmpe272.petgohome.UserDAL;

import java.sql.PreparedStatement;
import team10spring2021cmpe272.petgohome.MySQLConnector.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRead {
    static PreparedStatement preparedStatement = null;

    public static ResultSet readUsersByUsernameAndHPass(String userName, String hPassword, MySQLConnector databaseConnector) {

        try {
            String readQueryStatement = "SELECT username, hash_password, phone FROM USERS WHERE username = ? AND hash_password = ?";

            preparedStatement = databaseConnector.team10spring2021cmpe272.prepareStatement(readQueryStatement);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, hPassword);

            // Execute the Query, and get a java ResultSet
            ResultSet rs = preparedStatement.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
