package MyPackage;


import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
    	GenerateProcesses g = new GenerateProcesses();
        ArrayList<MyProcess> arr = g.generate(10);
        
        for (MyProcess p: arr) {
        	System.out.println("Process: "+ p.getPID());
        	System.out.println("arrival time: "+ p.getArrivalTime());
        	System.out.println("burst time: "+ p.getBurstTime());
        }
    }
}