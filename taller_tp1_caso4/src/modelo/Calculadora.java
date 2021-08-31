package modelo;

import excepciones.OperacionImposibleException;

/**
 * Clase que posee dos metodos (calcular y traerResultado). Calculadora para números enteros positivos, cuyos resultados también 
 * son enteros positivos y se consideran unicamente la suma (+), la resta (-), la división (/) y la multiplicación (*).
 */
public class Calculadora
{
	private int ultimaOperacion = 0;
	private boolean huboPrimerOperacion = false;
	/**
	 * <b>PRE:</b> El primer y segundo operando deben ser enteros mayores a cero y la operacion solicitada debe ser alguna de las
	 * validas (suma, resta, multiplicacion y/o division).<br>
	 * <b>POST:</b> Se retornara el valor obtenido de realizar la operacion especificada entre los dos operandos, el parametro
	 * ultimaOperacion pasará a tomar el valor del resultado, el resultado debe ser mayor o igual a cero y el parametro
	 * huboPrimerResultado pasara a ser true en caso de que sea la primer operacion efectuada <br>
	 * Metodo que realiza una operacion determinada entre los dos operandos (toda esta informacion es pasada por parametro) 
	 * @param PrimerOperando numero entero mayor a cero que cumple el rol de primer operando en la operacion
	 * @param SegundoOperando numero entero mayor a cero que cumple el rol de segundo operando en la operacion
	 * @param Operacion string que contiene el tipo de operacion que se quiere realizar
	 * @return resultado de la operacion solicitada entre ambos operandos
	 * @throws OperacionImposibleException
	 */
	public int calcular(int PrimerOperando, int SegundoOperando, String Operacion) throws OperacionImposibleException
	{
		int resultado = 0;
		assert PrimerOperando > 0: "El primer operando debe ser mayor a cero";
		assert SegundoOperando > 0: "El segundo operando debe ser mayor a cero";
		assert Operacion.equals("suma") || Operacion.equals("resta") || Operacion.equals("multiplicacion") || Operacion.equals("division") : "La operacion no es valida";
		
		if(Operacion.equals("division") && SegundoOperando == 0)
			throw new OperacionImposibleException("La division por cero no esta definida");
		
		//calculo de la operacion solicitada
		
		assert resultado > 0: "El resultado de la operacion no es mayor que cero";
		ultimaOperacion = resultado;
		if(!huboPrimerOperacion)
			huboPrimerOperacion = true;
		assert ultimaOperacion == resultado: "No se almacena el resutado de la ultia operacion";
		return resultado;
	}
	
	/**
	 * <b>PRE:</b> El parametro huboPrimerOperacion debe ser true (indicando que ya hubo una operacion previa a invocar este metodo). <br>
	 * Metodo que devuelve el resultado de la ultima operacion existosa
	 * @return resultado de la ultima operacion efectuada
	 */
	public int traerResultado()
	{
		assert huboPrimerOperacion == true: "No hubo una operacion previa";
		return this.ultimaOperacion;
	}
	
}
