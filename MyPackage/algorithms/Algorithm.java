package MyPackage.algorithms;

import java.util.Queue;

import MyPackage.MyProcess;
import MyPackage.SharedTime;

public abstract class Algorithm {
    public Queue<MyProcess> workingQ;
    // protected Integer t0;

    
    // public void pushInQ(MyProcess p, CollectiveOut collectiveOut) {
	// 	this.workingQ.add(p);
	// 	this.run(collectiveOut);
	// }
    // collectiveOut is for finished processes and we return unfinished processes.
    public abstract Queue<MyProcess> run(CollectiveOut collectiveOut,SharedTime t0);

}
