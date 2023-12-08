package MyPackage;

import java.util.ArrayList;
import java.util.Random;

public class GenerateProcesses {
	private Random r;
	
	GenerateProcesses(){
		this.r = new Random();
	}
	
	ArrayList<MyProcess> generate(int nOfProcesses){
		
		ArrayList<MyProcess> arr = new ArrayList<MyProcess>();
		
		for(int i=0;i<nOfProcesses;i++) {
			int arrival = Math.abs(r.nextInt()%20);
			int burst = Math.abs(r.nextInt()%20);
			
			MyProcess p = new MyProcess(arrival, burst, i);
			arr.add(p);
		}
		
		
		return arr;
	}
}
