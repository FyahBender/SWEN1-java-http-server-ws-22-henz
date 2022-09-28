package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {


    public static final int PORT = 10001;
    private ServerSocket server;

    private final Application application;

    public Server(Application application)
    {
        this.application = application;
    }


    public void start() throws IOException
    {
        System.out.println("Start Server..");
        server = new ServerSocket(PORT, 5);
        System.out.println("Server running at: http://localhost:" + PORT);


        run();

    }

    /*
    public String handle(String requestString) {

        Request request = RequestBuilder.build(requestString);
        Response response = this.application.handle(request);

        return response.toString();
    }
*/

    //yooooooooooooooooooooooooooo
    private void run() {
        while (true) {
            try {
                Socket socket = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


                Request request = RequestBuilder.build(in);

                Response response = application.handle(request);

                out.write(response.toString());

                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }









}
