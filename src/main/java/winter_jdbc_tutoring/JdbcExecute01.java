package winter_jdbc_tutoring;

import java.sql.*;

public class JdbcExecute01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
		
		Statement st = con.createStatement();
		
		//Drop demo table
		String q1 = "DROP TABLE my_demo";
		boolean r1 = st.execute(q1);
		
		//Create demo table which has demo_id (number), demo_name (String)
		String q2 = "CREATE TABLE demo(demo_id NUMBER(2), demo_name VARCHAR2(20))";
		boolean r2 = st.execute(q2);
		
		//Add a new field into demo table
		String q4 = "ALTER TABLE demo ADD demo_address VARCHAR2(50)";
		boolean r4 = st.execute(q4);
		
		//Add demo_code and demo_price fields into demo table
		String q5 = "ALTER TABLE demo ADD (demo_code VARCHAR2(3), demo_price NUMBER(2))";
		boolean r5 = st.execute(q5);
		
		//Change the data type of demo_code field to CHAR(3)
		String q6 = "ALTER TABLE demo MODIFY demo_code CHAR(3)";
		boolean r6 = st.execute(q6);
		
		//Drop demo_price field from demo table
		String q7 = "ALTER TABLE demo DROP COLUMN demo_price";
		boolean r7 = st.execute(q7);
		
		//Rename demo_name field to name_of_demo
		String q8 = "ALTER TABLE demo RENAME COLUMN demo_name TO name_of_demo";
		boolean r8 = st.execute(q8);
		
		//Rename demo table to my_demo
		String q9 = "ALTER TABLE demo RENAME TO my_demo";
		boolean r9 = st.execute(q9);
		
		//Returns a boolean value of true if a ResultSet object can be retrieved; otherwise, it returns false. 
		System.out.println(r1 + " - " + r2 + " - " + r4 + " - " + r5 + " - " + r6 + " - " + r7 + " - " + r8 + " - " + r9 + " - ");
		
		con.close();
		st.close();
		
		//execute() method is used for DDL (Create, Drop, Alter)
		//Use this method to execute SQL DDL statements
		//execute() method can be used with "SELECT" statement as well but when you use execute() with "SELECT" statement
		//you will get just true or false, you cannot process data
			
	}

}