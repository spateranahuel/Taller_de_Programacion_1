package excepciones;

public class BarYaAbiertoException extends Exception
{
	public String getMensaje()
	{
		return "El bar ya esta abierto";
	}
}
