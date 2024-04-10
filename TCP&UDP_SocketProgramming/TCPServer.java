import java.io.*;
import java.net.*;

class TCPServer
{
	String text;
    ServerSocket server;
	
	public TCPServer()
	{
            try{
                    server = new ServerSocket(7000);
            
            System.out.println("Server is starting...");
            
           Socket socket = server.accept();
            
            BufferedReader stream_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream stream_out = new DataOutputStream(socket.getOutputStream());
            while(true)
            {
            text = stream_in.readLine();
            System.out.println("Received: " + text);

            text = text.toUpperCase() + '\n';
           stream_out.writeBytes(text);
            }
            }
            catch(Exception e) {e.printStackTrace();}
         }
	
   public static void main(String argv[]) 
        {
        new TCPServer();
        }
}  
