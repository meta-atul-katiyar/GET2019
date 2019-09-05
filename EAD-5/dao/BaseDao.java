package dao;

import java.util.List;
import enums.Status;
import model.*;

/**
 * This is the base dao.
 */
public interface BaseDao<T extends BaseEntity> {
   
     //Method to return the list of Product and  available stock
    public List<Product> getAllProduct();
    
    // Method to add product into cart
    public Status addProductToCart(int userId, int productId, int productQuantity);
    
    //Method to get cart items with quantity
    public List<ShoppingCart> getCartItems(int cartId);
        
    // Method to update cart items
    public Status updateCartItem(int cartId, int productId, int productQuantity);

    //Method to find product Name by product Id 
	public String getProductNameById(int productId);

    // Method to delete product from cart
	public Status deleteProductFromCart(int cartId, int productId);
	
}
