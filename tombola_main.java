package main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class tombola_main {
	//DESCRIZIONE
	//Programma che simula il gioco della tombola tra n-giocatori e stampa il vincitore.
	//
	//Al fine di rendere il programma efficiente, ho scelto di regolare le estrazioni 
	//in base all'ordinamento di 90 numeri generati casualmente: ciascuna cella dell'array 
	//(che è il (numero estratto -1)) viene riempita con un numero casuale intero.
	//Così facendo, non ho bisogno di controllare che venga pescato lo stesso numero due volte, 
	//dato che la probabilità che in 90 richieste, 'Random()' generi due numeri uguali interi 
	//è infinitesima. 
	//
	//Il programma richiede da 'input' il solo numero di giocatori e come 'output' informa l'utente 
	//del vincitore, dei numeri che lo hanno fatto vincere, del numero di estrazioni avvenute 
	//e della quantità di numeri che servivano ai giocatori perdenti per fare tombola.
	
	public static int[][] crea(int n){
		int[][] players;
		players = new int [n][15]; // n players con 10 numeri ognuno
		
		for(int i=0;i<n;i++) { //player x player
			//n players, ognuno con 10 numeri da 1 a 90
			
			//creazione cartelle giocatori
			for(int j=0;j<15;j++) {
				Random random = new Random();
				int rand = (random.nextInt(90)+1);
				players[i][j] = rand;
			}
		}
		return players;
	}
	
	
	public static void stampa(int[][] players, int n) {
		for(int i=0;i<n;i++) {
			int x=i+1;
			System.out.println("Player : "+x+"  - "+Arrays.toString(players[i])+"");
		}
	}
	
	public static int[] crea_counter(int n) {
		int[] counter;
		counter = new int[n];
		//inizializzo tutti gli n elementi a 0
		for(int i=0;i<n;i++) {
			counter[i]=0;
		}
		return counter;
	}
	
	public static void stampa_punteggi(int[] counter, int n) {
		for(int i=0;i<n;i++) {
			int x=i+1;
			System.out.println("Player : "+x+"  - "+counter[i]);
		}
	}
	
	public static int[] crea_tombola() {
		int[] tombola_tabella;
		tombola_tabella = new int[90];
		//array di 90 elementi
		for(int i=0;i<90;i++) {
			int x=i+1;
			tombola_tabella[i]=x;
		}
		return tombola_tabella;
	}
	
	public static void main(String[] args) {
		System.out.println("*TOMBOLA*");
		//chiedo quanti giocatori giocano
		int n=0;
		do {System.out.println("Quanti giocano?");
			Scanner scanner = new Scanner(System.in);
			n=scanner.nextInt(); //in valore assoluto
			if(n>10) { //se non soddisfa n compreso tra 1 e 10
				System.out.println("Massimo 10 giocatori, minimo 1. riprova\n");
			}
		}while(n>10);
		
		//ho n giocatori
		
		//li creo
		int[][] players = crea(n);
		//stampo le tabelline
		stampa(players,n);
		
		//costruisco l'array counter, ogni elemento relativo al player in ordine,
		//che si incrementa ogni volta che esca un numero
		int[] counter = crea_counter(n);
		
		//stampo il punteggio (counter)
		System.out.println("\n--------------------\nInizia la partita. Punteggio:\n");
		stampa_punteggi(counter, n);
		
		//costruisco la tombola
		
		int[] tombola_tabella;
		tombola_tabella = crea_tombola();
		
		//ho riempito la tabella
		
		//adesso devo estrarre i numeri
		
		boolean flag = true; //sempre finquando non vince qualcuno
		while(flag) {
			//adesso devo estrarre, fino a quando non vince qualcuno (flag = false), 
			//un numero per ciclo dall'array
			Random random = new Random();
			int index = random.nextInt(91)+1;
			
			//index è il valore che è uscito.
			//devo controllare, per ogni player, se lo ha nella tabellina
			
			for(int i=0;i<n;i++) {
				//scorro i player
				for(int j=0;j<15;j++) {
					//scorro la tabellina
					if(players[i][j] == index) {
						counter[i]++;
						break; //passo al giocatore successivo
					}
					
				}
			}
			//fine for controllo per il numero uscito
			
			System.out.println("\n\nE' uscito il numero { "+index+"\nPunteggio players:\n");
			stampa_punteggi(counter, n);			//controllo counter
			
			for(int i=0;i<n;i++) {
				if(counter[i] == 15) {
					flag=false;
					int x=i+1;
					System.out.println("\n---> ******** Il player "+x+ " ha fatto Tombola!\n");
					for(int k=0;k<n;k++) {
						
						int y=k+1;
						int punti_mancati=0;
						punti_mancati=15-counter[k];
						if(punti_mancati==0) {//nothing}
						}else{System.out.println("\nIl player "+y+" non ha vinto per "+ punti_mancati);}
					}
				}
			}
		}
	}
}
