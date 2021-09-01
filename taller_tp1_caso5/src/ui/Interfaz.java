package ui;

import excepciones.NroInvalidoException;
import excepciones.NuevoJuegoException;
import negocio.Monitor;

public class Interfaz
{
	private Monitor mon;
	private boolean bloqueado;
	
	public Interfaz(Monitor mon)
	{
		this.mon = mon;
	}
	
	public void botonJuego()
	{
		bloqueado = false;
		this.iniciarJuego();
	}
	
	public void botonProbar(int nro)
	{
		if(!bloqueado)
		{
			try
			{
				this.probar(nro);
			} catch (NroInvalidoException e)
			{
				System.out.println(e.getMessage());
			} catch (NuevoJuegoException e)
			{
				System.out.println(e.getMessage());
			}
			if(this.traerEstado().equals("perdio"))
				bloqueado = true;
		}
	}
	
	public void campoNro()
	{
		if(!bloqueado) 
		{
			int numeroDePrueba = 4;
			this.botonProbar(numeroDePrueba);
		}
	}
	
	public void nroIntentos()
	{
		if(!bloqueado)
			System.out.println(this.traerIntentos());
	}
	
	public void estado()
	{
		if(!bloqueado)
			System.out.println(this.traerEstado());
	}
	
	/**
	 * Metodo que invoca a otro metodo de la clase Monitor para dar comienzo al juego
	 */
	private void iniciarJuego()
	{
		this.mon.iniciarJuego();
	}
	
	/**
	 * @param nro numero entero ingresado por el usuario para jugar
	 * @throws NroInvalidoException excepcion lanzada cuando el parametro nro no se encuentra en [1 ; 100]
	 * @throws NuevoJuegoException excepcion lanzada cuando el atributo estado es "acerto" o "perdio", indicando que se debe iniciar un juego nuevo
	 */
	private void probar(int nro) throws NroInvalidoException, NuevoJuegoException
	{	
		this.mon.probar(nro);	
	}
	
	/**
	 * @return Cantidad de intentos restantes del juego actual.
	 */
	private int traerIntentos()
	{
		return mon.traerIntentos();
		
	}
	
	/**
	 * @return El estado de la ultima prueba.
	 */
	private String traerEstado()
	{
		return mon.traerEstado();
	}
}
