package model;

import java.util.ArrayList;
import java.util.Arrays;

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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(arrNumInt);
	}
	

}
