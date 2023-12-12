package comparing;

import java.util.Comparator;

import MyPackage.MyProcess;

public class CompareProcessByArrival implements Comparator<MyProcess>{


	@Override
	public int compare(MyProcess p1, MyProcess p2) {
		return p1.getArrivalTime()-p2.getArrivalTime();
	}

}
