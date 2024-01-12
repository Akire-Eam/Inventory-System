package Inventory.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Inventory.models.Product;


public class DBHandler {


	public boolean insertProduct(Product myProduct) {
		
		boolean result = false;

		try {
			String sql = "INSERT INTO product(sku, productName, productCategory, productBrand, productProperty, productDesc, quantity, units) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// insert values into prepared statement
			stmt.setString(1, myProduct.getSKU());
			stmt.setString(2, myProduct.getProductName());
			stmt.setString(3, myProduct.getProductCategory());
			stmt.setString(4, myProduct.getProductBrand());
			stmt.setString(5, myProduct.getProductProperty());
			stmt.setString(6, myProduct.getProductDesc());
			stmt.setInt(7,  myProduct.getQuantity());
			stmt.setString(8, myProduct.getUnits());


			int inserted = stmt.executeUpdate();
			

			result = inserted >= 1;
			

			DBConnection.disconnect(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
	
	public boolean deleteProduct(String upc) {
		
		boolean result = false;
		
		try {

			String sql = "DELETE FROM product WHERE productName = ?";
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			

			stmt.setString(1, upc);

			int deleted = stmt.executeUpdate();
			

			result = deleted >= 1;

			DBConnection.disconnect(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public Product getProductByName(String productName) {
		
		Product foundProduct = null;
		
		try {
			String sql = "SELECT * FROM product WHERE productName LIKE ? ";
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);


			stmt.setString(1, "%" + likeSanitize(productName) + "%");
			

			ResultSet results1 = stmt.executeQuery();

			while (results1.next()) {
				System.out.println("FOUND PRODUCT");
				foundProduct = new Product(results1.getString(1), results1.getString(2), results1.getString(3), results1.getString(4),
						results1.getString(5), results1.getString(6), results1.getInt(7), results1.getString(8));
			}

			if (foundProduct == null) {
				return foundProduct;
			}

			DBConnection.disconnect(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return foundProduct;
	}


	public boolean subtractProductQuantity(int amountToSubtract, String productName) {

		boolean result = false;

		try {

			String sql = "UPDATE product SET quantity = (quantity - ?) WHERE productName = ?";
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);


			stmt.setInt(1, amountToSubtract);
			stmt.setString(2, productName);


			int rowsUpdated = stmt.executeUpdate();


			result = rowsUpdated >= 1;


			DBConnection.disconnect(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}



	public ArrayList<Product> getProductsWithLowStock() {
		ArrayList<Product> productsList = new ArrayList<>();

		Product currProduct = null;

		try {
			String sql = "SELECT * FROM product WHERE quantity <= 10";
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);


			ResultSet results = stmt.executeQuery();


			while (results.next()) {
				currProduct = new Product(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getInt(7), results.getString(8));

				productsList.add(currProduct);
			}
			DBConnection.disconnect(conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return productsList;
	}




	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> productsList = new ArrayList<>();
		
		Product product = null;
		
		try {
			String sql = "SELECT * FROM product";
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			

			ResultSet results = stmt.executeQuery();
			

			while (results.next()) {
				product = new Product(results.getString(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getInt(7), results.getString(8));

				productsList.add(product);
			}
			
			DBConnection.disconnect(conn);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return productsList;
	}



	public ArrayList<Product> findProductsByName(String productName) {
		ArrayList<Product> productList = new ArrayList<>();
		Product currProduct = null;


		try {
			String sql = null;
			Connection conn = null;
			PreparedStatement stmt = null;

			sql = "SELECT * FROM product WHERE productName LIKE ?";
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);


			stmt.setString(1, "%" + likeSanitize(productName) + "%");


			ResultSet results = stmt.executeQuery();

			while (results.next()) {
				currProduct = new Product(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getInt(7), results.getString(8));
				productList.add(currProduct);
			}
			DBConnection.disconnect(conn);

		} catch(Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public ArrayList<Product> findProductsBySKU(String sku) {
		ArrayList<Product> productList = new ArrayList<>();
		Product currProduct = null;


		try {
			String sql = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			// parameterize SQL statement to deter SQL injection attacks
			sql = "SELECT * FROM product WHERE sku = ?";
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(sql);


			stmt.setString(1, sku);


			ResultSet results = stmt.executeQuery();


			while (results.next()) {
				currProduct = new Product(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getInt(7), results.getString(8));
				productList.add(currProduct);
			}
			DBConnection.disconnect(conn);

		} catch(Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public boolean deleteProductSKU(String sku) {

		boolean result = false;

		try {

			String sql = "DELETE FROM product WHERE sku = ?";
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);


			stmt.setString(1, sku);

			int deleted = stmt.executeUpdate();


			result = deleted >= 1;

			DBConnection.disconnect(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Product> findProductsBySKUOrNameOrCat(String productCat, String sku, String productName) {
		ArrayList<Product> productList = new ArrayList<>();
		Product currProduct = null;


		try {
			String sql = null;
			Connection conn = null;
			PreparedStatement stmt = null;

			if (productName.isBlank() && !productCat.isBlank()) {
				sql = "SELECT * FROM product " +
						"WHERE productCategory = ? OR " +
						"sku = ?";
				conn = DBConnection.getConnection();
				stmt = conn.prepareStatement(sql);


				stmt.setString(1, productCat);
				stmt.setString(2, sku);
			}

			else if (productCat.isBlank() && productName.isBlank()) {

				sql = "SELECT * FROM product " +
						"WHERE sku = ?";
				conn = DBConnection.getConnection();
				stmt = conn.prepareStatement(sql);


				stmt.setString(1, sku);
				System.out.println("This WORKED!");
			}

			else if (productCat.isBlank()) {
				sql = "SELECT * FROM product " +
						"WHERE sku = ? OR " +
						"productName LIKE ?";
				conn = DBConnection.getConnection();
				stmt = conn.prepareStatement(sql);


				stmt.setString(1, sku);
				stmt.setString(2, "%" + likeSanitize(productName) + "%");
			}
			else {

				sql = "SELECT * FROM product " +
						"WHERE productCategory = ? OR " +
						"sku = ? OR " +
						"productName LIKE ?";
				conn = DBConnection.getConnection();
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, productCat);
				stmt.setString(2, sku);
				stmt.setString(3, "%" + likeSanitize(productName) + "%");
			}

			ResultSet results = stmt.executeQuery();

			while (results.next()) {
				currProduct = new Product(results.getString(1), results.getString(2), results.getString(3), results.getString(4),
						results.getString(5), results.getString(6), results.getInt(7), results.getString(8));
				productList.add(currProduct);
			}
			DBConnection.disconnect(conn);

		} catch(Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public static String likeSanitize(String input) {
		return input
				.replace("!", "!!")
				.replace("%", "!%")
				.replace("_", "!_")
				.replace("[", "![");
	}


	public boolean addProductQuantity(int amountToAdd, String skuS) {
		boolean result = false;

		try {

			String sql = "UPDATE product SET quantity = (quantity + ?) WHERE sku = ?";
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);


			stmt.setInt(1, amountToAdd);
			stmt.setString(2, skuS);


			int rowsUpdated = stmt.executeUpdate();


			result = rowsUpdated >= 1;


			DBConnection.disconnect(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
