package Controle;

import Dao.Conexao;
import Modelos.Impressoras;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControleImpressora extends Conexao {

    ArrayList<Impressoras> pp;
    Impressoras impressora;

    public ControleImpressora(String arquivo) throws SQLException, ClassNotFoundException {
        super(arquivo);

    }

    public void inserirDadosImpressora(String nome, String unidade, String ip, String serial, String modelo, String status) {
        ResultSet rs;
        if (nome.isEmpty() || unidade.isEmpty() || ip.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta a inserção de informações");
        } else {
            try {
                rs = this.stm.executeQuery("SELECT MAX(ID) FROM TB_IMPRESSORAS;");
                int idt = rs.getInt(1);
                int id = idt + 1;
                this.stm.executeUpdate("INSERT INTO TB_IMPRESSORAS(ID,NOME,UNIDADE,IP,SERIAL,MODELO,STATUS) VALUES (" + id + " , '" + nome + "','" + unidade + "','" + ip + "','" + serial + "','" + modelo + "','" + status + "');");
                JOptionPane.showMessageDialog(null, "Incluido com Sucesso");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }

    public ArrayList<Impressoras> exibirDadosImpressora() throws SQLException {
        pp = new ArrayList();

        ResultSet rs;
        try {
            rs = stm.executeQuery("SELECT * FROM TB_IMPRESSORAS");
            while (rs.next()) {
                impressora = new Impressoras();
                impressora.setIp(rs.getString(4));
                impressora.setNome(rs.getString(2));
                impressora.setUnidade(rs.getString(3));
                impressora.setSerial(rs.getString(5));
                impressora.setStatus(rs.getString(6));
                impressora.setModelo(rs.getString(7));
                pp.add(impressora);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return pp;

    }

    public void Deletar(String ip) throws SQLException {
        ip = ip.trim();
        String sql = "DELETE FROM TB_IMPRESSORAS WHERE IP = '" + ip + "' ;";
        stm.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Excluido com sucesso!!");
    }

}
