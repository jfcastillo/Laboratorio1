package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Coprocessor {
	private int[] arrNumInt;
	private ArrayList<Integer> numbersInt;
	private ArrayList<Float> numbersFloat;
	
	public Coprocessor() {
		arrNumInt = new int [0];
		numbersInt = new ArrayList<Integer>();
		numbersFloat = new ArrayList<Float>();
		
	}
	public void changeSize(int size) {
		arrNumInt = new int [size];
	}
//	public void generateRandom(int amount, int min, int max) {
//		int range = (max - min)+1;		
//		
//		
//		for (int i = 0; i < amount; i++) {
//			int numRandom = (int) (Math.random()*range)+min;
//			numbersInt.add(numRandom);
//		}
//		
//	}
	public void generateRandom(int amount, int min, int max) {
		int range = (max - min)+1;		
		
		arrNumInt = new int[amount];
		for (int i = 0; i < amount; i++) {
			int numRandom = (int) (Math.random()*range)+min;
			arrNumInt[i] = numRandom;
		}
		
	}
	
	//Use this better for floats numbers
	public void bucketSort(int maxValue) {
		int bucket [] = new int[maxValue+1];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
		}
		for (int i = 0; i < arrNumInt.length; i++) {
			bucket[arrNumInt[i]]++;
		}
		int outPos = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				arrNumInt[outPos++] = i;
			}
		}

	}
	
	public void sortArrayList() {
		Collections.sort(numbersInt);
	}
	
	//Use this just for Integer numbers
	public int[] countingSort(int [] array ) {
//		int [] aux = new int [arrNumInt.length];
//		int min = arrNumInt[0];
//		int max = arrNumInt[0];
//		for (int i = 0; i < arrNumInt.length; i++) {
//			if (arrNumInt[i] < min) {
//				min = arrNumInt[i];
//			}
//			else if (arrNumInt[i] > max) {
//				max = arrNumInt[i];
//			}
//		}
//		
//		int[] counts = new int[max-min+1];
//		for (int i = 0; i < arrNumInt.length; i++) {
//			counts[arrNumInt[i] - min]++;			
//		}
//		counts[0]--;
//		for (int i = 1; i < counts.length; i++) {
//			counts[i] = counts[i] + counts[i-1];
//		}
//		for (int i = arrNumInt.length - 1; i >= 0; i--) {
//			arrNumInt[counts[aux[i] - min]--] = aux[i];
//	    }
		 // array to be sorted in, this array is necessary
	    // when we sort object datatypes, if we don't, 
	    // we can sort directly into the input array     
	    int[] aux = new int[array.length];
	 
	    // find the smallest and the largest value
	    int min = array[0];
	    int max = array[0];
	    for (int i = 1; i < array.length; i++) {
	      if (array[i] < min) {
	        min = array[i];
	      } else if (array[i] > max) {
	        max = array[i];
	      }
	    }
	 
	    // init array of frequencies
	    int[] counts = new int[max - min + 1];
	 
	    // init the frequencies
	    for (int i = 0;  i < array.length; i++) {
	      counts[array[i] - min]++;
	    }
	 
	    // recalculate the array - create the array of occurences
	    counts[0]--;
	    for (int i = 1; i < counts.length; i++) {
	      counts[i] = counts[i] + counts[i-1];
	    }
	 
	    /*
	      Sort the array right to the left
	      1) Look up in the array of occurences the last occurence of the given value
	      2) Place it into the sorted array
	      3) Decrement the index of the last occurence of the given value
	      4) Continue with the previous value of the input array (goto set1), 
	         terminate if all values were already sorted
	    */ 
	    for (int i = array.length - 1; i >= 0; i--) {
	        aux[counts[array[i] - min]--] = array[i];
	    }
	 
	    return aux;
	}
	public int[] countingSortInverse (int [] array ) { 
		int[] aux = new int[array.length];
		 
	    // find the smallest and the largest value
	    int min = array[0];
	    int max = array[0];
	    for (int i = 1; i < array.length; i++) {
	      if (array[i] < min) {
	        min = array[i];
	      } else if (array[i] > max) {
	        max = array[i];
	      }
	    }
	 
	    // init array of frequencies
	    int[] counts = new int[max - min + 1];
	 
	    // init the frequencies
	    for (int i = 0;  i < array.length; i++) {
	      counts[array[i] - min]++;
	    }
	 
	    // recalculate the array - create the array of occurences
	    counts[0]--;
	    for (int i = 1; i < counts.length; i++) {
	      counts[i] = counts[i] + counts[i-1];
	    }
	 
	    /*
	      Sort the array right to the left
	      1) Look up in the array of occurences the last occurence of the given value
	      2) Place it into the sorted array
	      3) Decrement the index of the last occurence of the given value
	      4) Continue with the previous value of the input array (goto set1), 
	         terminate if all values were already sorted
	    */ 
	    for (int i = array.length - 1; i >= 0; i--) {
	        aux[counts[array[i] - min]--] = array[i];
	    }
	 
	    return aux;
	}

	
	
	public ArrayList<Integer> getNumbersInt() {
		return numbersInt;
	}

	public void setNumbersInt(ArrayList<Integer> numbersInt) {
		this.numbersInt = numbersInt;
	}

	public ArrayList<Float> getNumbersFloat() {
		return numbersFloat;
	}

	public void setNumbersFloat(ArrayList<Float> numbersFloat) {
		this.numbersFloat = numbersFloat;
	}
	
	public void addNumbersInt(int number) {
		numbersInt.add(number);
	}
	

	public int[] getArrNumInt() {
		return arrNumInt;
	}
	public void setArrNumInt(int[] arrNumInt) {
		this.arrNumInt = arrNumInt;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(arrNumInt);
	}
	

}
