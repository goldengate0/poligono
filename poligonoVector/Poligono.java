/* La classe deve gestire la registrazione dei dati relativi ad un poligono,
 * di cui non si conosce a priori il numero di vertici:
 * - metodo per aggiungere un vertice
 * - metodo per eliminare un vertice
 * - metodo per stampare ogni vertice
 * - metodo per restituire il numero di vertici
 * - metodo per controllare se i punti inseriti formano effettivamente un poligono
 * 
 *  Mi piacerebbe creare un programma che inserite tutte le caratteristiche
 *  di un poligono, mi restituisca il nome (se è conosciuto, triangolo, rettangolo, rombo) oppure indicare la tipologia del poligono. Magari con un immagine dimostrativa.
 *  
 * 
 * Inoltre, vorrei creare una finestra con Swing per inserire tutti i dati del poligono
 * e restituire il nome del poligono e una sua immagine.
 * 
 * obiettivo finale: creare un sito web che faccia tutto.
 * */

package poligonoVector;

import java.util.*;

public class Poligono {
	//costante per indicare la dimensione iniziale
	final int INIZ = 1;
	//costante per indicare il valore di incremento 
	final int INCR = 1;
	
	/* dichiaro un Vector, che puo accettare solo oggetti di classe Punto, 
	 * per inserire in ogni indice un vertice */
	private Vector<Punto> poligono = new Vector<>(INIZ, INCR);
	
	//metodo per inserire una coordinata nel vettore
	public void inserisciPunto(Punto p)
	{
		poligono.addElement(p);
	}
	
	//metodo per eliminare un punto
	public void eliminaPunto(Punto p)
	{
		poligono.remove(p);
	}
	
	//metodo per stampare ogni vertice
	public void stampaVertici()
	{
		System.out.println("PUNTI REGISTRATI: ");
		//ciclo per stampare i vertici
		for (int i = 0; i < poligono.size(); i++)
		{
			//stampo le coordinate del punto nell'indice i
			System.out.println(poligono.elementAt(i).toString());
		}
	}
	
	//metodo per restituire il numero di vertici
	public int nVertici()
	{
		return poligono.size();
	}
	
	/* metodo per controllare se i punti inseriti formino un poligono:
	 * un poligono è l'insieme di punti di una poligonale CHIUSA e NON INTRECCIATA */
	public boolean controlloPoligono()
	{
		/*controllo che i punti formino una poligonale chiusa e non intrecciata:
		 * 
		 * per verificarlo, controlliamo se sono stati inseriti almeno tre 
		 * punti diversi tra loro e che non appartengano tutti ad una retta.
		 * 
		 * Inoltre, bisogna controllare se il primo e l'ultimo punto sono congruenti.
		 * 
		 * Per controllare se almeno due rette sono incidenti, dobbiamo fare il sistema.
		 *  
		 * Per controllare se almeno tre punti non siano congruenti, 
		 * creo un Vector che mi inserisce il punto se non è stato ancora inserito,
		 * alla fine, controllo la dimensione del Vector, se maggiore di tre, 
		 * posso controllare se si tratta di un poligonale chiuso */
		
		
		//CONTROLLO SE ALMENO TRE PUNTI NON SIANO CONGRUENTI
		//vettore per inserire un punto una sola volta
		Vector<Punto> checkPunti = new Vector<>(INIZ, INCR);
		//Vettore per formare tutte le rette possibili dati i punti
		Vector<Retta> rette = new Vector<>(INIZ, INCR);
		//variabile booleana per controllare se almeno un punto inserito non è appartenente alla stessa retta
		boolean checkRetta = true;
		
		
		//ciclo per controllare tutto il Vector poligono 
		
		/* se il punto in poligono non è dentro checkPunti, lo inserisce.
		 * se il punto in poligono è presente, il ciclo riparte con la nuova iterazione. */
		for (int i = 0; i < poligono.size(); i++)
		{
			if (checkPunti.contains(poligono.elementAt(i)))
			{
				continue;
			}
			//inserisco l'elemento di indice i in poligono, all'interno di checkPunti
			checkPunti.add(new Punto(poligono.elementAt(i).getX(), poligono.elementAt(i).getY()));
		}
		
		//CONTROLLO PUNTI SU RETTA DIFFERENTE
		//CONTROLLO POLIGONALE CHIUSO
		//controllo se il Vector checkPunti sia maggiore di tre
		//se è minore di 3, non è un poligono
		if (checkPunti.size() < 3)
		{
			System.out.println("I punti inseriti sono minori di 3.");
			return false;
		}
		
		//CONTROLLO PUNTI SU RETTA DIFFERENTE
		//dichiaro una retta inserendo due punti
		Retta r1 = new Retta(checkPunti.firstElement(), checkPunti.elementAt(1));
		//controllo che almeno un punto (dei restanti, quindi partendo dall'indice 2), non appartenga alla retta formata dai punti 0 e 1.
		for (int i = 2; i < checkPunti.size(); i++)
		{
			//se il punto non è nella retta, la condizione di if viene verificata (quindi entra nel ciclo)
			if (!r1.checkSoluzione(checkPunti.elementAt(i)))
			{
				checkRetta = false;
				//se almeno uno non appartiene alla retta, esco dal ciclo
				break;
			}
		}
		//se la variabile è ancora impostata a true, significa che tutti i punti appartengono ad una sola retta, quindi NON è una poligono
		if (checkRetta)
		{
			System.out.println("Tutti i punti appartengono ad una sola retta.");
			return false;
		}
		
		//CONTROLLO RETTE INCIDENTI
		//inserisco tutte le rette possibili
		/*  < checkPunti.size(), perche size() restituisce la lunghezza dell'array,
		 * esempio: array formato da indici da 0 a 6, size() restituisce 7,
		 * quindi con il segno < si ferma all'indice 6 (all'ultimo indice). */
		int next;
		for (int i = 0; i < checkPunti.size(); i++)
		{
			next = (i+1) % checkPunti.size();
			rette.add(new Retta(checkPunti.elementAt(i), checkPunti.elementAt(next)));
		}
		
		
		
		//DEVO CONTROLLARE SOLO LE RETTE VALIDE: (non confrontare una retta con se stessa, non controllare i segmenti consecutivi)
		
		
		
		/* dichiaro un sistema con due retta, e controllo se il sistema è determinato, se lo è, 
		 * vuol dire che la figura è intrecciata, restituisco false. */
		Sistema s;
		for (int i = 0; i < rette.size(); i++)
		{			
			for (int j = 0; j < rette.size(); j++)
			{	
				//se le due rette hanno almeno un punto in comune, non sono valide
				if (rette.elementAt(i).getP1().equals(rette.elementAt(j).getP1()) || rette.elementAt(i).getP1().equals(rette.elementAt(j).getP2()) 
					|| rette.elementAt(i).getP2().equals(rette.elementAt(j).getP1()) || rette.elementAt(i).getP2().equals(rette.elementAt(j).getP2()))
				{
					break;
				}
				
				//se entrambe le due rette sono verticali o orizzontali, non possono avere sicuramente un punto in comune
				if ((rette.elementAt(i).getOrizzontale() && rette.elementAt(j).getOrizzontale()) || (rette.elementAt(i).getVerticale() && rette.elementAt(j).getVerticale()))
				{
					break;
				}
				
				
				//se le due rette sono valide, allora creo il sistema
				s = new Sistema(rette.elementAt(i), rette.elementAt(j));
				if (s.determinato())
				{
					System.out.println("Almeno due rette sono incidenti.");
					return false;
				}
			}
		}	
		return true;
	}
}
