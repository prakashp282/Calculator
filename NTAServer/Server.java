import java.net.*; 
import java.io.*; 
  
public class Server 
{ 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 
  
    public Server(int port) 
    { 
        try
        { 
            server = new ServerSocket(port); 
             socket = server.accept(); 
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
  
            String line = ""; 
                try
                { 
                    line = in.readUTF(); 
                    System.out.println(line); 
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            socket.close(); 
            in.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        Server server = new Server(5000); 
    } 
} 