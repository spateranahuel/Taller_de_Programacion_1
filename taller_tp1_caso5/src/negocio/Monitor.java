package negocio;

import excepciones.NroInvalidoException;
import excepciones.NuevoJuegoException;
import modelo.Juego;
import ui.Interfaz;

public class Monitor
{
	private Juego jogo;
	private Interfaz interfaz;
	
	public Monitor()
	{
		this.jogo = new Juego();
		this.interfaz = new Interfaz(this);
	}
		
	/**
	 * Metodo que invoca al metodo iniciarJuego de la clase Juego para iniciar una nueva partida.
	 */
	public void iniciarJuego()
	{
		this.jogo.iniciarJuego();
	}
	
	/**
	 * Metodo que invoca a otro metodo de la clase Juego que se encarga de comprobar si el numero ingresado coincide con el generado 
	 * aleatoriamente por el programa.
	 * @param nro numero entero recibido de la interfaz de usuario
	 * @throws NroInvalidoException excepcion lanzada cuando el parametro nro no se encuentra en [1 ; 100]
	 * @throws NuevoJuegoException excepcion lanzada cuando el atributo estado es "acerto" o "perdio", indicando que se debe iniciar un juego nuevo
	 */
	public void probar(int nro) throws NroInvalidoException, NuevoJuegoException
	{
		this.jogo.probar(nro);
	}
	
	/**
	 * @return Cantidad de intentos restantes del juego actual.
	 */
	public int traerIntentos()
	{
		return jogo.traerIntentos();
	}
	
	/**
	 * @return El estado de la ultima prueba.
	 */
	public String traerEstado()
	{
		return jogo.traerEstado();
	}
}
