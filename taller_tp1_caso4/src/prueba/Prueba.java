package prueba;

import negocio.Monitor;
import ui.InterfazDeUsuario;

public class Prueba
{

	public static void main(String[] args)
	{
		Monitor mon = new Monitor();
		InterfazDeUsuario inter = mon.getInterfaz();
		
		System.out.println(inter.calcular());
		
		
	}

}
