package MyPackage;
public class MyProcess {
    private int PID;
    private int arrivalTime;
    private int BurstTime;
    private int turnAroundTime;
    private int waitingTime;
    private int responseTime;
    private int startTime; 

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
    public int getResponseTime() {
        return responseTime;
    }
    public int getTurnAroundTime() {
        return turnAroundTime;
    }
    public int getWaitingTime() {
        return waitingTime;
    }
    public int getStartTime() {
        return startTime;
    }

    // setters
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public void setBurstTime(int burstTime) {
        BurstTime = burstTime;
    }
    public void decreaseBurstTimeBy(int t){
        BurstTime -= t;
    }
    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }
    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}
