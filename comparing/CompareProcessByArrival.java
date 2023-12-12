package MyPackage;

import java.util.Comparator;

public class CompareProcessByArrival implements Comparator<MyProcess>{


	@Override
	public int compare(MyProcess p1, MyProcess p2) {
		return p1.getArrivalTime()-p2.getArrivalTime();
	}

}
