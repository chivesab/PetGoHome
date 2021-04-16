package team10spring2021cmpe272.petgohome.Backend;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import team10spring2021cmpe272.petgohome.MySQLConnector.MySQLConnector;
import team10spring2021cmpe272.petgohome.BackEndUtilities.PasswordHasher;
import team10spring2021cmpe272.petgohome.BackEndUtilities.ResultSetConvertor;
import team10spring2021cmpe272.petgohome.UserDAL.UserRead;
import team10spring2021cmpe272.petgohome.UserDAL.UserCreate;

@RestController
public class BackendController {

    /*
     * userReqBody
     *
     * userName : String
     * userPassword : String
     *
     * returns: List containing the session key for the current session
     */
    @PostMapping("/users/login")
    public ResponseEntity<List<User>> validateAccount(@RequestBody User userReqBody) throws Exception {
        // I use the simplest way to validate account, which is by user name
        MySQLConnector myConnector = new MySQLConnector();
        myConnector.makeJDBCConnection();

        ResultSet resultSet = UserRead.readUsersByUsernameAndHPass(userReqBody.getUserName(), userReqBody.getUserHashedPassword(), myConnector);
        List<User> userList = ResultSetConvertor.convertToUserList(resultSet);
        myConnector.closeJDBCConnection();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    /*
     * userReqBody
     *
     * userPassword : String
     * userName : String
     * roleType : String (valid values: "admin" or "user")
     */
    @PostMapping("/users/create")
    public ResponseEntity<List<String>> createUser(@RequestBody User userReqBody) throws Exception {
        //TO DO's - hasn't done isValid() function
        //check to see if there already exists a user with that username
        //if already exists: return an error.
        //else: send user information to UserDAL for account creation

        //get mysql connection
        MySQLConnector myConnector = new MySQLConnector();
        myConnector.makeJDBCConnection();

        // check if user exists or not
        ResultSet resultSet = UserRead.readUsersByUsernameAndHPass(userReqBody.getUserName(), userReqBody.getUserHashedPassword(), myConnector);
        List<User> userList = ResultSetConvertor.convertToUserList(resultSet);
        boolean empty = userList.isEmpty();
        if (empty == true){  // user doesn't exist
            UserCreate.createUser(userReqBody.getUserName(), userReqBody.getUserHashedPassword(), userReqBody.getphone(), myConnector);
            // close mysql connection
            myConnector.closeJDBCConnection();
            return null;
        }
        else{
            // close mysql connection
            myConnector.closeJDBCConnection();
            throw new Exception(userReqBody.getUserName() + " already exists");
        }
    }
}


