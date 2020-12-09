# MergeSort-MultiThreadJava



A.	Procédure concise et claire de compilation et d’exécution de votre programme. 
Pour réaliser ce devoir, nous avons eu recours à l’algorithme de tri par fusion parallèle.
I.	Explication de l’algorithme de tri par fusion parallèle
Le tri par fusion est l'un des algorithmes de tri qui convient au parallélisme. Nous présentons ci-dessous les étapes d'un algorithme général de tri par fusion parallèle:
1.	Divisez les éléments à trier en nombre de cœurs dans le système
2.	Chaque noyau trie son sous-tableau (sousListe dans le cadre de ce devoir) attribué indépendamment. (Ils peuvent utiliser n'importe quel algorithme de tri séquentiel)
3.	Un thread fusionne deux sousListes triés consécutifs (s'il y a N cœurs dans le système, il y a N blocs triés. N / 2 threads effectuent des opérations de fusion à cette étape. L'autre moitié des cœurs du système n'est pas utilisée sur cette étape)
4.	Encore une fois, un thread fusionne deux blocs triés. (Comme il y a N / 2 blocs triés à cette itération, N / 4 threads participent à la fusion. Par conséquent, 3/4 des cœurs restent inactifs.)
5.	L’opération de fusion continue comme ceci. À chaque itération, le nombre de blocs triés est réduit de moitié. Dans la dernière itération, deux blocs triés sont fusionnés et un ensemble d'éléments triés est obtenu.
L'algorithme de tri par fusion parallèle peut être implémenté à la fois de manière récursive et itérative. La bibliothèque Java a deux frameworks de synchronisation de threads qui aident à implémenter le tri de fusion parallèle:
Un thread fourche d'autres threads et attend leur achèvement. Les threads fourchus peuvent également créer de nouveaux threads et créer de manière récursive un arbre de threads.


B.	Un tableau de temps d’exécution du programme sur une machine multi-processeurs 

1. NLISTS	Machine locale Avec INTEL I5
processeur(s) ; Système 
d’exploitation 
2. ……… 	Machine locale Avec AMD12
processeurs ; Système 
d’exploitation 
3. ……… 	Machine 
virtuelle avec 
INTEL I5
Processeur(s), Système 
d’exploitation 
4. ……… 	Machine 
virtuelle avec 
AMD12
Processeurs ; Système 
d’exploitation 
……… 
1 	 23 ms	  8 ms	  9 ms	  16ms
2 	  24ms	  9 ms	  11 ms	  17 ms
3 	  25 ms	  10 ms	  12 ms	 18 ms
4 	  25 ms	  11 ms	 13 ms	  18 ms
Interprétation et comparaison	Voir paragraphe no. 
…. 	Voir paragraphe no. 
…. 	Voir paragraphe no. 
…. 	Voir paragraphe no. 
…. 
Concises				
 
L’exécution du programme sur la machine réelle permet d’optimiser le temps d’exécution par rapport à la machine virtuelle. Car la machine virtuelle dépend en grande partie de la performance de la ressource locale. 
