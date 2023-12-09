package MyPackage.algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

import MyPackage.*;

public class FCFS extends Algorithm{

	{
		FCFS.preemptive = false;
	}
	
	public FCFS(ArrayList<MyProcess> arr){
		
		this.q = new PriorityQueue<MyProcess>(new CompareProcessByArrival());

		for(MyProcess p:arr){
			q.add(p);
		}
	}
	
	
	
	
	@Override
	public void run() {
		int time =0;
		int n = q.size();
		while(!q.isEmpty()){
			
			MyProcess p = this.q.poll();
			if(p.getArrivalTime()>time)
				time = p.getArrivalTime();
			p.setStartTime(time);
			
			System.out.println("start time: "+time);
			System.out.println("Process: "+ p.getPID());
			System.out.println("arrival time: "+ p.getArrivalTime());
			System.out.println("burst time: "+ p.getBurstTime());
			
			time += p.getBurstTime();
			
			System.out.println("end time: "+time);
			System.out.println("---------------------");
			
			p.setTurnAroundTime(time-p.getArrivalTime());
			p.setResponseTime(p.getStartTime()-p.getArrivalTime());
			p.setWaitingTime(p.getTurnAroundTime()-p.getBurstTime());
			
			System.out.println("turnAroundTime: "+ p.getTurnAroundTime());
			System.out.println("responseTime: "+ p.getResponseTime());
			System.out.println("waitingTime: "+ p.getWaitingTime());
			System.out.println("\n=====================\n");

			this.AvgResponseTime+=((double)p.getResponseTime())/n;
			this.AvgTurnAroundTime+=((double)p.getTurnAroundTime())/n;
			this.AvgWaitingTime+=((double)p.getWaitingTime()/n);
			// this.setAvgResponseTime((double)p.getResponseTime()/n);
			// this.setAvgTurnAroundTime();
			// this.setAvgWaitingTime();
			// this.setThroughput();

		}
		
		this.throughput = time/2;
		System.out.println("\n\nthroughput = "+this.throughput+"\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");		
	}


}
