
public class OrdersInShippedState {

	private String order_id;
	private String order_date;
	private String order_amount;
	
	public OrdersInShippedState(String order_id, String order_date,
			String order_amount) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.order_amount = order_amount;
	}

	// getters and setters
	public String getOrder_id() {
		return order_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public String getOrder_amount() {
		return order_amount;
	}
	
}
