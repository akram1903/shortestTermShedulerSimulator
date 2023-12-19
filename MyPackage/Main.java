package MyPackage;

import java.util.ArrayList;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        GenerateProcesses g = new GenerateProcesses();
        ArrayList<MyProcess> arr = g.generate(3,10);
        // ArrayList<MyProcess> arr = new ArrayList<>();

        STS shortestTermScheduler = new STS(arr);
        shortestTermScheduler.run();
    }
}