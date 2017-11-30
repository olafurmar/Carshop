package carshop;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GetCarmodels extends RequestHandler{

	@Override
	public Object handleGetRequest() {
		ArrayList<Carmodel> list = new ArrayList<Carmodel>();
		try {
			String sql = "SELECT id, brand, model, price FROM carmodels";
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			

			while (rs.next()) {
				int id = rs.getInt("id");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				int price = rs.getInt("price");
				
				list.add(new Carmodel(brand, model,price, id));


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
