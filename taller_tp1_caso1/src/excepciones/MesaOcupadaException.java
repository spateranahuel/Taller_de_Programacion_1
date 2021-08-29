package excepciones;

public class MesaOcupadaException extends Exception
{
	public String getMensaje()
	{
		return "La mesa referenciada esta ocupada";
	}
}