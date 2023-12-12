package MyPackage;

public class SharedTime {
    private int time;

    SharedTime(int t){
        time = t;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public void increment(int x){
        this.time += x;
    }
}
