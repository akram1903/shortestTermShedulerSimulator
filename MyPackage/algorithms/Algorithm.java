package MyPackage.algorithms;

import java.util.PriorityQueue;
import MyPackage.MyProcess;

public abstract class Algorithm {
    public PriorityQueue<MyProcess> q;
    public static boolean preemptive;
    private double throughput;
    private double AvgTurnAroundTime;
    private double AvgWaitingTime;
    private double AvgResponseTime;
    
 
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
    public static void setPreemptive(boolean preemptive) {
        Algorithm.preemptive = preemptive;
    }
    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }

    public abstract void run();

}
