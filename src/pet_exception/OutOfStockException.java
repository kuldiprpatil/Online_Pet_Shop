package pet_exception;

@SuppressWarnings("serial")
public class OutOfStockException extends Exception {

	public OutOfStockException(String error) {
		super(error);
	}
}
