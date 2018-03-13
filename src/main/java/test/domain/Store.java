package test.domain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import test.catalogs.DiscountsCatalog;

/**
 * This class represent the stock of the store
 * 
 * @author JoaoRodrigues
 *
 */
public class Store {

	/**
	 * All the items available in this store
	 * 
	 * The Key is the unique identifier of this item in this store context
	 * 
	 * The Value is the Stock Item itself
	 */
	private Map<Long, StockItem> stockItems;

	/**
	 * The discounts information
	 */
	private DiscountsCatalog discountsCatalog;

	public Store(String stockFileName) throws FileNotFoundException, IOException, ParseException {
		init(stockFileName);
	}
	
	@SuppressWarnings("unchecked")
	private void init(String stockFileName) throws FileNotFoundException, IOException, ParseException {

		// fetch items list
		stockItems = new HashMap<Long, StockItem>();

		// initialize discounts catalog
		discountsCatalog = new DiscountsCatalog();

		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader(stockFileName));

		JSONObject json = (JSONObject) obj;
		JSONArray array = (JSONArray) json.get("stock");

		Iterator<JSONObject> iterator = array.iterator();
		while (iterator.hasNext()) {
			JSONObject cur = iterator.next();

			// stock quantity
			Long stockQty = (Long) cur.get("qty");

			// item
			JSONObject curItem = (JSONObject) cur.get("item");
			Item item = new Item();
			item.setId((Long) curItem.get("id"));
			item.setDesignation((String) curItem.get("designation"));
			item.setPrice((Double) curItem.get("price"));

			StockItem stockItem = new StockItem();
			stockItem.setItem(item);
			stockItem.setQty(stockQty);

			stockItems.put(item.getId(), stockItem);

			// item discount
			JSONObject curDiscount = (JSONObject) curItem.get("discount");
			if (curDiscount != null) {
				Discount discount = new Discount();
				discount.setPrice((Double) curDiscount.get("specialPrice"));
				discount.setUnits((Long) curDiscount.get("qty"));
				this.discountsCatalog.addDiscount(item, discount);
			}

		}

	}

	/**
	 * Initialize a checkout AKA sale
	 * 
	 * @return the newly created checkout
	 */
	public CheckOut createCheckout() {
		CheckOut co = new CheckOut(this);
		return co;
	}

	/**
	 * Gets the store stock items
	 * 
	 * @return store stock items
	 */
	public Map<Long, StockItem> getStockItems() {
		return this.stockItems;
	}

	/**
	 * Prints a textual representation of the store stock items
	 */
	public void printStockItems() {
		String separator = "        ";
		
		for (StockItem stockItem : stockItems.values()) {
			StringBuilder sb = new StringBuilder();
			sb.append("ID: ");
			sb.append(stockItem.getItem().getId());
			
			sb.append(separator);
			sb.append("NAME: ");
			sb.append(stockItem.getItem().getDesignation());
			
			sb.append(separator);
			sb.append("QTY: ");
			sb.append(stockItem.getQty());
			
			sb.append(separator);
			sb.append("PRICE: ");
			sb.append(stockItem.getItem().getPrice());
			System.out.println(sb);
		}
	}

	/**
	 * Gets an item in stock by its stock item id
	 * 
	 * @param itemId,
	 *            stock item id to be considered
	 * @return the corresponding stock item id if exists, otherwise null
	 */
	public Item getItemById(Long itemId) {
		StockItem stockItem = stockItems.get(itemId);
		return stockItem == null ? null : stockItem.getItem();
	}

	/**
	 * Checks if a given item is available in stock
	 * 
	 * @param item,
	 *            item to be considered
	 * @return true if available, false otherwise
	 * @requires stockItems.get(item.getId()) != null
	 */
	public Boolean isItemAvailable(Item item) {
		return this.stockItems.get(item.getId()).getQty() > 0;
	}

	/**
	 * Removes a unit from stock items
	 * 
	 * @param item,
	 *            item to have a unit removed from stock items
	 * @requires item != null && stockItems.get(item.getId()) != null;
	 */
	public void removeItemUnitFromStockItems(Item item) {
		StockItem stockItem = stockItems.get(item.getId());
		Long currentQty = stockItem.getQty();
		stockItem.setQty(--currentQty);
	}

	public Boolean hasDiscount(Item item) {
		return this.discountsCatalog.getDiscount(item) != null;
	}

	public Discount getDiscount(Item item) {
		return this.discountsCatalog.getDiscount(item);
	}

}
