package factory;

import java.sql.SQLException;

import dao.ProductDao;
import enums.DBType;
import facade.ProductFacade;
import model.Product;
import model.ShoppingCart;

public class Factory {

	/**
     * Method creates and returns Product type Object
     * @param productCode 
     * @param productType
     * @param productName 
     * @param productPrice
     * @return Product object
     */
    public static Product createProduct(int productCode, String productType, String productName,double productPrice){
        Product product=new Product (productCode, productType, productName, productPrice);
        
        return product;        
    }
  
    /**
     * Method creates and returns ShoppingCart type Object
     * @return ShoppingCart Object
     */
    public static ShoppingCart createShoppingCart(){
        ShoppingCart shoppingCart =new ShoppingCart();
        
        return shoppingCart;
    }
    
    /**
     * Method creates and returns ProductFacade type Object
     * @return ProductFacade Object
     */
    public static ProductFacade createProductFacade(){
        return new ProductFacade();
    }
    
    /**
     * Method creates and returns ProductDao type Object
     * @return ProductDao Object
     */
    public static ProductDao createProductDao(DBType dbType){
        try {
			return new ProductDao(dbType);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
