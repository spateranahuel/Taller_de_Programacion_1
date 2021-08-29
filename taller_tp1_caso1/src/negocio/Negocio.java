package negocio;

import excepciones.BarCerradoException;
import excepciones.BarYaAbiertoException;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupadaException;
import excepciones.cantidadDeMesasInvalidaException;
import interfaz.InterfazDeUsuario;
import modelo.BeerHouse;
import modelo.Mesa;

public class Negocio
{
	private InterfazDeUsuario UI;
	
	public Negocio(InterfazDeUsuario UI)
	{
		this.UI = UI;
	}
	
	public void abrirLocal(int cantMesas) throws cantidadDeMesasInvalidaException, BarYaAbiertoException
	{
		if(cantMesas < 1)
			throw new cantidadDeMesasInvalidaException();
		if(BeerHouse.getInstance().getAbierto())
			throw new BarYaAbiertoException();
		
		BeerHouse.getInstance().abrirLocal(cantMesas);
	}
	
	public Mesa ocuparMesa(int nroMesa) throws cantidadDeMesasInvalidaException, MesaOcupadaException, BarCerradoException
	{
		if((nroMesa >=1 && nroMesa <= BeerHouse.getInstance().getCantMesas()))
			throw new cantidadDeMesasInvalidaException();
		if(BeerHouse.getInstance().getMesas().get(nroMesa).getEstado() != 'L')
			throw new MesaOcupadaException();
		if(!BeerHouse.getInstance().getAbierto())
			throw new BarCerradoException();
		return BeerHouse.getInstance().ocuparMesa(nroMesa);
	}
	
	public double cerrarMesa(int nroMesa) throws cantidadDeMesasInvalidaException, MesaNoOcupadaException, BarCerradoException
	{
		if((nroMesa >=1 && nroMesa <= BeerHouse.getInstance().getCantMesas()))
			throw new cantidadDeMesasInvalidaException();
		if(BeerHouse.getInstance().getMesas().get(nroMesa).getEstado() != 'O')
			throw new MesaNoOcupadaException();
		if(!BeerHouse.getInstance().getAbierto())
			throw new BarCerradoException();
		
		return BeerHouse.getInstance().cerrarMesa(nroMesa);
	}
}
