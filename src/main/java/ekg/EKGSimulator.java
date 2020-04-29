package ekg;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class EKGSimulator implements EKGSampler, Runnable {
    private EKGListener listener;

    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
                if(listener !=null){
                    LocalDateTime now = LocalDateTime.now();
                    listener.notify(
                            new EKGData(Math.random()*1000, new Timestamp(LocalDateTime.now().getNano()/1000)));
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
    @Override
    public void register(EKGListener listener){
        this.listener = listener;
    }
}
