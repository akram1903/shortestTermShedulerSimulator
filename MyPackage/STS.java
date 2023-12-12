package MyPackage;

import java.util.ArrayList;
import java.util.Queue;

import MyPackage.algorithms.*;

public class STS {
    private SharedTime time;
    
    public STS(/*ArrayList<MyProcess> arr*/){
        
        // this.arrivalQueue = new PriorityQueue<MyProcess>(new CompareProcessByArrival());

		// for(MyProcess p:arr){
		// 	arrivalQueue.add(p);
		// }

        time = new SharedTime(0);
    }
// implementing the 3 level queue
// level 1 : roundsrobin with quantum 8
// level 2 : roundsrobin with quantum 16
// level 3 : FCFS

// Note : there will be a debate on how we take the output to run on cpu
//       - we can make another FCFS that takes the ready process from each level
    public void run(){
        // GenerateProcesses g = new GenerateProcesses();
        // ArrayList<MyProcess> arr = g.generate(5);
        ArrayList<MyProcess> arr = new ArrayList<>();
        CollectiveOut collectiveOut = new CollectiveOut(new ArrayList<MyProcess>());

        arr.add(new MyProcess(0, 5+10, 0));
        arr.add(new MyProcess(0, 4+10, 1));
        arr.add(new MyProcess(0, 7+10, 2));
        arr.add(new MyProcess(0, 3+10, 3));
        arr.add(new MyProcess(3, 100, 4));


        RoundsRobin level1 = new RoundsRobin(arr, 8);
        Queue<MyProcess> promoted1 = level1.run(collectiveOut,time);

        RoundsRobin level2 = new RoundsRobin(promoted1, 16);
        Queue<MyProcess> promoted2 = level2.run(collectiveOut,time);

        FCFS level3 = new FCFS(promoted2);
        level3.run(collectiveOut,time);
        
        collectiveOut.run();
        System.out.println("STS end its task successfully");
    }

}
