import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LigaBD {
    
    String bd="dbuser";
    int porta = 3306;
    String user = "root";
    String password = "";    
    
    public boolean regista(String msg){
       Connection conexao;
        PreparedStatement ps=null;
	ResultSet rs=null;            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+bd+"?useTimezone=true&serverTimezone=UTC&" +"user=root&password=");
                System.out.println("Conectado!");
                String query=msg;
                System.out.println(query);
                ps=conexao.prepareStatement(query);
                ps.executeUpdate();    
                conexao.close();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Nada feito!");   

            }           
        return false;
    }

    public boolean pesquisa(String msg){
        String username;
        String senha;
       Connection conexao;
        PreparedStatement ps=null;
	ResultSet rs=null;            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+bd+"?useTimezone=true&serverTimezone=UTC&" +"user=root&password=");
                System.out.println("Conectado!");
                String query=msg;
                System.out.println(query);
                ps=conexao.prepareStatement(query);
            rs=ps.executeQuery(); 

            while(rs.next()){
                if (!rs.getString("pass").equals("")){
                    return true;
                }  
                
            }                
                conexao.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Nada feito!");   
            }
     return false;       
    }    
    
 }
    