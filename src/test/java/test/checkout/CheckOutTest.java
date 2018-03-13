package test.checkout;

import org.junit.Assert;
import org.junit.Test;

import test.AbstractTest;
import test.domain.CheckOut;
import test.exception.AddingUnavailableItemException;

/**
 * This class contains all the tests related to the checkout process
 */
public class CheckOutTest extends AbstractTest{

	private CheckOut checkout;
	
	@Override
	public void init() {
		this.checkout = new CheckOut(store);
	}

	@Test
	public void addOneItemTest() {

		// when
		checkout.addItem(itemOne);
		int numberOfItems = checkout.getQuantity(itemOne);

		// then
		Assert.assertEquals(1, numberOfItems);
	}

	@Test
	public void addMoreThanOneOfSingleItem() {

		// given
		int qty = 3;

		// when
		for (int i = 0; i < qty; i++) {
			checkout.addItem(itemOne);
		}

		int numberOfItems = checkout.getQuantity(itemOne);

		// then
		Assert.assertEquals(qty, numberOfItems);

	}

	@Test
	public void addMoreThanOneOfMultipleItems() {

		// given
		int qty = 3;

		// when
		for (int i = 0; i < qty; i++) {
			checkout.addItem(itemOne);
			checkout.addItem(itemTwo);
		}

		int numberOfItemsOne = checkout.getQuantity(itemOne);
		int numberOfItemsTwo = checkout.getQuantity(itemTwo);

		// then
		Assert.assertEquals(qty, numberOfItemsOne);
		Assert.assertEquals(qty, numberOfItemsTwo);

	}

	@Test(expected = AddingUnavailableItemException.class)
	public void addMoreItemsThanPresentStock() {
		// given
		int qty = 100;

		// when
		for (int i = 0; i < qty; i++) {
			checkout.addItem(itemOne);
			checkout.addItem(itemTwo);
		}
		
	}
	
	@Test
	public void calculateCheckoutTotalEmptyCheckout() {
		Assert.assertTrue(checkout.calculateTotal() == 0.0);
	}
	
	@Test
	public void calculateCheckoutTotalWithNoDiscount() {
		
		// when
		checkout.addItem(itemOne);
		
		// then
		Assert.assertTrue(checkout.calculateTotal() == 50.0);
		
	}
	
	@Test
	public void calculateCheckoutTotalWithDiscount() {
		
		// when
		checkout.addItem(itemOne);
		checkout.addItem(itemOne);
		checkout.addItem(itemOne);
		
		// then
		Assert.assertTrue(checkout.calculateTotal() == 130.0);
		
	}
	
	@Test
	public void calculateCheckoutTotalWithAndNoDiscountMultipleItemsTest() {
		
		// when
		checkout.addItem(itemOne);
		checkout.addItem(itemOne);
		checkout.addItem(itemOne);
		checkout.addItem(itemTwo);
		
		// then
		Assert.assertTrue(checkout.calculateTotal() == 160.0);
		
	}
	
	@Test
	public void calculateCheckoutTotalWithMultipleDiscountTest() {
		
		// when
		checkout.addItem(itemOne);
		checkout.addItem(itemOne);
		checkout.addItem(itemOne);
		checkout.addItem(itemTwo);
		checkout.addItem(itemTwo);
		
		// then
		Assert.assertTrue(checkout.calculateTotal() == 175.0);
		
	}
	
}
