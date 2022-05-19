package Clases;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SocketServidor {

    conectar cc = new conectar();
    java.sql.Connection cn = cc.conexion();

    boolean conexion;
    String respuesta = "";
    String msj = "";

    ServerSocket servidor = null;
    Socket sc = null;
    DataInputStream in;
    DataOutputStream out;
    
    final int PUERTO = 5000;
    
    boolean validacion = true;

    public static void main(String[] args) {
        SocketServidor obj = new SocketServidor();
        obj.conectar();
        obj.socketServidor();
        
       
    }

    public void conectar() {
        if (cn == null) {
            JOptionPane.showMessageDialog(null, "No conectado");
            conexion = false;
        } else {
            //JOptionPane.showMessageDialog(null, "Conectado");
            conexion = true;
        }
    }
    
    public void socketServidor(){
         if (conexion) {

            ServerSocket servidor = null;
            Socket sc = null;   // socket del cliente
            DataInputStream in;  // para las instrucciones de entrada cliente-seridor
            DataOutputStream out;   // para las instrucciones de salida servidor-cliente
            //final int PUERTO = 5000;

            try {
                servidor = new ServerSocket(PUERTO);
                System.out.println("------------------- Servidor iniciado DELL ------------------- ");

                // servidor siempre escuchando
                while (true) {
                    // se queda esperando, no continua si no tiene respuesta del cliente
                    sc = servidor.accept();

                    in = new DataInputStream(sc.getInputStream()); //recibe/lee mensajes del cliente
                    out = new DataOutputStream(sc.getOutputStream());

                    msj = in.readUTF();  //lee el mensaje

                    if(msj.contains("Bye")){
                    //if (mensaje.equals("Bye")) {
                        out.writeUTF("Desconectado de servidor DELL");
                        sc.close(); //cerramos/desconectamos el cliente
                        System.out.println("Mensaje del cliente: "+msj);
                        System.out.println("Respuesta del servidor: Desconectado de servidor DELL");
                        System.out.println("------------------- Servidor apagado DELL ------------------- ");
                        //break;

                    } else {

                        System.out.println("Mensaje del cliente: " + msj); //imprim el mensaje
                        System.out.print("Respuesta del servidor:");

                        out.writeUTF(respuesta); // manda/escribe un mensaje al cliente

                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
}
