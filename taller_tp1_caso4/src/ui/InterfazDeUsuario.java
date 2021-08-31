package ui;

import excepciones.OperacionImposibleException;
import negocio.Monitor;

public class InterfazDeUsuario
{
	private Monitor mon;
	
	public InterfazDeUsuario(Monitor mon)
	{
		this.mon = mon;
	}
	
	/**
	 * Metodo que invoca a un metodo de la clase Monitor para realizar una operacion determinada entre los dos 
	 * operandos. Dicha operacion y operandos son igresados por el usuario por medio de la interfaz 
	*/
	public int calcular()
	{
		int resultado = 0;
		int PrimerOperando = 0;
		int SegundoOperando = 0;
		String Operacion = null;
		
		//el usuario ingresa mediante la interfaz completa los campos solicitados para realizar la operacion requerida
		
		try
		{
			resultado = this.mon.calcular(PrimerOperando, SegundoOperando, Operacion);
		} catch (OperacionImposibleException e)
		{
			System.out.println(e.getMessage());
		}
		
		return resultado;
	}
	
	
	/**
	 * Metodo que devuelve el resultado de la ultima operacion existosa
	 * @return resultado de la ultima operacion efectuada
	 */
	public int traerResultado()
	{
		return this.mon.traerResultado();
	}
	
	
	
	
}
