package dao;

import java.sql.SQLException;
import java.util.List;

import enums.DBType;
import enums.Status;
import model.Product;
import model.ShoppingCart;

public class ProductDao implements BaseDao<Product> {
	
	BaseDao<Product> baseDao;
	
	public ProductDao(DBType dbType) throws ClassNotFoundException, SQLException
	{
		if(dbType == DBType.IN_MEMORY)
		{
			baseDao = new InMemoryDao();
		}
		else
		{
			baseDao = new SQLDao();
		}
	}

	@Override
	public List<Product> getAllProduct() {
		return baseDao.getAllProduct();
	}

	@Override
	public Status addProductToCart(int userId, int productId, int productQuantity) {
		return baseDao.addProductToCart(userId, productId, productQuantity);
	}

	@Override
	public List<ShoppingCart> getCartItems(int userId) {
		return baseDao.getCartItems(userId);
	}

	@Override
	public Status updateCartItem(int userId, int productId, int productQuantity) {
		return baseDao.updateCartItem(userId, productId, productQuantity);
	}

	@Override
	public String getProductNameById(int productId) {
		return baseDao.getProductNameById(productId);
	}

	@Override
	public Status deleteProductFromCart(int userId, int productId) {
		
		return baseDao.deleteProductFromCart(userId, productId);
	}

}
