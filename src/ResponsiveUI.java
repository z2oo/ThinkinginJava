import com.sun.corba.se.spi.orbutil.threadpool.NoSuchThreadPoolException;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Asus on 2017/12/2.
 */
public class ResponsiveUI extends Thread {
    private static volatile double d=1;
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }
    public void run(){
        while (true){
            d=d+(Math.PI+Math.E)/d;
        }
    }
    public static void main(String[] args) throws Exception{
        new ResponsiveUI();
//        System.in.read();
        System.out.println(d);

    }

    public void in(int a) {

    }
}
