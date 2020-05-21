package Project_1;

@SuppressWarnings("serial")
public class DivideByZeroException extends Exception {

	DivideByZeroException() {
		super();
	}
	
	DivideByZeroException(String message) {
		super(message);
	}
	
}