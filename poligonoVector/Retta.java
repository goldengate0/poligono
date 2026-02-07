/* Classe per descrivere una retta in forma esplicita rispetto y, dati due punti. 
 * caratteristiche:
 * 
 * - attributo per i due punti, il coeffAng e per il termine noto e
 *  uno per controllare se la retta è verticale
 * - metodo per verificare se un punto è soluzione dell'equazione
 * - metodo per stampare l'equazione dela retta
 * */

package poligonoVector;

public class Retta {
	private Punto p1, p2;
	private double coeffAng, termNoto;
	private boolean verticale, orizzontale;
	
	
	//costruttore
	public Retta(Punto p1, Punto p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		
		if (p1.getX() == p2.getX())
		{
			verticale = true;
		}
		else if (p1.getY() == p2.getY())
		{
			orizzontale = true;
		}
		else
		{
			verticale = false;
			orizzontale = false;
			coeffAng = (p2.getY() - p1.getY())/(p2.getX() - p1.getX());
			termNoto = p1.getY() - (coeffAng * p1.getX());
		}
	}
	
	
	public Punto getP1() {
		return p1;
	}

	public Punto getP2() {
		return p2;
	}

	public double getCoeffAng() {
		return coeffAng;
	}

	public double getTermNoto() {
		return termNoto;
	}
	
	public boolean getVerticale()
	{
		return verticale;
	}
	
	public boolean getOrizzontale()
	{
		return orizzontale;
	}
	
	public boolean checkSoluzione(Punto p3)
	{
		if (verticale)
		{
			return p1.getX() == p3.getX();
		}
		if (orizzontale)
		{
			return p1.getY() == p3.getY();
		}
		return Math.abs((coeffAng * p3.getX()) - p3.getY() + termNoto) < 0.0001;
	}
	
	@Override
	public String toString()
	{
		return "y = " + coeffAng + "x" + "+ " + termNoto;
	}
}
