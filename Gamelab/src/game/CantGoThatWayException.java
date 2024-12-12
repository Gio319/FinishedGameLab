package game;

public class CantGoThatWayException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CantGoThatWayException (String error) {
		super(error);
	}
	
}
