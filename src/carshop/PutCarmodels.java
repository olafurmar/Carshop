package carshop;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class PutCarmodels extends RequestHandler{

	@Override
	public Object handleGetRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlePostRequest(String s) {
		ArrayList<Carmodel> list = new ArrayList<Carmodel>();
		try {
			JSONObject js = new JSONObject(s) ;
			String brand = js.getString("brand");
			String model = js.getString("model");
			int price = js.getInt("price");
			
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM carmodels");
			int id = 1;
            while(rs.next()){
            		id = rs.getInt("total") ;
            }
            id++;
            
            PreparedStatement prepstmnt = conn.prepareStatement("INSERT INTO carmodels (id,brand, model, price) VALUES(?,?,?,?)");
            prepstmnt.setInt(1, id);
            prepstmnt.setString(2, brand);
            prepstmnt.setString(3, model);
            prepstmnt.setInt(4, price);
            prepstmnt.executeUpdate();
            
            conn.close();
            
            list.add(new Carmodel(brand, model,price, id));
            
            
            
            
		} catch (JSONException e) {
			
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		

		return list;
	}

}
