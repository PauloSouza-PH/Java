package Dao;

import Modelos.Impressoras;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author paulosouza
 */
public class Conexao {

    Impressoras impressoras;

    private final Connection conn;
    public final Statement stm;

    public Conexao(String arquivo) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + arquivo);
        this.stm = this.conn.createStatement();
    }

    public void ConexaoClose() throws SQLException {

        stm.close();
    }

    public void reCriarTB() throws IOException {
        try {
            ConexaoClose();
            BackupBanco();
            this.stm.executeUpdate("DROP TABLE IF EXISTS TB_IMPRESSORAS");
            this.stm.executeUpdate("CREATE TABLE TB_IMPRESSORAS("
                    + "ID INTEGER PRIMARY KEY NOT NULL, "
                    + "NOME VARCHAR(20) NOT NULL,"
                    + "UNIDADE VARCHAR(20) NOT NULL,"
                    + "IP VARCHAR(16) NOT NULL,"
                    + "SERIAL VARCHAR(30),"
                    + "STATUS VARCHAR(3),"
                    + "MODELO VARCHAR(15) NOT NULL);");
            JOptionPane.showMessageDialog(null, "Banco de Dados Zerado e Construido"
                    + "\nFavor fechar o aplicativo e abrir novamente");

            this.stm.executeUpdate("DROP TABLE IF EXISTS TB_FATURAMENTO");
            this.stm.executeUpdate("CREATE TABLE TB_FATURAMENTO("
                    + "ID INTEGER PRIMARY KEY NOT NULL,"
                    + "DATA DATE NOT NULL,"
                    + "IP_IMPRESSORA VARCHAR(16) NOT NULL,"
                    + "CONTADOR VARCHAR(10),"
                    + "MODELO VARCHAR(30),"
                    + "SERIAL VARCHAR(30),"
                    + "NOME_GERADOR VARCHAR(30)"
                    + ");");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void BackupBanco() throws FileNotFoundException, IOException {
        File origem = new File("teste.db");
        FileInputStream fl = new FileInputStream(origem);
        File destino = new File("teste.db.bkp-" + data());
        FileOutputStream dt = new FileOutputStream(destino);

        int count = 0;

        byte[] bytes = new byte[1024];

        while ((count = fl.read(bytes)) >= 0) {
            dt.write(bytes, 0, count);
        }
    }

    public String data() {
        Date data = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        return dt.format(data);
    }

}
