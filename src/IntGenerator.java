/**
 * Created by Asus on 2017/12/2.
 */
public abstract class IntGenerator {
    private  boolean canceled=false;
    public abstract int next();
    public void cancel(){
        canceled=true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
