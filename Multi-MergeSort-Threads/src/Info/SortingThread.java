package Info;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


//cest la classe du thread qui tri les sousTableaux
public class SortingThread extends Thread{

	
	static int Nlist=0 ;
	Integer[] ListOr;

	
	
	SortingThread(Integer[] ListOr ){
		
		this.ListOr = ListOr.clone();
		
	}
	

	public void run() {
		
		 	 
	
		for (int i = 0; i < this.ListOr.length - 1; i++) {
			
			int min = i;
			for (int j = i + 1; j < this.ListOr.length; j++) {
				if (this.ListOr[j] < this.ListOr[min]) {
					min = j;
				}
			}
			if (i != min) {
				int swap = this.ListOr[i];
				this.ListOr[i] = this.ListOr[min];
				this.ListOr[min] = swap;
			}
			
		}
		
 		
    
         
	}
	
}

	


