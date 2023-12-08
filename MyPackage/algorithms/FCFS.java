package MyPackage.algorithms;

import java.util.PriorityQueue;

import MyPackage.*;

public class FCFS extends Algorithm{

	
	FCFS(){
		this.q = new PriorityQueue<MyProcess>(new CompareProcessByArrival());
	}
	
	
	
	
	@Override
	public void run() {
		
		
		
	}


}
