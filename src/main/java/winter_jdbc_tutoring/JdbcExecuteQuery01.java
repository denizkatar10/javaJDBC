package winter_jdbc_tutoring;

//1.Step Import the sql package
import java.sql.*;

public class JdbcExecuteQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//2.Step: Register to the oracle driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//3.Step: Establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","hr");
		
		//4.Step: Create a statement
		Statement st = con.createStatement();
		
		//5.Step: Execute query and store the result
		boolean re = st.execute("SELECT * FROM countries");
		System.out.println(re);
		//6.Step: Process the result
//		while(re.next()) {
//			System.out.println(re.getString(1) + " - " + re.getString(2) + " - " + re.getInt(3));
//		}
		
		//7.Step: Close connection, statement, ResultSet
		con.close();
		st.close();
//		re.close();
		
	}

}
