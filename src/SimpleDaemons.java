import java.util.concurrent.TimeUnit;

/**
 * Created by Asus on 2017/12/2.
 */
public class SimpleDaemons  implements Runnable{
    public void run(){
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }catch (InterruptedException e){
            System.out.print("sleep() interrupted");
        }
    }
    public static void main(String[] args) throws Exception{
        for(int i=0;i<10;i++){
            Thread daemon=new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemon started");
        TimeUnit.MICROSECONDS.sleep(99999999);
    }
}
