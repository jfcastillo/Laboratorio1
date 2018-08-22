package model;

import java.util.ArrayList;

public class Coprocessor {

	private ArrayList<Integer> numbersInt;
	private ArrayList<Float> numbersFloat;
	
	public Coprocessor() {
		numbersInt = new ArrayList<Integer>();
		numbersFloat = new ArrayList<Float>();
		
	}
	
	public void generateRandom(int amount, int min, int max) {
		int range = (max - min)+1;		
		
		
		for (int i = 0; i < amount; i++) {
			int numRandom = (int) (Math.random()*range)+min;
			numbersInt.add(numRandom);
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return numbersInt.toString();
	}
	

}
