package ultimateintermediator;

 
import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
 
public class InterClient  
{ 
 Socket s;
 DataInputStream dis;
 DataOutputStream dos;
 Scanner scn ;
    public InterClient() throws IOException  
    { 
        try
        { 
            s = new Socket("127.0.0.1", 5000); 
           dis = new DataInputStream(s.getInputStream()); 
           dos = new DataOutputStream(s.getOutputStream()); 
           scn= new Scanner(System.in); 
           
        }catch(Exception e){ 
            e.printStackTrace(); 
        }
        }
    
    String action(String tosend) throws IOException{
                dos.writeUTF(tosend);   
                String received = dis.readUTF(); 
                System.out.println(received); 
              
                dis.close(); 
                dos.close(); 
    
               return received;
    }
 
} 