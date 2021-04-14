package team10spring2021cmpe272.petgohome.BackEndUtilities;

import org.json.JSONArray;
import org.json.JSONObject;
import team10spring2021cmpe272.petgohome.Backend.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class ResultSetConvertor {

    /**
     * Converts a mysql query result set to a JSONArray
     * @param type is ResultSet
     * @return JSONArray conversion of the result set
     */
    public static JSONArray convertToJSON(ResultSet resultSet)
            throws Exception {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            for (int i = 0; i < total_rows; i++) {
                JSONObject obj = new JSONObject();
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1)
                        .toLowerCase(), resultSet.getObject(i + 1));
                jsonArray.put(obj);
            }
        }
        return jsonArray;
    }

    /**
     * Converts a mysql query result set to a list of Identity
     * @param ResultSet of Identity
     * @return List<Identity> conversion of ResultSet
     */
    public static List<User> convertToUserList(ResultSet resultSet) throws SQLException {
        List<User> ll = new LinkedList<User>();

        while (resultSet.next()) {
            String userName = resultSet.getString("Username");
            String userPassword = resultSet.getString("Hashed_Password");

            User acc = new User(userName, userPassword);

            ll.add(acc);
        }

        return ll;
    }
}
