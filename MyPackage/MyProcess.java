package MyPackage;
public class MyProcess {
    private int PID;
    private int arrivalTime;
    private int BurstTime;
    

    public MyProcess(int arrivalTime,int BurstTime, int PID){
        if(PID<0 || arrivalTime<0 || BurstTime <0)
            throw new ArithmeticException("PID, arrival time or burst time is negative");
        this.PID = PID;
        this.BurstTime = BurstTime;
        this.arrivalTime = arrivalTime;
    }

    // getters

    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getBurstTime() {
        return BurstTime;
    }
    public int getPID() {
        return PID;
    }

    // setters
    public void setBurstTime(int burstTime) {
        BurstTime = burstTime;
    }
    public void decreaseBurstTimeBy(int t){
        BurstTime -= t;
    }
}
