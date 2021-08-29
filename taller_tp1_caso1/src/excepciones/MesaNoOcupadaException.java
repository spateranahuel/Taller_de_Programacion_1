package excepciones;

public class MesaNoOcupadaException extends Exception
{
	public String getMensaje()
	{
		return "La mesa no esta ocupada";
	}
}
