package Info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// cest la classe du thread qui merge  les sousTableaux
public class MergeThread extends Thread
{
	Integer[]left;
	List<Integer[]> subLists;
	
	MergeThread(List<Integer[]> subLists){
		this.subLists= new ArrayList<Integer[]>(subLists);
		
			
		
	}
	
	public static Integer[] mergethread(Integer[] a, Integer[] b) {
		Integer[] left = a;
		Integer[] right = b;
		int i1 = 0;
		int i2 = 0;

		Integer[] result = new Integer[((left.length) + right.length)];
		for (int i = 0; i < result.length; i++) {
			if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
				result[i] = left[i1];
				i1++;
			} else {
				result[i] = right[i2];
				i2++;
			}

		}

		// return result;
		return result;

	}
	
	public void run() {
		Integer[] result = subLists.get(0);
		
		for(int i = 1 ; i < subLists.size() ; i++) {
			
			result = mergethread(result,subLists.get(i));
		}
		
		System.out.println("\n La resultat du merge est : "+Arrays.toString(result));

	}

}

