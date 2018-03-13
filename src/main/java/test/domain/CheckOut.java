package test.domain;

import java.util.HashMap;
import java.util.Map;

import test.exception.AddingUnavailableItemException;

/**
 * This class represents an check out
 */
public class CheckOut {

	/**
	 * Items present in the check out
	 */
	private Map<Item, Integer> items;
	
	/**
	 * This checkout store
	 */
	private Store store;
	
	public CheckOut(Store store) {
		this.items = new HashMap<Item, Integer>();
		this.store = store;
	}

	/**
	 * Adds an item to this checkout item map
	 * 
	 * @param item, item to be added
	 */
	public void addItem(Item item) {
		
		if(!store.isItemAvailable(item)) {
			throw new AddingUnavailableItemException("Item ID: " + item.getId() + " is not available");
		}
		
		Integer qty = 1;
		if(items.containsKey(item)) {
			qty = items.get(item) + 1;
		}
		items.put(item, qty);
		store.removeItemUnitFromStockItems(item);
	}
	
	/**
	 * Gets the quantity of the given item
	 * 
	 * @param item, item to be considered
	 * @return item quantity if present, otherwise 0
	 */
	public Integer getQuantity(Item item) {
		Integer qty = items.get(item);
		return qty != null ? qty : 0;
	}

	/**
	 * Calculates the total value for this checkout
	 * 
	 * @return the corresponding total value
	 */
	public Double calculateTotal() {
		
		Double total = 0.0;
		
		// sum up all the items and all quantities
		for(Item item : items.keySet()) {
			
			Integer qty = items.get(item);
			
			// has discount
			if(store.hasDiscount(item) && qty >= store.getDiscount(item).getUnits()) {
				Discount discount = store.getDiscount(item); 
				
				// calculate discount and non discount units
				Long nonDiscountQty = qty % discount.getUnits();
				Long discountQty = qty - nonDiscountQty;
				
				// Non Discount Value
				Double NDV = nonDiscountQty * item.getPrice();
				
				// Discount Value
				Double DV = (discountQty / discount.getUnits()) * discount.getPrice();
				
				total += NDV + DV;

			}
			// has no discount
			else {
				total += qty * item.getPrice();
			}
			
		}
		
		return total;
	}
}
