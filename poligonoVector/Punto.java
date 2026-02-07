/* classe per descrivere ogni vertice:
 * 
 * la classe verrà utilizzata per inserire in ogni indice un oggetto di classe Punto:
 * - attributi privati x y
 * - setter e getter
 * - metodo per stampare le coordinate
 * */
package poligonoVector;

public class Punto {
	//Attributi per x y
	private int x, y;
	
	//costruttore
	public Punto(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//metodo get X
	public int getX()
	{
		return x;
	}
	
	//metodo get Y
	public int getY()
	{
		return y;
	}
	
	//metodo per restituire la stringa contenente le coordinate
	 @Override
	public String toString()
	{
		return "x = " + x + " | y = " + y;
	}
	
	//override del metodo equals e del metodo hashCode, per confrontare oggetti di tipo Punto con p1.equals(p2)
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null ||getClass() != o.getClass()) return false;
		
		Punto p = (Punto) o;
		return x == p.x && y == p.y;
	}
	
	@Override
	public int hashCode()
	{
		return 31 * x + y;
	}
}
