package MyPackage.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import MyPackage.*;
import comparing.CompareProcessByArrival;

public class FCFS extends Algorithm implements Runnable{
	public static int ALL_BURST_TIME = 200;
	
	public FCFS(ArrayList<MyProcess> arr,CollectiveOut collectiveOut,Algorithm nextAlgorithm){
		// this.collectiveOut = cpu;
		super();
		this.workingQ = new PriorityQueue<MyProcess>(new CompareProcessByArrival());
		this.collectiveOut = collectiveOut;
		for(MyProcess p:arr){
			workingQ.add(p);
		}
		this.nextAlgorithm = nextAlgorithm;
	}
	public FCFS(Queue<MyProcess> q,CollectiveOut collectiveOut,Algorithm nextAlgorithm){
		super();
		this.workingQ = q;
		this.collectiveOut = collectiveOut;
		this.nextAlgorithm = nextAlgorithm;
	}
	public FCFS(CollectiveOut collectiveOut){
		super();
		this.collectiveOut = collectiveOut;
		this.workingQ = new LinkedList<>();
	}
	
	
	
	@Override
	public void run() {
		// isRunning=true;
			if(!workingQ.isEmpty()){
				MyProcess p = this.workingQ.poll();
				System.out.println("next process in FCFS stage ");
				System.out.println(p.getPID());
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

				p.setAvailableBurst(ALL_BURST_TIME);
				p.setBurstAquired(p.getRemainingBurstTime());
				p.decreaseBurstTimeBy(p.getRemainingBurstTime());
				
				collectiveOut.push(p,null);
				
		}
		// isRunning=false;
				
	
	}
		


}
