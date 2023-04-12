package in.gov.aarogyasetu.server;

import in.gov.aarogyasetu.server.delegator.RequestDelegator;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Application
{

    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(30);

    public static void main(String[] args)
    {

        try (ServerSocket serverSocket = new ServerSocket(9090))
        {
            while (serverSocket.isBound())
            {
                Socket socket = serverSocket.accept();

                Runnable job = () -> {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter writer = new PrintWriter(socket.getOutputStream(), true))
                    {
                        writer.println(RequestDelegator.delegateRequest(new JSONObject(reader.readLine())));
                    }
                    catch (Exception exception)
                    {
                        System.out.println("Some Error Occurred! " + exception.getMessage());
                    }
                    finally
                    {
                        try
                        {
                            socket.close();
                        }
                        catch (IOException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                };
                THREAD_POOL.execute(job);
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

}
