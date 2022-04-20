package pet_exception;

@SuppressWarnings("serial")
public class AuthorizationException extends Exception {

	public AuthorizationException(String error) {
		super(error);
	}
}
