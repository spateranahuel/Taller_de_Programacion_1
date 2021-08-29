package interfaz;

import excepciones.BarCerradoException;
import excepciones.BarYaAbiertoException;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupadaException;
import excepciones.cantidadDeMesasInvalidaException;
import modelo.Mesa;
import negocio.Negocio;

/**
 * @author usuario
 *
 */
public class InterfazDeUsuario
{
	private Negocio capaDeNegocio;
	
	
	public void abrirLocal()
	{
		int cantMesas = 0;
		//recibe el valor ingresado por el usuario para la variable cantMesas
		try
		{
			capaDeNegocio.abrirLocal(cantMesas);
		} catch (cantidadDeMesasInvalidaException e)
		{
			System.out.println(e.getMensaje()); //el mensaje deberia mostrarse en la interfaz de ususario
		} catch (BarYaAbiertoException e)
		{
			System.out.println(e.getMensaje()); //el mensaje deberia mostrarse en la interfaz de ususario
		}
	}
	
	public Mesa ocuparMesa()
	{
		int NroMesa = 0;
		Mesa aux = null;
		//recibe el valor ingresado por el usuario para la variable NroMesa
		try
		{
			aux = capaDeNegocio.ocuparMesa(NroMesa);
		} catch (cantidadDeMesasInvalidaException e)
		{
			System.out.println(e.getMensaje()); 
		} catch (MesaOcupadaException e)
		{
			System.out.println(e.getMensaje()); 
		} catch (BarCerradoException e)
		{
			System.out.println(e.getMensaje()); 
		}
		return aux;
	}
	
	
	public double cerrarMesa()
	{
		int NroMesa = 0;
		double costo = 0;
		//recibe el valor ingresado por el usuario para la variable NroMesa
		
		try
		{
			costo = capaDeNegocio.cerrarMesa(NroMesa);
		} catch (cantidadDeMesasInvalidaException e)
		{
			System.out.println(e.getMensaje());
		} catch (MesaNoOcupadaException e)
		{
			System.out.println(e.getMensaje());
		} catch (BarCerradoException e)
		{
			System.out.println(e.getMensaje());
		}
		return costo;
	}
	
}
