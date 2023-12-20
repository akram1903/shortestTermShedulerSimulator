package MyPackage;

import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        GenerateProcesses g = new GenerateProcesses();
        ArrayList<MyProcess> arr = g.generate(100,100);
        // ArrayList<MyProcess> arr = new ArrayList<>();

        STS shortestTermScheduler = new STS(arr);
        shortestTermScheduler.run();
    }
}