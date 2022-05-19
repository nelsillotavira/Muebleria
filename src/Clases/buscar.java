package Clases;

import Clases.Muebleria;
import Clases.conectar;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static Clases.SocketCliente.mensaje;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JoseAlberto
 */
public class buscar extends javax.swing.JFrame {
    
    TableRowSorter trs;
    
    void mostrardatos(String valor){
        DefaultTableModel modelo=new DefaultTableModel();
            modelo.addColumn("ID_VENTA");
            modelo.addColumn("ID_CLIENTE");
            modelo.addColumn("ID_MUEBLE");
            modelo.addColumn("CANTIDAD");
            modelo.addColumn("FECHA");
            modelo.addColumn("TOTAL");
            tbVentas.setModel(modelo);
            String sql="";
            if(valor.equals("")){
                sql="SELECT * FROM ventas";
            }else{
                sql="SELECT * FROM ventas WHERE total="+valor+"";
            
            }

String []datos = new String [6];
try {
Statement st = cn.createStatement();
ResultSet rs = st.executeQuery(sql);
while(rs.next()) {
datos [0] = rs.getString(1);
datos [1] = rs.getString(3);
datos [2] = rs.getString(2);
datos [3] = rs.getString(4);
datos [4] = rs.getString(5);
datos [5] = rs.getString(6);
modelo.addRow(datos);
}
tbVentas.setModel(modelo);
} catch (SQLException ex) {
Logger.getLogger(InventarioT.class.getName()).log(Level.SEVERE, null, ex);
}
}
    
    conectar cc = new conectar();
    java.sql.Connection cn = cc.conexion();

    boolean existencia = false, conexion = false, validacion = false,empleados=false,libros=false;
    String id_mueble, nombre, sql, nomTabla, nomTb, respuesta, precio;

    // final String HOST = "10.10.4.85";  // hace referencia a la máquina del servidor
    final int PUERTO = 5000, PUERTO2 = 5000; 
    
    final String LOCAL = "10.10.6.60";
    final String HOST = "10.10.4.81";
    final String HOST2 = "10.10.5.49";//Cambiar IP
    // String HOST = "10.10.4.59";
    //String HOST = "192.168.0.7";

    DefaultTableModel modelo = new DefaultTableModel();
    String[] datos = new String[2];

