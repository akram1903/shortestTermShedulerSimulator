package MyPackage.algorithms;

import java.util.LinkedList;
import java.util.Queue;

import MyPackage.MyProcess;

public class CollectiveOut implements Runnable{
    private Queue<MyProcess> q;
	private Thread t;
	private Algorithm nextAlg;
    public CollectiveOut(Thread t){
		q = new LinkedList<MyProcess>();
		this.t=t;
		// isRunning = false;
	}
	
	
	public void push(MyProcess p,Algorithm nextAlg){
		this.nextAlg=nextAlg;
        q.add(p);
		System.out.println("in Collectiveout push");
		if(!t.isAlive()){
			t = new Thread(this);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
	@Override
	public void run() {
		// isRunning=true;

			if(!q.isEmpty()){
				MyProcess p = this.q.poll();
				p.excecute();
				System.out.println(p);
			
				if(p.getRemainingBurstTime()>0){
					nextAlg.pushInQueue(p);
				}
				
			}
			// try {
			// 	Thread.sleep(10);
			// } catch (InterruptedException e) {
			// 	e.printStackTrace();
			// }
		
		
		// isRunning=false;	
	}
}
