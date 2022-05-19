package Clases;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SocketCliente {
    
   static String mensaje="";
    conectar cc = new conectar();
    java.sql.Connection cn = cc.conexion();
  
    final int PUERTO = 5000;
    final int PUERTO2 = 5000;
    
        final String HOST = "10.10.4.81";
        final String HOST2 = "10.10.5.49";//Cambiar IP
        final String LOCAL = "10.10.6.60";

    public static void main(String[] args) {
    
        
        SocketCliente sc = new SocketCliente();
        System.out.println(" --> Cliente iniciado DELL");//Cambiar nombre de maquina
        
          sc.socketCliente();
          sc.socketCliente2();
                   
          System.out.println(" --> Cliente detenido DELL");
    }
    
  
    
    public void socketCliente(){
         
        
        DataInputStream in, in2;  // para las instrucciones de entrada cliente-seridor
        DataOutputStream out, out2;   // para las instrucciones de salida servidor-cliente

        try {
            Socket sc = new Socket(HOST, PUERTO);
            //Socket sc2 = new Socket(HOST2, PUERTO);

            in = new DataInputStream(sc.getInputStream()); //recibe/lee mensajes del cliente
            out = new DataOutputStream(sc.getOutputStream());
            

            out.writeUTF(mensaje); // manda mensaje al servidor 2
            //out2.writeUTF(mensaje);// manda mensaje al servidor 3
           
            System.out.println("Mensaje del cliente: " +mensaje);
            
            String respuesta = in.readUTF(); // recibe el mensaje del servidor
            //String respuesta2 = in2.readUTF(); // recibe el mensaje del servidor
            System.out.println("Respuesta del servidor: "+respuesta); // lee el mensaje

        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void socketCliente2(){
         
        
        DataInputStream in, in2;  // para las instrucciones de entrada cliente-seridor
        DataOutputStream out, out2;   // para las instrucciones de salida servidor-cliente

        try {
            Socket sc = new Socket(HOST2, PUERTO2);
            //Socket sc2 = new Socket(HOST2, PUERTO);

            in = new DataInputStream(sc.getInputStream()); //recibe/lee mensajes del cliente
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF(mensaje); // manda mensaje al servidor 2
            //out2.writeUTF(mensaje);// manda mensaje al servidor 3
           
            System.out.println("Mensaje del cliente: " +mensaje);
            
            String respuesta = in.readUTF(); // recibe el mensaje del servidor
            //String respuesta2 = in2.readUTF(); // recibe el mensaje del servidor
            System.out.println("Respuesta del servidor: "+respuesta); // lee el mensaje
           
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}