package test.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import test.domain.CheckOut;
import test.domain.Item;
import test.domain.Store;
import test.exception.AddingUnavailableItemException;

/**
 * This class represents a possible client of the Store
 */
public class StoreApp {

	/**
	 * Default file containing the items available in this store
	 * and the corresponding possible discounts
	 */
	private static final String STOCK_FILE_NAME = "src/main/resources/stock.properties";
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		String stockFileName = args.length == 0 ? STOCK_FILE_NAME : args[0];
		
		Store store = new Store(stockFileName);
		CheckOut checkout = store.createCheckout();
		
		boolean shopping = true;
		while(shopping) {
			
			store.printStockItems();
			
			System.out.print("Select an article by its ID or return to checkout: ");
			Scanner scanner = new Scanner(System.in);
			String selectedItem = scanner.nextLine();
			
			// check if is to checkout
			if(selectedItem.isEmpty()) {				
				shopping = false;
			} else {
				
				try {
					
					Long itemId = Long.parseLong(selectedItem);
					Item item = store.getItemById(itemId);
					checkout.addItem(item);
					System.out.println("Added " + item.getDesignation() + " to your cart");
					
				}catch(AddingUnavailableItemException e){
					System.out.println("The item you're trying to add is not available, please select another.");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
		}
		
		System.out.println("Your total is: " + checkout.calculateTotal());
		
	}
	
}
