package MyPackage.algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import MyPackage.*;
import comparing.CompareProcessByArrival;

public class FCFS extends Algorithm{

	
	public FCFS(ArrayList<MyProcess> arr){
		
		// this.t0 = t0;
		this.workingQ = new PriorityQueue<MyProcess>(new CompareProcessByArrival());

		for(MyProcess p:arr){
			workingQ.add(p);
		}
	}
	public FCFS(Queue<MyProcess> q){
		this.workingQ = q;
	}
	
	
	
	
	@Override
	public Queue<MyProcess> run(CollectiveOut collectiveOut,SharedTime t0) {
		System.out.println("\n+++++++++++++++++++++++++++++\nin FCFS");
		System.out.println("+++++++++++++++++++++++++++++");
		// int n = q.size();
		while(!workingQ.isEmpty()){
			
			MyProcess p = this.workingQ.poll();
			if(p.getArrivalTime()>t0.getTime())
				t0.setTime(p.getArrivalTime());
			// p.setStartTime(time);
			
			
			t0.increment(p.getRemainingBurstTime());

			if(collectiveOut != null){
				collectiveOut.push(p);
			}
			
			p.setEndTime(t0.getTime());
			
			// p.setTurnAroundTime(time-p.getArrivalTime());
			// p.setResponseTime(p.getStartTime()-p.getArrivalTime());
			// p.setWaitingTime(p.getTurnAroundTime()-p.getBurstTime());
			
			p.decreaseBurstTimeBy(p.getRemainingBurstTime());
			System.out.println(p);
		}
		return null;
				
	}


}
