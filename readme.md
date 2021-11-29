DESCRIZIONE
Programma che simula il gioco della tombola tra n-giocatori e stampa il vincitore.

Al fine di rendere il programma efficiente, ho scelto di regolare le estrazioni in base all'ordinamento di 90 numeri generati casualmente: ciascuna cella dell'array 
(che è il (numero estratto -1)) viene riempita con un numero casuale intero.
Così facendo, non ho bisogno di controllare che venga pescato lo stesso numero due volte, dato che la probabilità che in 90 richieste, 'Random()' generi due numeri uguali interi 
è infinitesima. 

Il programma richiede da 'input' il solo numero di giocatori e come 'output' informa l'utente del vincitore, dei numeri che lo hanno fatto vincere, del numero di estrazioni avvenute 
e della quantità di numeri che servivano ai giocatori perdenti per fare tombola.
	
