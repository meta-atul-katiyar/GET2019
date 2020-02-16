package facade;

import java.util.List;

import dao.LoginDao;
import dao.ProductDao;
import enums.DBType;
import enums.Status;
import factory.Factory;
import model.Product;
import model.ShoppingCart;

/**
 * This class represents the facade layer of the system
 */
public class ProductFacade {

	ProductDao productDao = Factory.createProductDao(DBType.MYSQL);
	
	// This method generates a query to display all products
	public List<Product> getAllProduct()
	{
		return productDao.getAllProduct();
	}
	
	//This method generates a query to add product to the cart
	public Status addProductToTheCart(int userId, int productId, int productQuantity)
	{
		return productDao.addProductToCart(userId, productId, productQuantity);
	}
	
	// This method generates a query to display the cart
	public List<ShoppingCart> getCartItems(int cartId)
	{
		return productDao.getCartItems(cartId);
	}
	
	//This method generate a query to updates the cart
	public Status updateCartItem(int cartId, int productId, int productQuantity)
	{
		return productDao.updateCartItem(cartId, productId, productQuantity);
	}

	//This method generate a query to find product Name by product Id
	public String getProductNameById(int productId) {
		return productDao.getProductNameById(productId);
	}

	// This method generate a query to delete product from cart
	public Status deleteProductFromCart(int userId, int productId) {
		return productDao.deleteProductFromCart(userId, productId);
	}

	// This method generate a query to authenticate the user
	public boolean authenticateUser(String email, String password) {
		return LoginDao.authenticateUser(email, password);
	}
	
	public int getUserId(String email)
	{
		return LoginDao.getUserId(email);
	}
}
