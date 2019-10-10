import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LigaBD {
    
    String bd="quizz";
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

    public boolean pesquisa(){
        String username;
        String senha;
        QuizCencal q = new QuizCencal();
       Connection conexao;
        PreparedStatement ps=null;
	ResultSet rs=null;            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+bd+"?useTimezone=true&serverTimezone=UTC&" +"user=root&password=");
                System.out.println("Conectado!");
                
                String query="SELECT * FROM `dici` WHERE `categoryId`='"+q.category+"' order by rand()";
                System.out.println(query);
                ps=conexao.prepareStatement(query);
            rs=ps.executeQuery(); 

            while(rs.next()){
                //System.out.println("entrou no while!\n");
                if (!rs.getString("ingles").equals("")){
                    //System.out.println("ID -"+rs.getString("id"));
                    if (q.language == 1)
                        q.registos.add(rs.getString("ingles"));
                    else{
                        q.registos.add(rs.getString("esperanto"));  
                        q.registos2.add(rs.getString("ingles"));                           
                    }
                      
                }  
            
            }                
            //System.out.println("lista de palavras -"+q.registos);
            conexao.close();
                    return true;    
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Nada feito!");   
            }
     return false;       
    }    
    
 }
    