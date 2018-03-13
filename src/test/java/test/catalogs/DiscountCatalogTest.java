package test.catalogs;

import org.junit.Assert;
import org.junit.Test;

import test.domain.Discount;
import test.domain.Item;

/**
 * This is responsible for testing stock operations
 * 
 * @author JoaoRodrigues
 *
 */
public class DiscountCatalogTest {
	
	@Test
	public void validHasDiscountTest() {
		
		// given
		Item item = new Item();
		item.setId(1L);
		item.setPrice(10.0);
		item.setDesignation("Milk");
		
		Discount discount = new Discount();
		discount.setPrice(45.0);
		discount.setUnits(3L);
		
		DiscountsCatalog catalog = new DiscountsCatalog();
		catalog.addDiscount(item, discount);
		
		// when
		boolean hasDiscount = catalog.hasDiscount(item);
		
		// then
		Assert.assertTrue(hasDiscount);
	}
	
	@Test
	public void invalidHasDiscountTest() {
		
		// given
		Item itemOne = new Item();
		itemOne.setId(1L);
		itemOne.setPrice(10.0);
		itemOne.setDesignation("Milk");
		
		Item itemTwo = new Item();
		itemTwo.setId(2L);
		itemTwo.setPrice(10.0);
		itemTwo.setDesignation("Soya");
		
		Discount discount = new Discount();
		discount.setPrice(45.0);
		discount.setUnits(3L);
		
		DiscountsCatalog catalog = new DiscountsCatalog();
		catalog.addDiscount(itemOne, discount);
		
		// when
		boolean hasDiscountOne = catalog.hasDiscount(itemOne);
		boolean hasDiscountTwo = catalog.hasDiscount(itemTwo);
		
		// then
		Assert.assertTrue(hasDiscountOne);
		Assert.assertTrue(!hasDiscountTwo);
	}
	
}
