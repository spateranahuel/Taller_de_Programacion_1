package excepciones;

public class cantidadDeMesasInvalidaException extends Exception
{
	public String getMensaje()
	{
		return "El numero ingresado para la cantidad de mesas es invalido";
	}
}
