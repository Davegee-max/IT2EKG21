package ekg;
import java.sql.Timestamp;

public class EKGData {
    private double sample;
    private Timestamp time;

    public EKGData(double sample, Timestamp time){
        this.sample = sample;
        this. time = time;
    }

    public double getSample() {
        return sample;
    }

    public void setSample(double sample) {
        this.sample = sample;
    }

    public Timestamp getTime() {
        return time;
    }
}
