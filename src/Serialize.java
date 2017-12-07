import java.io.*;

/**
 * Created by Asus on 2017/11/29.
 */
public class Serialize implements Serializable {
    private static final long serialVersionUID=-6849794470754660011L;
    public int num=1390;
    public static void main(String[] args){
        try{
            FileOutputStream fos=new FileOutputStream("e:/serialize.dat");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            Serializable serializable=new Serialize();
            oos.writeObject(serializable);
            oos.flush();
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
