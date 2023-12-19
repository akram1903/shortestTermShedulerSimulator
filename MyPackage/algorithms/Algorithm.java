package MyPackage.algorithms;

import java.util.Queue;

import MyPackage.MyProcess;

public abstract class Algorithm implements Runnable{
    protected Queue<MyProcess> workingQ;
    public CollectiveOut collectiveOut;
    public abstract void run();
    protected Algorithm nextAlgorithm;
    // protected boolean isRunning;

    Algorithm(){
        // isRunning = false;
    }
    public void pushInQueue(MyProcess p){
        // System.out.println("in pushInQueue");
        workingQ.add(p);
        // if(!isRunning){
        // Thread t = new Thread((Runnable)this);
        // t.start();
        // }
        
        // run();
    }

}
