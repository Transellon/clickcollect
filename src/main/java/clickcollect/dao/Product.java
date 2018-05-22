package clickcollect.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * A class to store the fixed attributes of a single product. 
 * @author vikramgupta
 *
 */
@DynamoDBTable(tableName = "Products")
public class Product {
	private String productID;
	private String SKU;
	private String productName;
	private String productDescription;
	private String categoryID;
	private String unitPrice;
	private String brand;
	private String storeIDs;
	
	@DynamoDBHashKey(attributeName = "ProductID")
	public String getProductID() {
		return productID;
	}
	
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	@DynamoDBHashKey(attributeName = "SKU")
	public String getSKU() {
		return SKU;
	}
	
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	
	@DynamoDBHashKey(attributeName = "productName")
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@DynamoDBHashKey(attributeName = "productDescription")
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	@DynamoDBHashKey(attributeName = "categoryID")
	public String getCategoryID() {
		return categoryID;
	}
	
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	
	@DynamoDBHashKey(attributeName = "unitPrice")
	public String getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@DynamoDBHashKey(attributeName = "brand")
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@DynamoDBHashKey(attributeName = "storeID")
	public String getStoreIDs() {
		return storeIDs;
	}
	
	public void setStoreIDs(String storeIDs) {
		this.storeIDs = storeIDs;
	}
	
	
}
