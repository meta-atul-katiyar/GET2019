package model;

/**
 * This class represents a Product
 */
public class Product extends BaseEntity {
	
	private String productType;
	private String productName;
	private double productPrice;
	
	/**
	 * Initialize the product entity. 
	 * @param productCode
	 * @param productType
	 * @param productName
	 * @param productPrice
	 */
	public Product(int productCode, String productType, String productName, double productPrice)
	{
		super(productCode);
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
	}

	//Return the product type.
	public String getProductType() {
		return productType;
	}

	//Return the product name
	public String getProductName() {
		return productName;
	}

	//Return the product price.
	public double getProductPrice() {
		return productPrice;
	}
}
