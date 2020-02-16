package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.ShoppingCart;
import enums.Status;

/**
 * Class have methods which update and retrieve the data.
 */
public class SQLDao implements BaseDao<Product> {

	Connection connection;

	public SQLDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> productList = new ArrayList<>();
		try {
			String query = "select * from mvc2.product;";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				productList.add(new Product(resultSet.getInt(1), resultSet
						.getString(2), resultSet.getString(3), resultSet
						.getDouble(4)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return productList;
	}

	@Override
	public Status addProductToCart(int userId, int productId,
			int productQuantity) {
		try {
			String query1 = "select cartId from mvc2.userCartMap where userId = "
					+ userId;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			rs.next();
			int cartId = rs.getInt("cartId");
			System.out.println("cart id: " + cartId + " product id: "
					+ productId + " quantity: " + productQuantity);
			String query2 = "insert into mvc2.cart values(?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(query2);

			pst.setInt(1, cartId);
			pst.setInt(2, productId);
			pst.setInt(3, productQuantity);

			if (pst.executeUpdate() > 0) {
				return Status.ADDED;
			} else {
				return Status.INVALID;
			}
		} catch (SQLException e) {
			return Status.ERROR;
		} catch (Exception e) {
			return Status.ERROR;
		}
	}

	@Override
	public List<ShoppingCart> getCartItems(int userId) {
		List<ShoppingCart> cartList = new ArrayList<>();
		try {
			String query1 = "select cartId from mvc2.userCartMap where userId = "
					+ userId;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			rs.next();
			int cartId = rs.getInt("cartId");
			String query = "select * from mvc2.cart where cartId = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, cartId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cartList.add(new ShoppingCart(resultSet.getInt(1), resultSet
						.getInt(2), resultSet.getInt(3)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cartList;
	}

	@Override
	public Status updateCartItem(int userId, int productId, int productQuantity) {
		try {
			String query1 = "select cartId from mvc2.userCartMap where userId = "
					+ userId;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			rs.next();
			int cartId = rs.getInt("cartId");
			String query = "update mvc2.cart set quantity = " + productQuantity
					+ " where cartId = " + cartId + " and productId = "
					+ productId + ";";

			System.out.println(query);
			PreparedStatement statement = connection.prepareStatement(query);
			if (statement.executeUpdate() > 0) {
				return Status.UPDATED;
			} else {
				return Status.INVALID;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Status.ERROR;
		}
	}

	@Override
	public String getProductNameById(int productId) {
		String productName;
		try {

			String query = "SELECT productName FROM mvc2.Product WHERE productId = "
					+ productId;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			productName = resultSet.getString(1);
			System.out.println("productName: " + productName);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return productName;
	}

	@Override
	public Status deleteProductFromCart(int userId, int productId) {
		try {
			String query1 = "select cartId from mvc2.userCartMap where userId = "
					+ userId;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			rs.next();
			int cartId = rs.getInt("cartId");

			String query = "DELETE FROM mvc2.cart WHERE cartId=" + cartId
					+ " AND productId=" + productId;
			PreparedStatement statement = connection.prepareStatement(query);
			if (statement.executeUpdate() > 0) {
				return Status.UPDATED;
			} else {
				return Status.INVALID;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Status.ERROR;
		}
	}

}
