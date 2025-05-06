import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceDao {
    private Connection connection;
	
	// método Construtor
    public ServiceDao(){this.connection = new ConnectionFactory().getConnection ();}
    
    // método getAllBath
    public ArrayList<Bath> getAllBath() {        
        ArrayList<Bath> baths = new ArrayList<> ();        
        String sql1 = "SELECT * FROM PETSERVICES WHERE SERVICE = 'banho'";
        
        try {
            
            PreparedStatement statement = this.connection.prepareStatement (sql1);
            ResultSet results = statement.executeQuery ();
            System.out.println ("------Banhos Cadastrados------");
            
            
            while (results.next()){
                Service bath = new Bath();
                bath.setOwnerName (results.getString("OWNER"));
                bath.setPetName (results.getString ("PETNAME"));
                ((Bath) bath).setDuration(results.getInt ("DURATION"));
                bath.setPrice (results.getBigDecimal("PRICE").doubleValue());
                baths.add((Bath) bath);            
            }
            
            results.close ();
            statement.close();            
        
        } catch (SQLException ex){
            System.out.println ("Algo saiu errado.\nErr:" + ex);
            
        }
        return baths;
    }
    
    // mmétodo printBaths
    public void printBaths(ArrayList<Bath> baths){
        for (Bath bath : baths){
            System.out.printf ("\tProprietário: %s\n"
                    + "\tPet: %s\n\tDuração: %d min\n"
                    + "\tPreço: R$%.2f\n-------------\n",bath.getOwnerName(),
                    bath.getPetName(),
                    bath.getDuration(), bath.getPrice());
        }
    }
    
    // método getBath: lê dados do usuário e os usa para instanciar Bath
    public Bath getBath(){
        System.out.println ("\tCadastre um novo serviço: ");
        Scanner read = new Scanner(System.in);
        System.out.println ("Nome do pet: ");
        String pet = read.nextLine();
        System.out.println("Seu nome: ");
        String owner = read.nextLine();
        
        Bath newBath = new Bath(pet, owner, 50.00, 30);
        return newBath;
    }
    
    // método insertBath
    public boolean insertBath(Bath bath){
        String addSql = "INSERT INTO PETSERVICES(PETNAME, SERVICE, DURATION, PRICE, OWNER) VALUES"
                + "(?, 'banho', ?, ?, ?)";
        try{
            PreparedStatement statement = this.connection.prepareStatement(addSql);
            statement.setString (1, bath.getPetName());
            statement.setInt (2, bath.getDuration());
            statement.setBigDecimal(3, BigDecimal.valueOf(bath.getPrice()));
            statement.setString(4, bath.getOwnerName ());
            
            int linha = statement.executeUpdate();
            return linha == 1;
        } catch (SQLException ex){
            System.out.println ("Erro em insertBath()\n" + ex);
            return false;
        }
    }
    
}
