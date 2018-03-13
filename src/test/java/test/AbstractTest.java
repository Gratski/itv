package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import test.domain.Item;
import test.domain.Store;

/**
 * Represents a abstract test
 *
 */
public abstract class AbstractTest {

	protected static final String STOCK_FILE_NAME = "src/test/resources/stock_test.properties";

	protected Store store;
	
	protected Item itemOne, itemTwo, itemThree;

	@Before
	public void before() throws FileNotFoundException, IOException, ParseException {
		store = new Store(STOCK_FILE_NAME);

		// items
		itemOne = store.getItemById(1L);
		itemTwo = store.getItemById(2L);
		itemThree = store.getItemById(3L);
		
		init();
	}
	
	public abstract void init();

}
