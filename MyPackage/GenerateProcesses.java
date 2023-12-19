package MyPackage;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class GenerateProcesses {
	private Random r;
	
	GenerateProcesses(){
		this.r = new Random();
	}
	
	ArrayList<MyProcess> generate(int nOfProcesses,int maxTimeInterval){
		
		ArrayList<MyProcess> arr = new ArrayList<MyProcess>();
		LocalTime lc = LocalTime.now();
		for(int i=0;i<nOfProcesses;i++) {
			int arrival = Math.abs(r.nextInt()%maxTimeInterval);
			int burst = Math.abs(r.nextInt()%maxTimeInterval)+1;
			
			LocalTime lt = lc.plusSeconds(arrival);
			MyProcess p = new MyProcess(lt, burst, i+1);
			arr.add(p);
		}
		
		
		return arr;
	}
}
