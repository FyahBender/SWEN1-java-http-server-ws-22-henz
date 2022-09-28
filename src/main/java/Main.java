import application.DemoApp;
import server.Server;

import java.io.IOException;

public class Main {
    public static void main (String[] args)

    {
        Server server = new Server(new DemoApp());

        try {
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }







}

