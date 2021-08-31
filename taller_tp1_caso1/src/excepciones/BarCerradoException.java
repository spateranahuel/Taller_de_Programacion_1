package excepciones;

public class BarCerradoException extends Exception
{
	public String getMensaje()
	{
		return "El bar esta cerrado";
	}
}