    public buscar() {
        initComponents();
        System.out.println("Cliente iniciado DELL");
        mensaje = " Cliente iniciado DELL ";
        // sockerCliente();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        modificar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        buscarS2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tLocal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRes3 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtRes2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buscarS4 = new javax.swing.JButton();
        txtBuscar1 = new javax.swing.JTextField();

        modificar.setText("jMenuItem1");
        jPopupMenu1.add(modificar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar Muebles");
        setLocation(new java.awt.Point(400, 175));

        tbVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbVentas.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbVentas);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Ingresa dato");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buscarS2.setText("Solicitar");
        buscarS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarS2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Ventas");

        jLabel6.setText("CONEXION / SOLICITUD");

        jLabel3.setText("IP Local");

        txtRes3.setColumns(20);
        txtRes3.setRows(5);
        jScrollPane2.setViewportView(txtRes3);

        txtRes2.setColumns(20);
        txtRes2.setRows(5);
        jScrollPane3.setViewportView(txtRes2);

        jLabel2.setText("Proveedor");

        jLabel4.setText("Almacen");

        buscarS4.setText("Solicitar");
        buscarS4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarS4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 763, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(buscarS4)
                                .addGap(17, 17, 17)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarS2)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(tLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buscarS2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buscarS4)
                                .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        mostrardatos(txtbuscar.getText());
    }//GEN-LAST:event_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Muebleria a = new Muebleria();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarS2ActionPerformed
        String valor = txtBuscar1.getText();
        
        socketCliente();
    }//GEN-LAST:event_buscarS2ActionPerformed

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        txtbuscar.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(final KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtbuscar.getText(), 1)); 
            }
        });
                trs = new TableRowSorter(tbVentas.getModel());
                tbVentas.setRowSorter(trs);
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void buscarS4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarS4ActionPerformed
       String valor = txtBuscar1.getText();
        
        socketCliente2(valor);
    }//GEN-LAST:event_buscarS4ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton buscarS2;
    private javax.swing.JButton buscarS4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JLabel tLocal;
    private javax.swing.JTable tbVentas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextArea txtRes2;
    private javax.swing.JTextArea txtRes3;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
 public void conectar() {
        if (cn == null) {
            JOptionPane.showMessageDialog(null, "No conectado");
            conexion = false;
        } else {
            //JOptionPane.showMessageDialog(null, "Conectado");
            conexion = true;
        }
    }
    
    
    public void MostrarTabla2(String columna1, String columna2, String columna3) {
        //    DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");

        //  String[] datos = new String[2];
        datos[0] = columna1;
        System.out.println("columna1: " + columna1);
        datos[1] = columna2;
        System.out.println("columna2: " + columna2);
        modelo.addRow(datos);
        System.out.println("columna3: " + columna3);
        modelo.addRow(datos);

        //tbDatosTabla2.setModel(modelo);
    }
    
    public void socketCliente(){
         
        mensaje="SELECT * FROM proveedores";// WHERE nombre='" + valor + "'";
        DataInputStream in;  // para las instrucciones de entrada cliente-seridor
        DataOutputStream out;   // para las instrucciones de salida servidor-cliente

        try {
            Socket sc = new Socket(HOST, PUERTO);
            //Socket sc2 = new Socket(HOST2, PUERTO);

            in = new DataInputStream(sc.getInputStream()); //recibe/lee mensajes del cliente
            out = new DataOutputStream(sc.getOutputStream());
            
            //in2 = new DataInputStream(sc2.getInputStream()); //recibe/lee mensajes del cliente
            //out2 = new DataOutputStream(sc2.getOutputStream());

            out.writeUTF(mensaje); // manda mensaje al servidor 2
            //out2.writeUTF(mensaje);// manda mensaje al servidor 3
           
            System.out.println("Mensaje del cliente: " +mensaje);
            
            String respuesta = in.readUTF(); // recibe el mensaje del servidor
            //String respuesta2 = in2.readUTF(); // recibe el mensaje del servidor
            System.out.println("Respuesta del servidor: "+respuesta); // lee el mensaje
            //System.out.println("Respuesta del servidor: "+respuesta2); // lee el mensaje
            txtRes2.setText(respuesta.replace(',', '\n')); // lee el mensaje)
            //JOptionPane.showMessageDialog(null, respuesta);
           /*if(respuesta.equals("")){
               sc.close();
           }*/
           
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void socketCliente2(String valor){
         
        mensaje="SELECT * FROM inventario WHERE nombre='" + valor + "'";
        DataInputStream in;// para las instrucciones de entrada cliente-seridor
        DataOutputStream out;   // para las instrucciones de salida servidor-cliente

        try {
            Socket sc = new Socket(HOST2, PUERTO2);
            //Socket sc2 = new Socket(HOST2, PUERTO);

            in = new DataInputStream(sc.getInputStream()); //recibe/lee mensajes del cliente
            out = new DataOutputStream(sc.getOutputStream());
            
            //in2 = new DataInputStream(sc2.getInputStream()); //recibe/lee mensajes del cliente
            //out2 = new DataOutputStream(sc2.getOutputStream());

            out.writeUTF(mensaje); // manda mensaje al servidor 2
            //out2.writeUTF(mensaje);// manda mensaje al servidor 3
           
            System.out.println("Mensaje del cliente: " +mensaje);
            
            String respuesta = in.readUTF(); // recibe el mensaje del servidor
            //String respuesta2 = in2.readUTF(); // recibe el mensaje del servidor
            System.out.println("Respuesta del servidor: "+respuesta); // lee el mensaje
            //System.out.println("Respuesta del servidor: "+respuesta2); // lee el mensaje
            txtRes3.setText(respuesta.replace(',', '\n'));
            //JOptionPane.showMessageDialog(null, respuesta);
           /*if(respuesta.equals("")){
               sc.close();
           }*/
           
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
