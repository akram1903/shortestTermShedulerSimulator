package MyPackage.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import MyPackage.MyProcess;
import comparing.CompareProcessByArrival;

public class RoundsRobin extends Algorithm implements Runnable{
	private int quanta;

	// public RoundsRobin(ArrayList<MyProcess> arr,int quanta,CollectiveOut collectiveOut,Algorithm nexAlgorithm){
	// 	this.quanta = quanta;
	// 	this.collectiveOut = collectiveOut;
	// 	this.workingQ = new PriorityQueue<MyProcess>(new CompareProcessByArrival());
	// 	for(MyProcess p:arr){
	// 		workingQ.add(p);
	// 	}
	// 	this.nextAlgorithm = nexAlgorithm;
		
	// 	// this.arr= arr;
	// }
	// public RoundsRobin(Queue<MyProcess> q,int quanta,CollectiveOut collectiveOut,Algorithm nexAlgorithm){
	// 	this.quanta = quanta;
	// 	this.workingQ = q;
	// 	this.collectiveOut = collectiveOut;
	// 	this.nextAlgorithm = nexAlgorithm;
	// }

	public RoundsRobin(CollectiveOut collectiveOut,int quanta,Algorithm nextAlgorithm){
		super();
		this.collectiveOut=collectiveOut;
		this.quanta=quanta;
		this.nextAlgorithm=nextAlgorithm;
		this.workingQ = new LinkedList<MyProcess>();
	}
	@Override
	public void run() {
		// isRunning=true;
		// System.out.println("\n==================\ninside roundsRobin with quanta:"+this.quanta);
		// System.out.println("==================\n");
			if(!workingQ.isEmpty()) {
				
				MyProcess p = workingQ.poll();
				System.out.println("next process is in RR stage "+quanta);
				System.out.println(p.getPID());
				System.out.println("+++++++++++++++++++++++++++++++++++++");
				p.setAvailableBurst(quanta);
				if(quanta<p.getRemainingBurstTime()){
					p.decreaseBurstTimeBy(quanta);
					p.setBurstAquired(quanta);
				}
				else{
					p.setBurstAquired(p.getRemainingBurstTime());
					p.decreaseBurstTimeBy(p.getRemainingBurstTime());
				}
				collectiveOut.push(p, nextAlgorithm);
			
			}
			
		// isRunning=false;
		
	}
	
	
	
}
