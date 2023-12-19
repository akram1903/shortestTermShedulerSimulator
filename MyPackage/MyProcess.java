package MyPackage;

import java.time.LocalTime;

public class MyProcess {
    private int PID;
    private LocalTime arrivalTime;
    private int remainingBurstTime;
    private int burstTime;
	private int burstAquired;
    private int turnAroundTime;
    private LocalTime startTime; 
    private LocalTime endTime;
    

	private int availableBurst;
    public MyProcess(LocalTime arrivalTime,int BurstTime, int PID){
        if(PID<0 || BurstTime <0)
            throw new ArithmeticException("PID, burst time is negative");
        this.PID = PID;
        this.remainingBurstTime = BurstTime;
        this.burstTime = BurstTime;
        this.arrivalTime = arrivalTime;
		this.startTime = null;
		this.burstAquired=0;
    }

    // getters

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public int getRemainingBurstTime() {
        return remainingBurstTime;
    }
    public int getPID() {
        return PID;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public int getTurnAroundTime() {
        return turnAroundTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public int getAvailableBurst() {
		return availableBurst;
	}
    // setters
	public void setBurstAquired(int burstAquired) {
		this.burstAquired = burstAquired;
	}
    public void setStartTime() {
        this.startTime = LocalTime.now();
    }
    public void decreaseBurstTimeBy(int t){
        remainingBurstTime -= t;
    }
    public void increaseTurnAroundTime(int t){
        turnAroundTime += t;
    }
    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }
    public void setEndTime() {
        this.endTime = LocalTime.now();
    }
	public void setAvailableBurst(int availableBurst) {
		this.availableBurst = availableBurst;
	}
    
    public String toString(){
        String s = new String();

        s += "Process: "+ this.PID + '\n';
        s += "arrival time: "+ this.arrivalTime+ '\n';
        s += "remaining burst time: "+ this.remainingBurstTime+ '\n';
        s += "burst time: "+ this.burstTime+ '\n';
                
        s += "end time: "+ this.endTime+ '\n';
        s += "---------------------\n";
        

        return s;
    }

	public void excecute(){
		if (startTime==null)
			setStartTime();
		// try {
		// 	if(this.getRemainingBurstTime()>availableBurst){
		// 		Thread.sleep(availableBurst*1000);
		// 	}
		// 	else{
		// 		Thread.sleep(remainingBurstTime*1000);
		// 		this.setEndTime();
		// 		turnAroundTime = startTime.getSecond()-endTime.getSecond();
		// }
		// } catch (Exception e) {
		// 	System.err.println(e.getMessage());
		// }

		try {
			Thread.sleep(burstAquired*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(remainingBurstTime==0)
			this.setEndTime();
		this.burstAquired=0;
	}
  
}
