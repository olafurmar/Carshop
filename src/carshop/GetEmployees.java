package carshop;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class GetEmployees extends RequestHandler{

	@Override
	public Object handleGetRequest() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "SELECT id, name FROM employees";
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				list.add(new Employee(id, name));

			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return list;
	}

	@Override
	public Object handlePostRequest(String s) {
		// TODO Auto-generated method stub
		return null;
	}


}
