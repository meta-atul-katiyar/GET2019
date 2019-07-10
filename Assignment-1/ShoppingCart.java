
public class ShoppingCart{
	private long[] itemIdArray = new long[100];
	private int[] itemQuantity = new int[100];
	private float[] unitPrice = new float[100];
	static int count=0;
	
	// adding item to cart
	public void addToCart(long id, int quantity, float uPrice){
		itemIdArray[count] = id;
		itemQuantity[count] = quantity;
		unitPrice[count]= uPrice;
		count+=1;
	}

	// update cart
	public void updateCart(long id, int quantity){
		for (int numCount=0; numCount<=count; numCount+=1){
			if(itemIdArray[numCount] == id){
				itemQuantity[numCount] = quantity;
				break;
			}
		}
	}

	// remove from cart
	public void removeFromCart(long id){
		for (int numCount=0; numCount<=count; numCount+=1){
			if(itemIdArray[numCount] == id){
				itemQuantity[numCount] = 0;
				break;
			}
		}
	}
	
	//show cart
	public void showCart(){
		System.out.println("ITEM ID\t\t QUANTITY\t\t UNIT PRICE");
		for (int numCount=0; numCount<=count; numCount+=1){
			if(itemQuantity[numCount] > 0){
				System.out.print(itemIdArray[numCount]+"\t\t\t");
				System.out.print(itemQuantity[numCount]+"\t\t\t");
				System.out.println(unitPrice[numCount]);
			}
		}
		System.out.println("\n\n");
	}

	//generate bill
	public void generateBill(){
		double totalAmount = 0, costPerItem;
		System.out.println("ITEM ID\t\t QUANTITY\t\t UNIT PRICE\t\t\tSUM ");
		for (int numCount=0; numCount<=count; numCount+=1){
			if(itemQuantity[numCount] > 0){
				System.out.print(itemIdArray[numCount]+"\t\t\t");
				System.out.print(itemQuantity[numCount]+"\t\t\t");
				System.out.print(unitPrice[numCount]+"\t\t\t");
				costPerItem = unitPrice[numCount]*itemQuantity[numCount];
				totalAmount += costPerItem;
				System.out.println(costPerItem);
			}
		}
		System.out.print("Total\t\t\t\t\t\t\t\t\t");
		System.out.println(totalAmount+"\n\n");
	}


	public static void main(String args[]){
		//object of the class
		ShoppingCart cart1 = new ShoppingCart();

		// adding item in cart
		cart1.addToCart(11111, 4, 20);
		cart1.addToCart(11112, 2, (float)20.5);
		cart1.addToCart(11113, 4, (float)200.75);

		//show cart
		System.out.println("CART DETAILS:");
		cart1.showCart();

		// generate bill
		System.out.println("BILL:");
		cart1.generateBill();

		//update cart
		cart1.updateCart(11111, 2);
		System.out.println("BILL AFTER REDUCING QUANTITY OF ID- 11111 (4 to 2):");
		cart1.generateBill();

		//remove from cart
		cart1.removeFromCart(11112);
		System.out.println("BILL AFTER REMOVING ITEM OF ID - 11112:");
		cart1.generateBill();

	}

}



	

