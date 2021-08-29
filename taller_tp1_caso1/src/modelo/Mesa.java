/**
 * 
 */
package modelo;

/**
 * @author usuario
 *
 */
public class Mesa
{
	private char estado;

	public Mesa()
	{
		this.setEstado('L');
	}
	
	public char getEstado()
	{
		return estado;
	}

	public void setEstado(char estado)
	{
		this.estado = estado;
	}
	
}
