package test.exception;

/**
 * Exception to be thrown when a not available item in stock
 * is being considered as available
 */
public class AddingUnavailableItemException extends RuntimeException{

	public AddingUnavailableItemException() {}
	
	public AddingUnavailableItemException(String msg) {
		super(msg);
	}
	
}
