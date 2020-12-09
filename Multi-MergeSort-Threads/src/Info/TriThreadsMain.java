package Info;

import java.util.Scanner;
import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;
public class TriThreadsMain{

	static int Nlist ;
	// Le choix de deux modes de l'utilisateur
	public static int FaireChoix() {
		int f;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n******");
		// Lecture du choix des donnees de l'utilisateur
		System.out.println("\n 1/ Mode Manuel (L'entree des donnees au soin de l'utilisateur) \n");

		// Lecture du choix des donnees de la machine
		System.out.println(" 2/ Mode Aleatoire (L'entree des donnees au soin du programme ) \n");

		// Lecture du choix de l'utilisateur
		System.out.print("Faites le choix de votre mode:  ");
		f = sc.nextInt();
		sc.nextLine();
		return f;
	}
	//Ici c'est l'entree au clavier pour l'utilisateur
	public static List<Integer[]> EntreeClavier() {


		List<Integer> testingOriginalList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n******");

// Lecture  des valeurs au clavier

		System.out.print(" \n Veuillez entrer les elements separes de virgule: ");

		String entry = sc.nextLine();

		String[] ch = entry.split(",");


		for (int i = 0; i < ch.length; i++) {
			try {
				testingOriginalList.add(Integer.parseInt(ch[i]));
			} catch (NumberFormatException e) {

			}
		}

		System.out.print("\n \n Entrez La taille des sous liste: ");
		int n = sc.nextInt();

		Integer[] originalArray = testingOriginalList.toArray(new Integer[] {});

		List<Integer[]> listOfArrays = splitArray(originalArray, n);



		System.out.println("\n\n Les threads presents sont:");
		for (Integer[] array : listOfArrays) {
			System.out.print(" Thread " + Nlist + ": ");
			System.out.println(Arrays.toString(array));
			Nlist++;

		}
		return listOfArrays;

	}

		// Lecture des valeurs aleatoire
		public static  List<Integer[]> EntreeAleatoire() {
			int n;
			Scanner sc = new Scanner(System.in);
			System.out.print("\n \n Entrez La taille du tableau: ");
			n = sc.nextInt();
			int [] original = new int[n];
			List<Integer> testingOriginalList = new ArrayList<Integer>();


			// Creation du tableau aleatoire

			System.out.println("\n******");

			for (int i = 0; i < original.length; i++) {
				testingOriginalList.add((int) (Math.floor(Math.random() * original.length) + 1));

			}

			System.out.print("\n \n Entrez La taille des sous liste: ");
			int n1 = sc.nextInt();

			Integer[] originalArray1 = testingOriginalList.toArray(new Integer[] {});

			List<Integer[]> listOfArrays = splitArray(originalArray1, n1);

			System.out.println("\n\n Les threads pr�sents sont:");
			for (Integer[] array : listOfArrays) {
				System.out.print(" Thread " + Nlist + ": ");
				System.out.println(Arrays.toString(array));
				Nlist++;

			}
			return listOfArrays;
		}

		// Procedure en cas de mauvais choix du mode
		public static void MauvaisChoix() {
			System.out.println("\n******");
			System.out.println("\n Choix invalide. Bien vouloir faire le choix entre le 1 et 2. \n");
			System.out.println("\n******");
		}



		// Creation des sous listes
				private static List<Integer[]> splitArray(Integer[] originalArray, int NList) {
					List<Integer[]> listOfArrays = new ArrayList<Integer[]>();
					int tailletotale = originalArray.length;
					if (tailletotale < NList) {
						NList = tailletotale;
					}
					int from = 0;
					int to = NList;

					while (from < tailletotale) {
						Integer[] partArray = Arrays.copyOfRange(originalArray, from, to);
						listOfArrays.add(partArray);

						from += NList;
						to = from + NList;
						if (to > tailletotale) {
							to = tailletotale;
						}
					}
					return listOfArrays;
				}

				public  int getNlist() {

					return (Nlist);
				}
				//Reprise permet de reprendre le program au niveau
				public static char Reprise() {
					Scanner sc = new Scanner(System.in);
					System.out.println("\n***********");
					System.out.print(" Voulez vous ex�cuter � nouveau le programme Y / N :  ");
					char choix = sc.next().charAt(0);
					System.out.println("\n***********");
					return choix;
				}
// Main

@SuppressWarnings("null")
public static void main(String[] args) throws InterruptedException {

	  int f;
	  char choix = 'Y';
	  List<Integer[]> original2= null;
	  List<Integer[]> array;

	  	 @SuppressWarnings("resource")
	  	 // La presentation du notre programme
		Scanner sc = new Scanner(System.in);
	  	System.out.println("\n***  PROGRAMME DE TRI PAR THREAD  ****");
		System.out.println("\n        Etudiants: ");
		System.out.println("\n1- Yannick TOUNDJI");
		System.out.println("\n1- Yaseen CHOUKRI");
		// si l'utlisateur  veut  reprendre le programme
		while (choix == 'Y' ) {

		 f = FaireChoix ();
	     switch (f) {
			case 1:

				 array = EntreeClavier ();
				 // Le temps du thread du tri
				 long startTime =  System.nanoTime() / 1000000; // Temps de d�but
				 List<Integer[]> threadPool = new ArrayList<Integer[]>();

				 for(Integer[] array1 : array)
				 {

					//System.out.println("\n Sous liste retenue: "+Arrays.toString(array1));
					 SortingThread thread = new SortingThread(array1);
					 //le Debut du thread
					 thread.start();
					 threadPool.add(thread.ListOr);
					 //Le temps finis du thread
					 long endtime =  System.nanoTime() / 1000000;
					 System.out.println("\n Thread "+thread.getName()+ ": ");

			        	System.out.println("\n Temps de debut d'execution du Thread "+(startTime)+ " en nanosecondes");
			        	System.out.println("\n Temps d'execution du Thread "+(endtime - startTime ) + " ms");
				 }

				 MergeThread thread = new MergeThread(threadPool);
				 thread.run();
				 System.out.println("\n *************");
				 break;
			case 2:

				original2=EntreeAleatoire ();
				 long startTime1 =  System.nanoTime() / 1000000; // Temps de debut

				List<Integer[]> threadPool1 = new ArrayList<Integer[]>();

				 for(Integer[] array1 : original2)
				 {
					
					 SortingThread thread1 = new SortingThread(array1);
					 thread1.start();
					 threadPool1.add(thread1.ListOr);
					 long endtime =  System.nanoTime() / 1000000;
					 System.out.println("\n Thread "+thread1.getName()+ ": ");
						//l'affichage du fin du temps
			        	System.out.println("\n Temps de debut d'execution du Thread "+(startTime1)+ " en nanosecondes");
			        	System.out.println("\n Temps d'execution du Thread "+(endtime - startTime1 ) + " ms");
				 }

				 MergeThread thread1 = new MergeThread(threadPool1);
				 thread1.run();
				 System.out.println("\n *************");
				 break;


			 default:
				 Reprise();
				 MauvaisChoix();
				   break;
	     }

	     choix = Reprise();



	 } // si l'utlisateur ne veut pas reprendre le programme
		 if (choix == 'N' ) {
			 System.out.println("\n******");
			 System.out.println("\n Merci d'avoir utilise notre programme.");
			 System.out.println("\n Bonne journee.");
			 }
		 System.out.println("\n******");

}

}
