package negocio;

import excepciones.OperacionImposibleException;
import modelo.Calculadora;
import ui.InterfazDeUsuario;

public class Monitor
{
	private Calculadora calc;
	private InterfazDeUsuario interfaz;
	
	public Monitor()
	{
		this.calc = new Calculadora();
		this.interfaz = new InterfazDeUsuario(this);
	}
	
	/**
	 * Metodo que invoca a un metodo de la clase calculadora para realizar una operacion determinada entre los dos 
	 * operandos (toda esta informacion es pasada por parametro) 
	 * @param PrimerOperando numero entero mayor a cero que cumple el rol de primer operando en la operacion
	 * @param SegundoOperando numero entero mayor a cero que cumple el rol de segundo operando en la operacion
	 * @param Operacion string que contiene el tipo de operacion que se quiere realizar
	 * @return resultado de la operacion solicitada entre ambos operandos
	 * @throws OperacionImposibleException
	 */
	public int calcular(int PrimerOperando, int SegundoOperando, String Operacion) throws OperacionImposibleException
	{
		int resultado = 0;
		resultado = this.calc.calcular(PrimerOperando, SegundoOperando, Operacion);
		return resultado;
	}
	
	/**
	 * Metodo que devuelve el resultado de la ultima operacion existosa
	 * @return resultado de la ultima operacion efectuada
	 */
	public int traerResultado()
	{
		return this.calc.traerResultado();
	}
	
	public InterfazDeUsuario getInterfaz()
	{
		return this.interfaz;
	}
	
}
