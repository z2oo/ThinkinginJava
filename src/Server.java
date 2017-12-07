import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Application{
    @Override
    public void start(Stage primaryStage){
        TextArea ta=new TextArea();
        Scene scene=new Scene(new ScrollPane(ta),450,200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(()->{
            while(true) {
                try {
                    ServerSocket serverSocket = new ServerSocket(8000);
                    Platform.runLater(() ->
                            ta.appendText("Server started at" + new Date() + '\n'));
                    Socket socket = serverSocket.accept();

                    DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                    DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                    while (socket.isConnected()) {
                        double radius = inputFromClient.readDouble();
                        double area = radius * radius * Math.PI;
                        outputToClient.writeDouble(area);
                        Platform.runLater(() -> {
                            ta.appendText("Radius received rom client:" + radius + '\n');
                            ta.appendText("Area is" + area + '\n');
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
class ServerThread implements Runnable{
    @Override
    public void run(){

    }

}