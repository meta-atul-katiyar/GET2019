package model;

/**
 * This class represents a Shopping Cart
 */
public class ShoppingCart extends BaseEntity {
	private int productId;
	private int productQuantity;
	
	/**
	 * Initialize the cart product information.
	 * @param cartId
	 * @param productId
	 * @param productQuantity
	 */
	public ShoppingCart(int cartId, int productId, int productQuantity)
	{
		super(cartId);
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
	
	//Default constructor. 
	public ShoppingCart() {
		super();
	}
	
	//Return the product id.
	public int getProductId() {
		return productId;
	}
	
	//Return the product quantity. 
	public int getProductQuantity() {
		return productQuantity;
	}
	
}
