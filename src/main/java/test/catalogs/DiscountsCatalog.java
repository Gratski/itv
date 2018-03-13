package test.catalogs;

import java.util.HashMap;
import java.util.Map;

import test.domain.Discount;
import test.domain.Item;

/**
 * This class represents the Discounts Catalog
 * It has all the information of all available discounts 
 */
public class DiscountsCatalog {

	/**
	 * The repository with the discount applied to a certain item
	 */
	private Map<Item, Discount> discountRepository;
	
	public DiscountsCatalog() {
		this.discountRepository = new HashMap<Item, Discount>();
	}
	
	/**
	 * Adds a discount to an item
	 * 
	 * @param item, item to be related to discount
	 * @param discount, discount to be applied to the item
	 * @require discountRepository != null 
	 */
	public void addDiscount(Item item, Discount discount) {
		this.discountRepository.put(item, discount);
	}
	
	/**
	 * Checks if the given item is associated with a discount
	 * 
	 * @param item
	 * @return
	 */
	public boolean hasDiscount(Item item) {
		return this.discountRepository.containsKey(item);
	}
	
	/**
	 * Gets the discount to the given item
	 * 
	 * @param item, item to be considered
	 * @return the corresponding discount, otherwise null
	 */
	public Discount getDiscount(Item item) {
		return this.discountRepository.get(item);
	}
	
}
