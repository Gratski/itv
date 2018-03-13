package test.exception;

/**
 * Exception to be thrown when a not available item in stock
 * is being considered as available
 */
public class AddingUnavailableItemException extends RuntimeException{

	private static final long serialVersionUID = -1347436813274727961L;

	public AddingUnavailableItemException() {}
	
	public AddingUnavailableItemException(String msg) {
		super(msg);
	}
	
}
