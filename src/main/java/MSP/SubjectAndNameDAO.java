package MSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class SubjectAndNameDAO {
	 
	
	 
	
	    String databaseURL = "jdbc:mysql://localhost:3306/secondproject_db";
	    String user = "root";
	    String password = "pass";
	     
	    public List<SubjectAndName> list() throws SQLException {
	        List<SubjectAndName> listSC = new ArrayList<>();//array list of subject and classes
	         
	        try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
	            String sqlSubject = "SELECT * FROM subject ORDER BY sname";
	            String sqlClasses = "SELECT * FROM classes ORDER BY cname";

	            Statement statement = connection.createStatement();
	            ResultSet result1 = statement.executeQuery(sqlSubject);
	            ResultSet result2 = statement.executeQuery(sqlClasses);

	             
	            while (result1.next()||result2.next()) {
	                String subject = result1.getString("sname");
	                String classes = result2.getString("cname");
	                SubjectAndName sn = new SubjectAndName(subject, classes);
	                     
	                listSC.add(sn);
	            }          
	             
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw ex;
	        }      
	         
	        return listSC;
	    }
	
}
