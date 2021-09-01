package modelo;

import java.util.Random;

import excepciones.NroInvalidoException;
import excepciones.NuevoJuegoException;

public class Juego
{
	private int intentos = 0;
	private int nroAleatorio;
	private static Random r = new Random();
	private String estado;
	
	/**
	 * <b>POST:</b> Se genera y almacena un numero aleatorio entre 1 y 100, y se setea el numero de intentos en 10 <br>
	 * Metodo que inicializa la cantidad de intentos en 100 y genera un numero aleatorio en [1 ; 100], dejando asi el juego listo
	 * para iniciar su ejecucion.
	 */
	public void iniciarJuego()
	{
		this.nroAleatorio = r.nextInt(100) + 1;
		this.intentos = 10;
		this.estado = "juego recien iniciado";
		assert this.intentos == 10: "La cantidad de intentos no se inicializo correctamente";
		assert this.nroAleatorio >= 1 && this.nroAleatorio <= 100 : "El numero generado no se encuentra en el intervalo [1 ; 100]";
	}
	
	/**
	 * <b>PRE:</b> el numero de intentos debe ser mayor que cero <br>
	 * Metodo que verifica si el numero ingresado coincide con el generado aleatoriamente, verificando que se cumpla que el numero pertenezca
	 * al intervalo [1 ; 100] y que el estado anterior no sea "acerto" ni "perdio". Modifica el valor del atributo estado dependiendo de si
	 * se atino el numero correcto o no.
	 * @param nro numero entero recibido del monitor
	 * @throws NroInvalidoException excepcion lanzada cuando el parametro nro no se encuentra en [1 ; 100]
	 * @throws NuevoJuegoException excepcion lanzada cuando el atributo estado es "acerto" o "perdio", indicando que se debe iniciar un juego nuevo
	 */
	public void probar(int nro) throws NroInvalidoException, NuevoJuegoException
	{
		assert this.intentos > 0: "No quedan intentos disponibles en el juego actual";
		if(nro < 0 || nro > 100)
			throw new NroInvalidoException("El numero ingresado debe estar en el intervalo [1 ; 100].");
		if(this.estado.equals("acerto") || this.estado.equals("perdio"))
			throw new NuevoJuegoException("Se debe iniciar un juego nuevo para continuar.");
		this.intentos--;
		if(nro == this.nroAleatorio)
			this.estado = "acerto";
		else if(intentos == 0)
			this.estado = "perdio";
		else if(nro < this.nroAleatorio)
			this.estado = "bajo";
		else 
			this.estado = "alto";
	}
	
	/**
	 * @return Retorna la cantidad de intentos restantes
	 */
	public int traerIntentos()
	{
		return this.intentos;
	}
	
	/**
	 * @return Retorna el estado de la ultima prueba efectuada
	 */
	public String traerEstado()
	{
		return this.estado;
	}
	
	
}
