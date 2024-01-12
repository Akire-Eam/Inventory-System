package Inventory.models;

import javafx.beans.property.*;

public class Product {

	private StringProperty sku;
	private StringProperty productName;
	private IntegerProperty quantity;
	private StringProperty productCategory;
	private StringProperty productBrand;
	private StringProperty productProperty;
	private StringProperty productDesc;
	private StringProperty units;

	public Product(String sku, String productName, String productCategory, String productBrand, String productProperty, String productDesc, int quantity, String units) {
		try {
			if (quantity >= 0) {
				this.sku = new SimpleStringProperty(sku);
				this.productName = new SimpleStringProperty(productName);
				this.productCategory = new SimpleStringProperty(productCategory);
				this.productBrand = new SimpleStringProperty(productBrand);
				this.productProperty = new SimpleStringProperty(productProperty);
				this.productDesc = new SimpleStringProperty(productDesc);
				this.quantity = new SimpleIntegerProperty(quantity);
				this.units = new SimpleStringProperty(units);

			}
			else {
				throw new ArithmeticException("Failed to create new instance of Product. quantity is a negative value");
			}
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getSKU() { return sku.get(); }

	public String getProductName() { return productName.get(); }

	public int getQuantity() { return quantity.get(); }

	public String getProductCategory() { return productCategory.get(); }

	public String getProductProperty() { return productProperty.get(); }
	public String getProductBrand() { return productBrand.get(); }
	public String getProductDesc() { return productDesc.get(); }
	public String getUnits() { return units.get(); }



	public void setSku(String sku) { this.sku.set(sku);	}

	public void setProductName(String productName) {
		this.productName.set(productName);
	}

	public void setQuantity(int quantity) {
		this.quantity.set(quantity);
	}
	public void setProductCategory(String productCategory) { this.productCategory.set(productCategory);	}
	public void setProductProperty(String productProperty) { this.productProperty.set(productProperty);	}
	public void setProductBrand(String productBrand) { this.productBrand.set(productBrand);	}
	public void setProductDesc(String productDesc) { this.productDesc.set(productDesc);	}
	public void setUnits(String units) { this.units.set(units);	}


}
