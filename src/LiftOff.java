/**
 * Created by Asus on 2017/10/23.
 */
public class LiftOff  implements Runnable{
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown=countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0?countDown:"LiftOff!")+"),";
    }
    public void run() {
            while (countDown-- > 0) {
                System.out.print(status());
//                Thread.sleep(1000);
            Thread.yield();
            }
    }
    public static void main(String[] args){
//        for(int i=0;i<5;i++){
//             new Thread(new LiftOff()).start();
//        }
//        System.out.println("waiting for liftoff");
        Thread d=new Thread(new LiftOff());
        d.start();
        for(int i=0;i<2009;i++)
        System.out.print("waiting for liftoff");
    }
}
