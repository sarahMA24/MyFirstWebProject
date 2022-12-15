package MSP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/training_kfh";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";

	static private Connection dbCon;

	private static String qry;

	private static Statement theStatement;

	private static ResultSet resultSet;
	static void addTeacherToClass() throws SQLException {
//		qry = "insert into developer values('" + id + "', '" + name + "', '" + skills + "')";
		//qry = String.format("insert into developer values(%d,'%s', '%s')", id, name, skills);
		
		System.out.println(qry);
		
//		Execute the query
		if(theStatement.executeUpdate(qry) > 0)
			System.out.println("New Class added to teacher...");
	}
	public static void main(String[] args) {


}}





