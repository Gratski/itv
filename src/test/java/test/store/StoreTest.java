package test.store;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import test.AbstractTest;
import test.domain.Discount;
import test.domain.Item;

public class StoreTest extends AbstractTest{

	@Override
	public void init() {}
	
	@Test
	public void storeInitTest() throws FileNotFoundException, IOException, ParseException {
		
		// then
		Assert.assertTrue(store.getStockItems().size() == 4);
	}
	
	@Test
	public void storeItemExistanceTest() throws FileNotFoundException, IOException, ParseException {
		
		// when
		Item item = store.getItemById(itemOne.getId());
		
		// then
		Assert.assertNotNull(item);
		
	}
	
	@Test
	public void storeItemNonExistanceTest() throws FileNotFoundException, IOException, ParseException {
		
		// when
		Item item = store.getItemById(5000L);
		
		// then
		Assert.assertNull(item);
		
	}
	
	@Test
	public void testItemAvailabilityAvailable() {
		
		Assert.assertTrue(store.isItemAvailable(itemOne));
		
	}
	
	@Test
	public void testItemAvailabilityUnavailable() {
		
		Assert.assertFalse(store.isItemAvailable(itemThree));
		
	}
	
	@Test
	public void removeUnitFromStockItems() {
		
		Assert.assertTrue(store.isItemAvailable(itemOne));
		
		store.removeItemUnitFromStockItems(itemOne);
		store.removeItemUnitFromStockItems(itemOne);
		store.removeItemUnitFromStockItems(itemOne);
		
		Assert.assertFalse(store.isItemAvailable(itemOne));
		
	}
	
	@Test
	public void tryToRemoveUnexistingUnitFromStock() {
		
		store.removeItemUnitFromStockItems(itemThree);
		Assert.assertFalse(store.isItemAvailable(itemThree));
	}
	
	@Test
	public void verifyExistingDiscountTest() {
		
		// when
		Discount discount = store.getDiscount(itemOne);
		
		// then
		Assert.assertNotNull(discount);
		
	}
	
	@Test
	public void verifyNonExistingDiscountTest() {
		
		// when
		Discount discount = store.getDiscount(itemThree);
		
		// then
		Assert.assertNull(discount);
		
	}
	
	
}
