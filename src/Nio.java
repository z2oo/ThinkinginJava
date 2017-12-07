import javax.xml.crypto.Data;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Nio {
    public static void main(String[] args){
        try {
            File file = new File("e:/text.txt");
            FileWriter fileWriter=new FileWriter(file,true);
            FileOutputStream outputStream=new FileOutputStream(file,true);
            fileWriter.append("ddd");
            outputStream.write('c');
            outputStream.flush();
            fileWriter.flush();
            fileWriter.close();
//            fileOutputStream.write(77);
            ExecutorService exec= Executors.newCachedThreadPool();

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
