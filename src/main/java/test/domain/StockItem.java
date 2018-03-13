package test.domain;

/**
 * This class associates an item with the stock quantity
 */
public class StockItem {
	
	/**
	 * Item in stock
	 */
	private Item item;
	
	/**
	 * Quantity of the item in stock
	 */
	private Long qty;

	/**
	 * Gets the item
	 * 
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Sets the item
	 * 
	 * @param item, new item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Gets the item quantity in stock
	 * 
	 * @return the item quantity in stock
	 */
	public Long getQty() {
		return qty;
	}

	/**
	 * Sets the quantity in stock of the item
	 *  
	 * @param qty, new quantity of the item in stock
	 */
	public void setQty(Long qty) {
		this.qty = qty;
	}

}
