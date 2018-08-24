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

	public void generateRandom(int amount, int min, int max, int i) {
		int range = (max - min)+1;		
		
		arrNumInt = new int[amount];
		for (; i < amount; i++) {
			int numRandom = (int) (Math.random()*range)+min;
			arrNumInt[i] = numRandom;
		}
		
	}
	public int []generateRandomA(int amount, int min, int max, int i) {
		int[] arr = new int[amount];
		int range = (max - min)+1;		
		
		
		for (; i < amount; i++) {
			int numRandom = (int) (Math.random()*range)+min;
			arr[i] = numRandom;
		}
		return arr;
		
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
		   
	    int[] aux = new int[array.length];
	    int min = array[0];
	    int max = array[0];
	    for (int i = 1; i < array.length; i++) {
	      if (array[i] < min) {
	        min = array[i];
	      } else if (array[i] > max) {
	        max = array[i];
	      }
	    }
	    int[] counts = new int[max - min + 1];
	    for (int i = 0;  i < array.length; i++) {
	      counts[array[i] - min]++;
	    }
	    counts[0]--;
	    for (int i = 1; i < counts.length; i++) {
	      counts[i] = counts[i] + counts[i-1];
	    }
	    for (int i = array.length - 1; i >= 0; i--) {
	        aux[counts[array[i] - min]--] = array[i];
	    }
	 
	    return aux;
	}
	public void joinArrays(int [] array) {
		for (int i = 0; i < array.length; i++) {
			
		}
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
