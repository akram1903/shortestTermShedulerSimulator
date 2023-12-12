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
			int arrival = Math.abs(r.nextInt()%100);
			int burst = Math.abs(r.nextInt()%100)+1;
			
			MyProcess p = new MyProcess(arrival, burst, i+1);
			arr.add(p);
		}
		
		
		return arr;
	}
}
