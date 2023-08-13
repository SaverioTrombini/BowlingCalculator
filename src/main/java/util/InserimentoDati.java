package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InserimentoDati {
	private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non e' nel formato corretto";
	private final static String ERRORE_MINIMO = "Attenzione: e' richiesto un valore maggiore o uguale a ";
	private final static String ERRORE_MASSIMO = "Attenzione: e' richiesto un valore minore o uguale a ";
	
	private static Scanner lettore = creaScanner();
	
	private static Scanner creaScanner() {
		Scanner creato = new Scanner(System.in);
		creato.useDelimiter(System.getProperty("line.separator"));
		return creato;
	}
	
	public static int leggiIntero(String messaggio) {
		boolean finito = false;
		int valoreLetto = 0;
		do {
			System.out.print(messaggio);
			try {
				valoreLetto = lettore.nextInt();
				finito = true;
			} catch (InputMismatchException e) {
				System.out.println(ERRORE_FORMATO);
				@SuppressWarnings("unused")
				String daButtare = lettore.next();
			}
		} while (!finito);
		return valoreLetto;
	}
	
	public static int leggiIntero(String messaggio, int minimo, int massimo) {
		boolean finito = false;
		int valoreLetto = 0;
		do {
			valoreLetto = leggiIntero(messaggio);
			if (valoreLetto >= minimo && valoreLetto <= massimo)
				finito = true;
			else if (valoreLetto < minimo)
				System.out.println(ERRORE_MINIMO + minimo);
			else
				System.out.println(ERRORE_MASSIMO + massimo);
		} while (!finito);

		return valoreLetto;
	}
	
	public static int richiestaValorePrimoTiro() {
		int tiro = leggiIntero("Quanti birilli sono caduti nel primo tiro? ", 0, 10);
		return tiro;
	}

	public static int richiestaValoreSecondoTiro() {
		int tiro = leggiIntero("Quanti birilli sono caduti nel secondo tiro? ", 0, 10);
		return tiro;
	}
}