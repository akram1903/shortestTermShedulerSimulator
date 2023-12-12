package MyPackage;
public class MyProcess {
    private int PID;
    private int arrivalTime;
    private int remainingBurstTime;
    private int burstTime;
    private int turnAroundTime;
    private int startTime; 
    private int endTime;

    public MyProcess(int arrivalTime,int BurstTime, int PID){
        if(PID<0 || arrivalTime<0 || BurstTime <0)
            throw new ArithmeticException("PID, arrival time or burst time is negative");
        this.PID = PID;
        this.remainingBurstTime = BurstTime;
        this.burstTime = BurstTime;
        this.arrivalTime = arrivalTime;
    }

    // getters

    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getRemainingBurstTime() {
        return remainingBurstTime;
    }
    public int getPID() {
        return PID;
    }
    public int getStartTime() {
        return startTime;
    }
    public int getTurnAroundTime() {
        return turnAroundTime;
    }
    public int getEndTime() {
        return endTime;
    }
    
    // setters
    public void setStartTime(int startTime) {
        this.startTime = startTime;
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
    public void setEndTime(int endTime) {
        this.endTime = endTime;
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
}
