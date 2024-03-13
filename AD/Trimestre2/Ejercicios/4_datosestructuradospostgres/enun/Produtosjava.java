package produtosjava;

import java.sql.*;

public class Produtosjava {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; // tambien puede ser una ip como "192.168.1.14"
        String porto = "5432";
        String sid = "postgres";
        String usuario = "vant";
        String password = "vant";
        String url = driver + host + porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url, usuario, password);
        return conn;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        conn = getConnection(); // crea un obxecto coneexion chamdo conn
        stmt = conn.createStatement();
        String prato = "select codigo,descricion,prezo,(ci).cidade,(ci).cp from produtos where (ci).cidade='vigo'";
        ResultSet resulset = null;
        ResultSet resulset2 = null;
        Statement stmt2 = conn.createStatement();
        resulset2 = stmt2.executeQuery(prato);

        while (resulset2.next()) {
            String codigo = resulset2.getString("codigo");
            double prezo = resulset2.getDouble("prezo");
            String cidade = resulset2.getString("cidade");
            int cp = resulset2.getInt("cp");
            System.out.println(codigo+prezo+cidade+cp);
        }
        
        
        
        String codigo = "p4";
        String descricion = "chalet";
        int prezo = 25;
        String cidade = "coruña";
        int codpost = 36222;
String cadeai = "insert into produtos(codigo,descricion,prezo,ci)"
        + " values ('" 
        + codigo + "','" 
        + descricion + "'," 
        + prezo + ",('" 
        + cidade + "'," 
        + codpost + ") )";
      //  stmt.executeUpdate(cadeai);
codigo="p1";       
String cadeau="update produtos set descricion='"+ descricion 
        +"', prezo="+prezo
        +" , ci.cidade='barna' where codigo='"+codigo+"'";
String cadeau2="update produtos set ci.cp=(ci).cp+1 where (ci).cidade='"+cidade+"'";

stmt.executeUpdate(cadeau2);

        conn.close();
    }

}
