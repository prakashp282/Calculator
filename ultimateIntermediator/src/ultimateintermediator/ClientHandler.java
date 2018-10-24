package ultimateintermediator;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


// ClientHandler class 
class ClientHandler extends Thread  
{ 
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
      
  
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)  
    { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
    } 
  
    @Override
    public void run()
    { 
        String received; 
         Scanner scn = new Scanner(System.in); 
              
       
            try { 
                while (true)  
        {
                received = dis.readUTF(); 
                System.out.println(received);
                InterClient IC =new InterClient();
                String tosend=IC.action(received);
                dos.writeUTF(tosend); 
        }        
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
         finally{
            try {
                this.dis.close(); 
                this.dos.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    } 
} 
