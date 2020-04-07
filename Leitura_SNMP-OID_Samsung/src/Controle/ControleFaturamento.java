package Controle;

import Dao.Conexao;
import Modelos.Faturamento;
import Modelos.Impressoras;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControleFaturamento extends Conexao {

    ArrayList<Faturamento> faturamentos;
    Faturamento faturamento;

    public ControleFaturamento(String arquivo) throws SQLException, ClassNotFoundException {
        super(arquivo);
    }

    public void GerarFaturamento() throws SQLException, ClassNotFoundException, IOException {
        ControleImpressora imp = new ControleImpressora("teste.db");
        CalculosSNMP calc = new CalculosSNMP();
        String Nome = JOptionPane.showInputDialog("Digite seu nome");
        ResultSet rs;
        rs = stm.executeQuery("SELECT MAX(ID) FROM TB_FATURAMENTO");
        int id = rs.getInt(1);
        for (Impressoras pp : imp.exibirDadosImpressora()) {
            id = id + 1;
            String Contador = calc.consultar(pp.getIp(), "1.3.6.1.2.1.43.10.2.1.4.1.1");
            String modelo = calc.consultar(pp.getIp(), "1.3.6.1.2.1.25.3.2.1.3.1");
            String Serial = calc.consultar(pp.getIp(), "1.3.6.1.2.1.43.5.1.1.17.1");
            String sql = "INSERT INTO TB_FATURAMENTO(ID,DATA,IP_IMPRESSORA,CONTADOR,MODELO,SERIAL,NOME_GERADOR) VALUES ( " + id + ",'" + data() + "','" + pp.getIp() + "', '" + Contador + "','" + modelo + "','" + Serial + "','" + Nome.trim().toUpperCase() + "'    )";
            stm.executeUpdate("UPDATE TB_IMPRESSORAS SET MODELO = '" + modelo + "' WHERE IP = '" + pp.getIp() + "'");
            stm.executeUpdate("UPDATE TB_IMPRESSORAS SET SERIAL = '" + Serial + "' WHERE IP = '" + pp.getIp() + "'");
            if ("Sem comunicacao".equals(modelo)) {
                stm.executeUpdate("UPDATE TB_IMPRESSORAS SET STATUS = 'NOT' WHERE IP = '" + pp.getIp() + "'");
            } else {
                stm.executeUpdate("UPDATE TB_IMPRESSORAS SET STATUS = 'OK' WHERE IP = '" + pp.getIp() + "'");
            }
            stm.executeUpdate(sql);

        }
        JOptionPane.showMessageDialog(null, "Gerado!!");
    }

    public ArrayList<Faturamento> MostrarFaturamento() throws SQLException {
        faturamentos = new ArrayList<>();
        ResultSet rs;
        rs = stm.executeQuery("SELECT * FROM TB_FATURAMENTO");

        while (rs.next()) {
            faturamento = new Faturamento();
            faturamento.setData(rs.getString(2));
            faturamento.setImpressora(rs.getString(3));
            faturamento.setModelo(rs.getString(5));
            faturamento.setSerial(rs.getString(6));
            faturamento.setContadores(rs.getString(4));
            faturamento.setNome(rs.getString(7));
            faturamentos.add(faturamento);
        }
        rs.close();

        return faturamentos;

    }

    public ArrayList<String> Datas() throws SQLException {
        ResultSet rs;
        rs = stm.executeQuery("SELECT DATA FROM TB_FATURAMENTO GROUP BY DATA");
        ArrayList<String> datas = new ArrayList<>();
        while (rs.next()) {
            datas.add(rs.getString(1));
        }

        return datas;
    }

}
