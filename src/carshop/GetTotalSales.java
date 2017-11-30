package carshop;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


public class GetTotalSales extends RequestHandler{

	@Override
	public Object handleGetRequest() {
		ArrayList<EmployeeSales> list = new ArrayList<EmployeeSales>();
		try {
			String sql = "SELECT id, name FROM employees";
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				list.add(new EmployeeSales(id, name));
			}
			conn.close();
			
			rs.close();
			
			sql = "SELECT employee, carmodel FROM sales";
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int employee = rs.getInt("employee");
				int carmodel = rs.getInt("carmodel");
				

				
				conn = DriverManager.getConnection(url);
				
				
				PreparedStatement prepstmnt = conn.prepareStatement("SELECT price FROM carmodels WHERE id = ?");
				prepstmnt.setInt(1, carmodel);	
				ResultSet rs2 = prepstmnt.executeQuery();
				while (rs2.next()) {
					int price = rs2.getInt("price");
					Iterator itr = list.iterator();
					while(itr.hasNext()) {
						EmployeeSales emp = (EmployeeSales) itr.next();
						if(emp.getId() == employee) {
							emp.addSale(price);
							break;
						}
					}
				}
				
				
			}
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
