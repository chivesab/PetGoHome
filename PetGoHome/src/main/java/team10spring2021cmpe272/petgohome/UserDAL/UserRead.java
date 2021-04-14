package team10spring2021cmpe272.petgohome.UserDAL;

import java.sql.PreparedStatement;
import team10spring2021cmpe272.petgohome.MySQLConnector.MySQLConnector;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRead {
    static PreparedStatement preparedStatement = null;

    public static ResultSet readUsersByUsernameAndHPass(String userName, String hPassword, MySQLConnector databaseConnector) {

        try {
            String readQueryStatement = ""; //TODO write query statement with "?" to be filled in

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

    public static ResultSet readUserCountByUsernameAndHPass(String userName, String hPassword, String phone, MySQLConnector databaseConnector) {
        try {
            // TO Do's SQL Query
            String readQueryStatement = ""; //TODO write query statement with "?" to be filled in

            preparedStatement = databaseConnector.team10spring2021cmpe272.prepareStatement(readQueryStatement);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, hPassword);
            preparedStatement.setString(3, phone);

            // Execute the Query, and get a java ResultSet
            ResultSet rs = preparedStatement.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
