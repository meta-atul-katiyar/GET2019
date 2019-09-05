package controller;

import java.util.List;

import model.Product;
import model.ShoppingCart;
import enums.Status;
import facade.ProductFacade;

  /**
   *This class represents a controller layer 
   */
  public class ProductController {
	
	ProductFacade facade = new ProductFacade();
	
    // Method to return the list of Product and  available stock
    public List<Product> getAllProduct()
    {
        return facade.getAllProduct();
    }
 
    // Method to add product to the cart
    public Status addProductToCart(int userID, int productID,int productQuantity)
    {
        return facade.addProductToTheCart(userID, productID, productQuantity);
    }
   
    // Method to get cart items with quantity
    public List<ShoppingCart> getCartItems(int cartId){
        return facade.getCartItems(cartId);
    }
     
    // Method to update cart items
    public Status updateCartItem(int cartId, int productID,int productQuantity){
        return facade.updateCartItem(cartId, productID, productQuantity);
    }

    //Method to find product Name by product Id
	public String getProductNameById(int productId) {
		return facade.getProductNameById(productId);
	}

	// Method to delete product from cart
	public Status deleteProductFromCart(int userId, int productId) {
		return facade.deleteProductFromCart(userId, productId);
	}

	// Method to authenticate the user
	public boolean authenticateUser(String email, String password) {
		return facade.authenticateUser(email, password);
	}
	
	public int getUserId(String email)
	{
		return facade.getUserId(email);
	}
}
