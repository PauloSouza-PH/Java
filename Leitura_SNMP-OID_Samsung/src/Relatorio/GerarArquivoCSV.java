package Relatorio;

import Dao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class GerarArquivoCSV extends Conexao {

    public GerarArquivoCSV(String arquivo) throws SQLException, ClassNotFoundException {
        super(arquivo);
    }

    public void ImprimeRelatorioImpressora() throws JRException, Exception {

        try {
            ResultSet rs = stm.executeQuery("SELECT NOME,UNIDADE,IP,SERIAL,MODELO FROM TB_IMPRESSORAS;");
            String caminho = System.getProperty("user.dir");
            JasperReport report = JasperCompileManager.compileReport(caminho + "/Relatorio/RelatorioImpressoras.jrxml");
            JRResultSetDataSource result = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport(report, null, result);
            JasperViewer view = new JasperViewer(print);
            view.setVisible(true);

        } catch (SQLException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + ex);
        }
    }

    public void ImprimeRelatorioFaturamento(String data) throws JRException, Exception {

        try {
            ResultSet rs = stm.executeQuery("SELECT * FROM TB_FATURAMENTO WHERE DATA = '" + data + "' GROUP BY DATA");
            String caminho = System.getProperty("user.dir");
            JasperReport report = JasperCompileManager.compileReport(caminho + "/Relatorio/RelatorioFaturamento.jrxml");
            JRResultSetDataSource result = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport(report, null, result);
            JasperViewer view = new JasperViewer(print);
            view.setVisible(true);

        } catch (SQLException | JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + ex);
        }
    }

}
