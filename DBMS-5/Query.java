
public class Query {

	public String getQuery(String shopperId){
		String query = "SELECT SO.shopperorderId, SO.timestamp, SO.totalamount "
				+ "FROM shopperorder AS SO NATURAL JOIN orderdetail AS OD WHERE "
				+ "SO.userId = "+ shopperId +" AND OD.status = 'shipped' AND "
				+ "SO.shopperorderId NOT IN (SELECT so.shopperorderId FROM shopperorder AS so NATURAL JOIN "
				+ "orderdetail AS od WHERE od.status <> 'shipped')  ";
		return query;
	}
	
	public String getInsertQuery(){
		String query = "INSERT INTO `storefront`.`productimage` "
				+ "(`imageName`, `productId`) VALUES (?, ?);";
		return query;
	}
	
	public String getDeleteQuery(){
		String query = "UPDATE product AS P  SET status = 0 WHERE P.productId NOT IN "
				+ " (SELECT od.productId FROM orderdetail AS od NATURAL JOIN shopperorder AS so "
				+ "WHERE so.timestamp > now() - INTERVAL 1 YEAR) AND P.productId >0";
		return query;
	}
	
	public String getCategoryQuery(){
		String query = "SELECT C.categoryName, count(C.categoryId) FROM category AS P "
				+ "INNER JOIN category AS C ON P.parentCategoryId = C.categoryId "
				+ "WHERE C.parentCategoryId is NULL GROUP BY P.parentCategoryId ORDER BY C.categoryName ";
		return query;
	}
}
