package carshop;

import static carshop.JsonUtil.json;
import static spark.Spark.*;

public class RequestController {
	
	public RequestController(RequestHandler getEmp, RequestHandler getCar, RequestHandler getSales, RequestHandler putCar) {
		
		before((req, res) -> {res.type("application/json");});
		
		get("/employees", (req, res) -> getEmp.handleGetRequest(), json());
		
		get("/carmodels", (req, res) -> getCar.handleGetRequest(), json());
		
		get("/total_sales", (req, res) -> getSales.handleGetRequest(), json());
		
		post("/carmodels", (req, res) -> putCar.handlePostRequest(req.body()), json());
		

		
		after((req, res) -> {res.type("application/json");});
		
		

	}
	

	

}
