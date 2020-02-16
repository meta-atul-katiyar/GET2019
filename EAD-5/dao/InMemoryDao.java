package dao;

import java.util.List;

import enums.Status;
import model.Product;
import model.ShoppingCart;

public class InMemoryDao implements BaseDao<Product> {

	@Override
	public List<Product> getAllProduct() {
		return null;
	}

	@Override
	public Status addProductToCart(int userId, int productId,
			int productQuantity) {
		return Status.ERROR;
	}

	@Override
	public List<ShoppingCart> getCartItems(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status updateCartItem(int cartId, int productId, int productQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProductNameById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status deleteProductFromCart(int cartId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}


}
