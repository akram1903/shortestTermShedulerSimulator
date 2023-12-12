package MyPackage;



/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
    	// GenerateProcesses g = new GenerateProcesses();
        // // ArrayList<MyProcess> arr = g.generate(5);
        // ArrayList<MyProcess> arr = new ArrayList<>();
        // arr.add(new MyProcess(0, 5+10, 0));
        // arr.add(new MyProcess(0, 4+10, 1));
        // arr.add(new MyProcess(0, 7+10, 2));
        // arr.add(new MyProcess(0, 3+10, 3));
        // arr.add(new MyProcess(3, 1+10, 4));
        // // // FCFS sts = new FCFS(arr, 0);
        // // // sts.run();
        // Queue<MyProcess> collectiveOut = new LinkedList<MyProcess>();
        // RoundsRobin r = new RoundsRobin(arr, 0, 5);
        // ArrayList<MyProcess> remain=r.run(collectiveOut);
        // System.out.println("================================\nremaining processes");
        // for (MyProcess p : remain) {
        //     System.out.println(p);
        // }
        // // arr.sort(new CompareProcessByArrival());
        // // for (MyProcess p : arr) {
        // //     r.pushInQ(p,collectiveOut);
        // // }
        // // r.run(collectiveOut);

        STS shortestTermScheduler = new STS();
        shortestTermScheduler.run();
    }
}