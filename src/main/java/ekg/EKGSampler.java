package ekg;

public interface EKGSampler extends Runnable {
    void register(EKGListener listener);

}
