package winter_jdbc_tutoring;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcExecuteUpdate01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
		
		Statement st = con.createStatement();
		
		//Insert a single data into my_demo table
		
		String q1 = "INSERT INTO my_demo VALUES (11, 'DEN', 'NEW JERSEY', 'ABC')";
		int r1 = st.executeUpdate(q1);
		System.out.println(r1 + " row inserted");
		
		/*
			How to insert multiple records into my_demo table by using JDBC
			1) Create a POJO(Plain Old Java Object) Class
			2) Create a list of POJO Class objects
			3) By using loops add the objects into the table
		
		*/
		
		String q2 = "INSERT INTO my_demo VALUES (?, ?, ?, ?)";
		//If you plan use a query many times create PreparedStatement object and use query inside the parenthesis
		PreparedStatement pst = con.prepareStatement(q2);
		
		
		List<MyDemo> records = new ArrayList<>();
		records.add(new MyDemo(12, "Second demo", "Virginia", "BCD"));
		records.add(new MyDemo(13, "Third demo", "Istanbul", "CDE"));
		records.add(new MyDemo(14, "Fourth demo", "Kars", "DEF"));
		records.add(new MyDemo(15, "Fifth demo", "Jacksonville", "EFG"));
		records.add(new MyDemo(16, "Sixth demo", "Tallahasse", "FGH"));
		
		for(MyDemo w : records) {
			pst.setInt(1, w.getDemo_id());
			pst.setString(2, w.getName_of_demo());
			pst.setString(3, w.getDemo_address());
			pst.setString(4, w.getDemo_code());
			pst.addBatch();
		}
		
		int arr[] = pst.executeBatch();
		
		System.out.println(arr.length + " rows inserted");
		
		
		//Update the demo_code whose demo_id is less than 14 to 'XXX'
		String q3 = "UPDATE my_demo SET demo_code = 'XXX' WHERE demo_id < 14";
		int r3 = st.executeUpdate(q3);
		System.out.println(r3 + " rows updated");
		
		
		
		
		
		con.close();
		st.close();

	}

}
