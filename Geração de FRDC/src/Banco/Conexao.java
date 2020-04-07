package Banco;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    public Connection conn;
    Statement st;
    ResultSet rs;

    public boolean Conexao() {

        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String senha = "12102607";
        String banco = "FRDC";
        String url = "jdbc:mysql://localhost/" + banco + "";
        boolean Result = true;

        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado em :" + conn.getHost() + "\nUsuario: " + usuario + "\nBase de dados: " + banco);
            st = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            Result = false;
            JOptionPane.showMessageDialog(null, "Erro ao Conectat no banco: " + banco + "\nUsuario :" + usuario + "\nEndereço: " + url + "\nErro apresentado~~" + e.getMessage());
        }

        return Result;
    }

    public void Close() {

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
