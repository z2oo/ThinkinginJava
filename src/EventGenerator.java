/**
 * Created by Asus on 2017/12/2.
 */
public class EventGenerator extends IntGenerator {

    public  int  next(){
        int currentEvent=0;
        ++currentEvent;
        Thread.yield();
        ++currentEvent;
        return currentEvent;
    }
    public static void main(String[] args){
        EvenChecker.test(new EventGenerator());

    }
}
