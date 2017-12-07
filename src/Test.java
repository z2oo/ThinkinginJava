import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args)  {
        long start=System.currentTimeMillis();
        int sum=1;
        for(long i=0;i<999999999;i++){
            sum*=i;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap()
    }
}