package MyPackage.algorithms;

import java.util.PriorityQueue;
import MyPackage.MyProcess;

public abstract class Algorithm {
    public PriorityQueue<MyProcess> q;
    protected static boolean preemptive;
    protected double throughput=0;
    protected double AvgTurnAroundTime=0;
    protected double AvgWaitingTime=0;
    protected double AvgResponseTime=0;
    
 
	// getters
    public double getAvgResponseTime() {
        return AvgResponseTime;
    }
    public double getAvgTurnAroundTime() {
        return AvgTurnAroundTime;
    }
    public double getAvgWaitingTime() {
        return AvgWaitingTime;
    }
    public double getThroughput() {
        return throughput;
    }
    public static boolean getPreemptive(){
        return preemptive;
    }
    // setters
    public void setAvgResponseTime(double avgResponseTime) {
        AvgResponseTime = avgResponseTime;
    }
    public void setAvgTurnAroundTime(double avgTurnAroundTime) {
        AvgTurnAroundTime = avgTurnAroundTime;
    }
    public void setAvgWaitingTime(double avgWaitingTime) {
        AvgWaitingTime = avgWaitingTime;
    }
    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }

    public abstract void run();

}
