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

@RestController
public class BackendController {
    private boolean isValid(String uuidAsString, String accountName) {
        //this.cleanSessionKeys(); // remove all old session keys (optional)
        //TODO: send information to SessionKeyManager to validate the key
        return false;
    }

    /*
     * userReqBody
     *
     * userName : String
     * userPassword : String
     *
     * returns: List containing the session key for the current session
     */
    @PostMapping("/users/login")
    public ResponseEntity<List<String>> validateAccount(@RequestBody User userReqBody) throws Exception {

        MySQLConnector myConnector = new MySQLConnector();
        myConnector.makeJDBCConnection();

        String keyOwner = userReqBody.getUserName();
        //TODO: send the above field to SessionKeyManager to create the session key entry in database
        //retrieve the the session key via SessionKeyManager and send it back in the response message body
        myConnector.closeJDBCConnection();
        return new ResponseEntity<List<String>>(new LinkedList<String>(Arrays.asList(/*TODO*/"session key here")), HttpStatus.OK)
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
        //TODO:

        //check to see if there already exists a user with that username
        //if already exists: return an error.
        //else: send user information to UserDAL for account creation

        return null;
    }
}


