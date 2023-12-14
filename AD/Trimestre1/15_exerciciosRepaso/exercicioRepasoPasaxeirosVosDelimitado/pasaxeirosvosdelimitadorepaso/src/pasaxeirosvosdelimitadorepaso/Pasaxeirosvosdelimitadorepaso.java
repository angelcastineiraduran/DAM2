/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pasaxeirosvosdelimitadorepaso;

import java.sql.Statement;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author ubuntu
 */
public class Pasaxeirosvosdelimitadorepaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        
        Pasaxeirosvosdelimitadorepaso pvlr = new Pasaxeirosvosdelimitadorepaso();
        
        // --A) LEER RESERVAS (reservas.txt)--
        
        // Directorio actual de tu programa
        String directorioActual = System.getProperty("user.dir");
            String rutaFicheroLeer = directorioActual + "/../enun/reservas.txt";
        BufferedReader lec = new BufferedReader(new FileReader(rutaFicheroLeer));
        String lectura = null;
        while((lectura = lec.readLine()) != null) {
            System.out.println(lectura);
            String reserva[] = lectura.split(",");
            boolean lineaCompletada = false;
            
            // --B) INSERTAR RESERVASFEITAS--
            int codr = -1, prezoreserva = -1;
            String dni = "", nome = "";
            for(int i = 0; i < reserva.length; i ++) {
                switch (i) {
                    case 0:
                        codr = Integer.parseInt(reserva[0]);
                        System.out.println("codr = " + codr);
                        break;
                    case 1:
                        dni = reserva[1];
                        System.out.println("dni = " + dni);
                        break;
                    case 2:
                        //nome = "";
                        nome = pvlr.nomePasaxeiro(dni);
                        //System.out.println("nome = " + nome);
                        break;
                    case 3:
                        int prezoIda = Integer.parseInt(reserva[2]);
                        int prezoVolta = Integer.parseInt(reserva[3]);
                        prezoreserva = pvlr.precioTotalVoo(prezoIda, prezoVolta, pvlr);
                        lineaCompletada = true;
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            lineaCompletada = true;
            if(lineaCompletada) {
                pvlr.insertarReservasFeitas(codr, dni, nome, prezoreserva);
                lineaCompletada = false;
            }
            
        }
        
        
        
    }
    
    public void insertarReservasFeitas(int codr, String dni, String nome, int prezoreserva) throws SQLException {
        Conexiones conexiones = new Conexiones();
        Connection conn = conexiones.conexion();
        String sql = "insert into reservasfeitas(codr, dni, nome, prezoreserva) values(?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, codr);
        pstmt.setString(2, dni);
        pstmt.setString(3, nome);
        pstmt.setInt(4, prezoreserva);
        pstmt.execute();
        System.out.println("Insert añadido");
        pstmt.close();
        conn.close();
    }
    
    public int precioVoo(int idVoo) throws SQLException {
        int valorDevolto = -1;
        Conexiones conexiones = new Conexiones();
        Connection conn = conexiones.conexion();
        String sql = "select * from voos where voo=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idVoo);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            valorDevolto = rs.getInt("prezo");
        }
        rs.close();
        pstmt.close();
        conn.close();
        return valorDevolto;
    }
    
    public int precioTotalVoo(int idIda, int idVolta, Pasaxeirosvosdelimitadorepaso pvdr) throws SQLException {
        return pvdr.precioVoo(idIda) + pvdr.precioVoo(idVolta);
    }
    
    public String nomePasaxeiro(String dni) throws SQLException {
        String valorDevolto = "";
        Conexiones conexiones = new Conexiones();
        Connection conn = conexiones.conexion();
        String sql = "select * from pasaxeiros where dni=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dni);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            valorDevolto = rs.getString("nome");
        }
        rs.close();
        pstmt.close();
        conn.close();
        return valorDevolto;
    }

}
