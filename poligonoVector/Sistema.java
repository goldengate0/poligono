/* classe per descrivere un sistema:
 * - come attributi ha le due equazioni
 * - come metodi controlla se il sistema è determinato, 
 * 	 impossibile, indeterminato*/
package poligonoVector;

public class Sistema {
	private Retta r1;
	private Retta r2;
	
	public Sistema(Retta r1, Retta r2)
	{
		this.r1 = r1;
		this.r2 = r2;
	}
	
	
	public Retta getR1() {
		return r1;
	}

	public Retta getR2() {
		return r2;
	} 


	public boolean determinato()
	{
		final double QUOZIENTE_Y = 1;
		return (-r1.getCoeffAng()/-r2.getCoeffAng()) != QUOZIENTE_Y;
	}
	
	public boolean impossibile()
	{
		final double QUOZIENTE_Y = 1;
		return ((-r1.getCoeffAng()/-r2.getCoeffAng()) == QUOZIENTE_Y) && (-r1.getTermNoto() / -r2.getTermNoto() != QUOZIENTE_Y);
	}
	
	public boolean indeterminato()
	{
		final double QUOZIENTE_Y = 1;
		return ((-r1.getCoeffAng()/-r2.getCoeffAng()) == QUOZIENTE_Y) && (-r1.getTermNoto() / -r2.getTermNoto() == QUOZIENTE_Y);
	}
}
