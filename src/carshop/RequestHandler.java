package carshop;

import java.sql.Connection;

public abstract class RequestHandler {
	
	protected static String url = "jdbc:sqlite:carshop.db";
	protected Connection conn;
	
	public abstract Object handleGetRequest();
	
	public abstract Object handlePostRequest(String s);
	
	
	protected class Employee{
		private int id;
		private String name;
		
		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		
		
	}
	
	protected class Carmodel{
		private int id;
		private String brand;
		private String model;
		private int price;
		
		public Carmodel(String brand, String model, int price, int id) {
			this.id = id;
			this.brand = brand;
			this.model = model;
			this.price = price;
		}
	}
	
	protected class EmployeeSales{
		private String name;
		private int id;
		private int sales = 0;
		
		public EmployeeSales(int id, String name) {
			this.id = id;
			this.name = name;
		}
		public void addSale(int sale) {
			sales += sale;
		}
		
		public int getId() {
			return id;
		}
		
	}

}
