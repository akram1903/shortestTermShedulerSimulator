package MyPackage;

import java.time.LocalTime;
import java.util.ArrayList;

import MyPackage.algorithms.*;
import comparing.CompareProcessByArrival;

public class STS {
    private ArrayList<MyProcess> arr;
    
    public STS(ArrayList<MyProcess> arr){
        this.arr = arr;
        this.arr.sort(new CompareProcessByArrival());
    }
/*
    
    implementing the 3 level queue
    level 1 : roundsrobin with quantum 8
    level 2 : roundsrobin with quantum 16
    level 3 : FCFS

    Note : there will be a debate on how we take the output to run on cpu
        - we can make another CollectiveOut class that takes the ready process from each level
          and outputs the processes FIFO like

*/

    public void run(){
        
        arr = new ArrayList<>();
        arr.add(new MyProcess(LocalTime.now().plusSeconds(0), 3, 0));
        arr.add(new MyProcess(LocalTime.now().plusSeconds(1), 11, 1));
        arr.add(new MyProcess(LocalTime.now().plusSeconds(5), 25, 2));

        Thread co = new Thread();
        CollectiveOut collectiveOut = new CollectiveOut(co);
        // co = new Thread((Runnable)collectiveOut);
       
        FCFS level3 = new FCFS(collectiveOut);
        // level3.run(time);

        RoundsRobin level2 = new RoundsRobin(collectiveOut,16,level3);
        // Queue<MyProcess> promoted2 = level2.run(time);
        
        // RoundsRobin level1 = new RoundsRobin(arr, 8);
        RoundsRobin level1 = new RoundsRobin(collectiveOut,8,level2);
        // Queue<MyProcess> promoted1 = level1.run(time);

        

        // Thread l1 = new Thread((Runnable)level1);
        // Thread l2 = new Thread((Runnable)level2);
        // Thread l3 = new Thread((Runnable)level3);
        
        // l1.start();
        // l2.start();
        // l3.start();
        // co.start();
        System.out.println("Generated processes:\n");
        for(MyProcess p:arr){
            
            System.out.println(p);
        }
        System.out.println("==============================");

        while (arr.size()>0) {
            while(arr.get(0).getArrivalTime().getSecond()!=LocalTime.now().getSecond());
            level1.pushInQueue(arr.get(0));
            arr.remove(0);
        }
        System.out.println("|||||||||||||||||||||||||");
        System.out.println("all processes entered STS");
        System.out.println("|||||||||||||||||||||||||");

        // try {
        //     // l1.join();
        //     // l2.join();
        //     // l3.join();
        //     co.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        
        
        // System.out.println(" ===================================");
        // System.out.println("|| STS ended its task successfully ||");
        // System.out.println(" ===================================\n");
    }

}
