import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection(){
        try{        
            Connection connection = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/PetShopDB", "app", "app"
            );            
            System.out.println ("-----------------\n"
                    + "\tConexão com PetShopDB bem sucedida"
                    + "\n-----------------\n");            
            return connection;            
            } catch (SQLException ex){System.out.println ("Falha ao conectar\nErro: " + ex);
            
            }
    return null;
    }
}
