package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {

    /*
   #########################################################################
   Method Name: openConnection
   Method Description: This Method open connect session to db
   #########################################################################
   */
    public static void openConnection(String dbURL, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting DB, See Details: " + e);
        }
    }

    /*
   #########################################################################
   Method Name: cloeConnection
   Method Description: This Method close connection session to db
   #########################################################################
   */
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred while Closing DB, See Details: " + e);
        }
    }

}
