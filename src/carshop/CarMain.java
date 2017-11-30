package carshop;


public class CarMain {
	public static void main(String[] args) {
		new RequestController(new GetEmployees(), new GetCarmodels(), new GetTotalSales(), new PutCarmodels());
	}

}
