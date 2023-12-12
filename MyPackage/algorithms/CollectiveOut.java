package MyPackage.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import MyPackage.MyProcess;

public class CollectiveOut {
    private Queue<MyProcess> q;
    public CollectiveOut(ArrayList<MyProcess> arr){
		
		this.q = new LinkedList<MyProcess>();

		for(MyProcess p:arr){
			q.add(p);
		}
	}
	
	
	public void push(MyProcess p){
        q.add(p);
    }
	
	public void run() {
		System.out.println("\n=======================================\n");
        System.out.println("Collective out :");
		while(!q.isEmpty()){
			
			MyProcess p = this.q.poll();
			System.out.println(p);
		}
				
	}
}
