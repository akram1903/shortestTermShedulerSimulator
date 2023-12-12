package MyPackage.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import MyPackage.MyProcess;
import MyPackage.SharedTime;
import comparing.CompareProcessByArrival;

public class RoundsRobin extends Algorithm {
	private int quanta;

	// private ArrayList<MyProcess> arr;
	public RoundsRobin(ArrayList<MyProcess> arr,int quanta){
		this.quanta = quanta;

		this.workingQ = new PriorityQueue<MyProcess>(new CompareProcessByArrival());
		for(MyProcess p:arr){
			workingQ.add(p);
		}
		
		// this.arr= arr;
	}
	public RoundsRobin(Queue<MyProcess> q,int quanta){
		this.quanta = quanta;
		this.workingQ = q;
	}

	@Override
	public Queue<MyProcess> run(CollectiveOut collectiveOut,SharedTime t0) {
		Queue<MyProcess> unfinished = new LinkedList<>();
		// not terminated yet
		// refreshQ();
		System.out.println("\n==================\ninside roundsRobin with quanta:"+this.quanta);
		System.out.println("==================\n");
		while(!this.workingQ.isEmpty()) {
			
			MyProcess p = workingQ.poll();
			// arr.remove(p);
			// System.out.println("start time: "+t0);
			if(p.getArrivalTime()>t0.getTime())
				t0.setTime(p.getArrivalTime());
			p.setStartTime(t0.getTime());
			
			p.setResponseTime(p.getArrivalTime()-t0.getTime());
			// p.decreaseBurstTimeBy(this.quanta);
			
			
			
			if(p.getRemainingBurstTime()>this.quanta){
				t0.increment(this.quanta);
				p.decreaseBurstTimeBy(this.quanta);
				p.increaseTurnAroundTime(this.quanta);
				unfinished.add(p);
			}
			else{
				t0.increment(p.getRemainingBurstTime());
				p.decreaseBurstTimeBy(p.getRemainingBurstTime());
				p.increaseTurnAroundTime(p.getRemainingBurstTime());
				p.setEndTime(t0.getTime());
				collectiveOut.push(p);
			}
			System.out.println(p);
			System.out.println("Time is "+t0.getTime());
			// refreshQ();
		
		}
		
		return unfinished;
	}
	
	
	
}
