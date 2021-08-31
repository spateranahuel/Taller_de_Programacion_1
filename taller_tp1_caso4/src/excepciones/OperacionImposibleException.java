package excepciones;

public class OperacionImposibleException extends Exception
{

	@Override
	public String getMessage()
	{
		return super.getMessage();
	}

	public OperacionImposibleException(String message)
	{
		super(message);
	}
	
}
