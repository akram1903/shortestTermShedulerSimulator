package MyPackage;


import java.util.ArrayList;

import MyPackage.algorithms.FCFS;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
    	GenerateProcesses g = new GenerateProcesses();
        ArrayList<MyProcess> arr = g.generate(10);
        FCFS sts = new FCFS(arr);
        sts.run();
        // for (MyProcess p: arr) {
        // 	System.out.println("Process: "+ p.getPID());
        // 	System.out.println("arrival time: "+ p.getArrivalTime());
        // 	System.out.println("burst time: "+ p.getBurstTime());
        // }
    }
}