package ConexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

public static Connection criaConexao() throws SQLException {
Connection cn = null;
try {
    Class.forName("org.gjt.mm.mysql.Driver");
    System.out.println("Driver carregado!!!");
    
    cn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/tccdb",
    "root", "");
    
    System.out.println("Conexão efetuada com sucesso!!!");
    
    } catch (ClassNotFoundException e){
        System.out.println("Driver não encontrado"); }
    return cn;
   }
}


