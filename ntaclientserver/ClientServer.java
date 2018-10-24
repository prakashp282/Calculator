
// A Java program for a Client 
import java.net.*; 
import java.io.*; 
  
public class ClientServer 
{ 
      private Socket socket            = null; 
    private DataInputStream  input   = null; 
    private DataOutputStream out     = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null;
  
  
    String Ser(int port) 
    { 
   // private Socket socket   = null; 
  
                    String line = ""; 

  
        try
        { 
            server = new ServerSocket(port); 
             socket = server.accept(); 
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
  
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
                    return line;

    } 
    
    void Cli(String a,String address, int port) 
  {
  

      try
        { 
            socket = new Socket(address, port); 
            input  = new DataInputStream(System.in); 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        
            try
            { 
 
                out.writeUTF(a); 
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
         
  
        // close the connection 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        String a="";
        ClientServer client = new ClientServer();
        a=client.Ser(5001);
        client.Cli(a,"127.0.0.1",5000);
    } 
}