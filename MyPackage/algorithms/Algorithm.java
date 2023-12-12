package MyPackage.algorithms;

import java.util.Queue;

import MyPackage.MyProcess;
import MyPackage.SharedTime;

public abstract class Algorithm {
    public Queue<MyProcess> workingQ;
    public abstract Queue<MyProcess> run(CollectiveOut collectiveOut,SharedTime t0);

}
