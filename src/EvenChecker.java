import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Asus on 2017/12/2.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;
    public EvenChecker(IntGenerator g,int idnet){
        generator=g;
        id=idnet;
    }
    public void run(){
        while(!generator.isCanceled()){
            int val=generator.next();
            if(val%2==0){
                System.out.println(val+" not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp,int count){
        System.out.println("Press Control-C to exit");
        ExecutorService exec= Executors.newSingleThreadExecutor();
        for(int i=0;i<count;i++){
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();
    }
    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
