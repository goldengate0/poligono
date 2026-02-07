//task: dichiarare un poligono, inserire i vertici e infine stampare ogni vertice

package poligonoVector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PoligonoProg {
	
	//metodo per chiedere all'utente l'operazione da eseguire
	private static char chiediOp()
	{
		//creo il canale di input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tas = new BufferedReader(input);
		
		//variabile per salvare la risposta dell'utente
		char r = ' ';
		
		//chiedo quale operazione vuole fare l'utente
		do
		{
			System.out.println("quale operazione vuoi eseguire? (i = inserisci, e = elimina, t = termina programma)");
			try 
			{
				//per convertire da String a char, prendo il carattere nella posizione 0 della stringa .charat(index)
				r = tas.readLine().charAt(0);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		while (r != 'i' && r != 'e' && r != 't');
		
		return r;
	}
	
	public static void main(String[] args) {
		//creo il canale di input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tas = new BufferedReader(input);
		//dichiaro e alloco un Poligono
		Poligono p1 = new Poligono();
		//variabile per la risposta dell'utente, inizializzo all'operazione di inserimento
		char r = 'i';
		//variabili per salvare x y
		int x = 0, y = 0; 
			
		//ciclo per chiedere all'utente quale operazione vuole fare (i == inserisci; e == elimina)
		while (r == 'i' || r == 'e')
		{
			//al primo ciclo, l'utente ha solo la possibilità di inserire
			//in base al valore, eseguo un operazione
			switch (r)
			{
				case 'i':
					//chiedo all'utente l'ascissa
					System.out.print("Inserisci l'ascissa: ");
					try
					{
						x = Integer.valueOf(tas.readLine()).intValue();
					}
					catch (Exception e) {}
					
					//chiedo all'utente l'ordinata
					System.out.print("Inserisci l'ordinata: ");
					try
					{
						y = Integer.valueOf(tas.readLine()).intValue();
					}
					catch (Exception e) {}
					
					p1.inserisciPunto(new Punto(x, y));
					break;
					
				case 'e':
					//chiedo all'utente l'ascissa
					System.out.print("Inserisci l'ascissa da eliminare: ");
					try
					{
						x = Integer.valueOf(tas.readLine()).intValue();
					}
					catch (Exception e) {}
					
					//chiedo all'utente l'ordinata
					System.out.print("Inserisci l'ordinata da eliminare: ");
					try
					{
						y = Integer.valueOf(tas.readLine()).intValue();
					}
					catch (Exception e) {}
					
					p1.eliminaPunto(new Punto(x, y));
					break;
			}
			//chiedo all'utente quale operazione vuole eseguire
			r = chiediOp();
		}
		//prima del termine del programma, stampo tutti i punti
		p1.stampaVertici();
		
		if (p1.controlloPoligono())
		{
			System.out.println("Poligono chiuso.");
		}
	}
}
