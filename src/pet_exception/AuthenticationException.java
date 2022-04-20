package pet_exception;

@SuppressWarnings("serial")
public class AuthenticationException extends Exception {

	public AuthenticationException(String error) {
		super(error);
	}
}
