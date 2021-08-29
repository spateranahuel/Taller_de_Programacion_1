package modelo;

import java.util.ArrayList;

public class BeerHouse
{
	private static BeerHouse Instance;
	private int cantProductos;
	private int cantMesas;
	private static int totalMesas = 25;
	private ArrayList<Mesa> Mesas = new ArrayList<Mesa>();	
	private boolean abierto = false;
	
	public static BeerHouse getInstance()
	{
		if(BeerHouse.Instance == null)
			BeerHouse.Instance = new BeerHouse();
		return BeerHouse.Instance;
	}
	
	public BeerHouse()
	{
		for(int i = 0;i<totalMesas;i++)
			Mesas.add(new Mesa());
	}
	
	/**
	 * <b>PRE:</b> parametro cantMesas debe ser >= 1, el atributo abierto debe ser false <br>
	 * <b>POST:</b> La cantidad de mesas pasadas por parametro estaran habilitadas y desocupadas para su uso durante la jornada,
	 * la cantidad de productos disponibles sera >= 1 y se actualizara la carta dependiendo estos productos. <br>
	 * Metodo que inicializa el estado de todos los atributos del local al inicio de la jornada.
	 * @param cantMesas parametro que indica la cantidad de mesas ques estaran diponibles
	 */
	public void abrirLocal(int cantMesas)
	{
		assert cantMesas >= 1: "La cantidad de mesas debe ser mayor o igual a 1.";
		assert abierto != true: "El bar ya esta abierto";
		//se invoca un metodo que inicializa y carga el arraylist de mesas y les setea a todas el estado 'L' referenciando que están libres
		if(cantMesas>totalMesas)
			this.cantMesas = totalMesas;
		else
			this.cantMesas = cantMesas;
		this.cantProductos = 20;
		this.abierto = true;
	}
	
	/**
	 * <b>PRE:</b> Parametro nroMesa debe ser >= 1 y <= cantMesas, que el estado de la mesa sea 'L' y que
	 *  el local debe estar abierto <br>
	 * <b>POST:</b> Retorna la instancia de mesa distinta de null de la lista de mesas que tiene el nroMesa indicado en el
	 * parámetro y setea el estado de la mesa solicitada en 'O' <br>
	 * Metodo que retorna una mesa en especifico solicitada por parametro y ocupa esta misma mesa
	 * @param nroMesa parametro que indica el nro de mesa solicidada por el usuario
	 */
	public Mesa ocuparMesa(int nroMesa)
	{
		assert (nroMesa >=1 && nroMesa <= this.cantMesas) : "nro de mesa invalido";
		assert invariante(nroMesa): "mesa no inicializada";
		assert this.Mesas.get(nroMesa).getEstado() == 'L': "La mesa esta ocupada";
		this.Mesas.get(nroMesa).setEstado('O');
		return this.Mesas.get(nroMesa);
	}
	
	/**
	 * <b>PRE:</b> Parametro nroMesa debe ser >= 1 y <= cantMesas, que el estado de la mesa sea 'O' y que
	 *  el local debe estar abierto <br>
	 * <b>POST:</b> Retorna el importe a pagar de la mesa especificada por el parametro nroMesa y setea el 
	 * estado de la mesa solicitada en 'L' <br>
	 * Metodo que calcula y retorna el importe total consumido de la mesa indicada como parámetro y libera esta misma mesa.
	 * @param nroMesa parametro que indica el nro de mesa solicidada por el usuario
	 */
	public double cerrarMesa(int nroMesa)
	{
		assert (nroMesa >=1 && nroMesa <= this.cantMesas) : "nro de mesa invalido";
		assert invariante(nroMesa): "mesa no inicializada";
		assert this.Mesas.get(nroMesa).getEstado() == 'O': "La mesa esta ocupada";
		double costo = 0;
		//calculo del dinero gastado en la mesa
		return costo;
	}
	
	private boolean invariante(int nroMesa)
	{
		return this.Mesas.get(nroMesa) != null;
	}
	
	public boolean getAbierto()
	{
		return this.abierto;
	}

	public int getCantMesas()
	{
		return cantMesas;
	}

	public ArrayList<Mesa> getMesas()
	{
		return Mesas;
	}
	
	
}
