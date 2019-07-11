import java.util.*;

/***
public class Products {
	long itemId;
	double unitPrice;
	String name;
	int quantity;

}
*/


public class ShoppingCart {
	
	static LinkedList<Products> cartItems = new LinkedList<Products>();
	
	
	// adding item to cart
		public void addToCart(long id, int quantity, double uPrice, String iName){
			Products obj = new Products();
			
			obj.itemId = id;
			obj.unitPrice = uPrice;
			obj.quantity = quantity;
			obj.name = iName;
			
			cartItems.add(obj);
		}
		
	
		// update cart
		public void updateCart(long id, int quantity){
			int numCount = 0;
			for (Products obj1 : cartItems){
				 if(obj1.itemId == id){
					 cartItems.remove(numCount);
					 obj1.quantity = quantity;
					 cartItems.add(obj1);
					 break;
				 }
				 numCount+=1;
			 }
		}
		
		// remove from cart
		public void removeFromCart(long id){
			int numCount=0;
			for (Products obj : cartItems){
				 if(obj.itemId == id){
					 cartItems.remove(numCount);
					 break;
				 }
				 numCount+=1;
			 }
		}
		
		
		//show cart
		public void showCart(){
			System.out.println("ITEM ID\t\t NAME\t\t QUANTITY\t\t UNIT PRICE");
			for (Products obj : cartItems){
				 System.out.println(obj.itemId + "\t\t" + obj.name + "\t\t" 
						 + obj.quantity + "\t\t"+ obj.unitPrice); 
			 }
			System.out.println("\n\n");
		}
		
		
		
		//generate bill
		public void generateBill(){
			double totalAmount = 0, costPerItem;
			System.out.println("ITEM ID\t\t NAME\t\t QUANTITY\t\t UNIT PRICE\t\t\tSUM ");
			for (Products obj : cartItems){
				costPerItem = obj.quantity * obj.unitPrice;
				totalAmount += costPerItem; 
				 System.out.println(obj.itemId + "\t\t" + obj.name + "\t\t" 
						 + obj.quantity + "\t\t"+ obj.unitPrice 
						 + "\t\t" + costPerItem); 
			 }
			System.out.println();
			System.out.print("Total\t");
			System.out.println(totalAmount+"\n\n\n");
		}

	public static void main(String args[]){
		
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart(11111, 4, 1000, "shoe");
		cart.addToCart(11112, 2, 200, "shoe");
		cart.addToCart(11113, 40, 2000, "shoe");
		cart.addToCart(11114, 14, 4000, "shoe");
		
		//show cart
		cart.showCart();
		
		//removing one item
		cart.removeFromCart(11112);
		cart.showCart();
		
		//updating one item
		cart.updateCart(11113, 30);
		cart.generateBill();
		 
	}

}



