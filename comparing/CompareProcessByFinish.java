package comparing;

import java.util.Comparator;

import MyPackage.MyProcess;

public class CompareProcessByFinish implements Comparator<MyProcess> {

    @Override
    public int compare(MyProcess o1, MyProcess o2) {
        return o1.getEndTime()-o2.getEndTime();
    }
    
}
