/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pasaxeirosvoosserializadooracle_3;

import exa15brevep.Conexiones;
import exa15brevep.Consultas;
import exa15brevep.Platos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;


/**
 *
 * @author ubuntu
 */
public class Pasaxeirosvoosserializadooracle_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        Pasaxeirosvoosserializadooracle_3 p3 = new Pasaxeirosvoosserializadooracle_3();
        //Conexiones conn = new Conexiones();
        Consultas consultas = new Consultas();
        
        // --APARTADO A)--
        System.out.println("--APARTADO A)--");
        ArrayList reservas = p3.leerFicheroSerializado();
        reservas.forEach(reserva -> System.out.println(reserva));
        System.out.println("");
        
        // --APARTADO B)--
        System.out.println("--APARTADO B)--");
        
        // B1)
        System.out.println("--b1)--");
        ArrayList<Reserva> Reservas = new ArrayList();
        Reserva reserva;
        for(int i = 0; i < reservas.size(); i++) {
            reserva = (Reserva) reservas.get(i);
            int nreservas = consultas.buscarIntPorCodigo("nreservas", "dni", reserva.getDni(), "pasaxeiros");
            // actualizo en +1 el nreservas del dni solicitado
            //consultas.actualizarIntPorCodigo("public", "pasaxeiros", "nreservas", nreservas, "dni", reserva.getDni()); 
            if(nreservas > 0) {
                Reservas.add(reserva);
            }
        }
        
        // B2)
        // ** este codigo dara error si no borro previamente las filas ya que ya estan creadas **
        // esto lo hago con `TRUNCATE TABLE reservasfeitas;
        System.out.println("--b2)--");
        String sentenciaSQL = "INSERT INTO reservasfeitas (codr, dni, nome, prezoreserva) VALUES (?, ?, ?, ?)";
        Conexiones conexiones = new Conexiones();
        PreparedStatement pst = conexiones.conexion().prepareStatement(sentenciaSQL);
        int codr = 1;
        int filasInsertadas = 0;
        for(Reserva e : Reservas) {
            // codr
            pst.setInt(1, codr);
            // dni
            String dni = e.getDni();
            pst.setString(2, dni);
            // nome
            String nome = consultas.buscarStringPorCodigo("nome", "dni", dni, "pasaxeiros");
            pst.setString(3, nome);
            // prezoreserva
            int idIda = e.getIdvooida();
            int idVolta = e.getIdvoovolta();
            int prezoIda = consultas.buscarIntPorCodigoInt("prezo", "voo", idIda, "voos");
            int prezoVolta = consultas.buscarIntPorCodigoInt("prezo", "voo", idVolta, "voos");
            int prezoTotal = prezoIda + prezoVolta;
            pst.setInt(4, prezoTotal);
            codr++;
            filasInsertadas += pst.executeUpdate();
        }
        
        System.out.println("*** Se han insertado " + filasInsertadas + " filas ***");
        
    }
    
    // CONEXION
    public Connection conexion() throws SQLException {
        System.out.println("estableciendo conexion...");
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres"; // database-name
        String usuario = "dam2";
        String password = "dam2";
        String url = driver + host + porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url, usuario, password);
        return conn;
    }
    
    // SERIALIZACION
    String ruta_fich_serializado = 
            "/home/ubuntu/DAM2/AD/repaso/exercicioRepasoPasaxeiroVosSerializadoV3/enun/reservas";
    
    /**
     * 
     * @return codigo correcto si lo encuentra, si no lo encuentra devuelve null
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList leerFicheroSerializado() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList <Reserva> valoresEncontrados= new ArrayList();
        System.out.println("Abrimos flujo para leer fich serializado...");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ruta_fich_serializado)));
        
        System.out.println("Leo objetos serializado:...");        
        Reserva reserva;
        // tenemos que leer hasta que nos devuelva el obj null que esta en el fich serializado
        while ((reserva = (Reserva) ois.readObject()) != null) {
            valoresEncontrados.add(reserva);
        }
        ois.close();
        return valoresEncontrados;
    }
    

}
