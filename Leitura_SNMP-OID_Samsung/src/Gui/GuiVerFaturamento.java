package Gui;

import Controle.ControleFaturamento;
import Relatorio.GerarArquivoCSV;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GuiVerFaturamento extends JFrame {

    private JComboBox data;
    private JButton carregar, imprimir;
    private JLabel titulo;
    private GerarArquivoCSV rel = new GerarArquivoCSV("teste.db");

    public GuiVerFaturamento() throws SQLException, ClassNotFoundException {
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarComponentes() {
        setTitle("Faturamentos anteriores");
        setLayout(null);
        setBounds(0, 0, 350, 250);
        titulo = new JLabel("Escolha o Mes de referencia");
        titulo.setBounds(20, 20, 200, 25);
        data = new JComboBox();
        data.setBounds(20, 50, 130, 25);
        carregar = new JButton("Carregar");
        imprimir = new JButton("Visualizar Impressão");
        carregar.setBounds(20, 120, 130, 25);
        imprimir.setBounds(170, 120, 160, 25);
        imprimir.setVisible(false);
        data.setBackground(Color.white);
        add(carregar);
        add(titulo);
        add(data);
        add(imprimir);

    }

    private void iniciarEventos() throws SQLException, ClassNotFoundException {
        ControleFaturamento faturamento = new ControleFaturamento("teste.db");

        for (String f : faturamento.Datas()) {
            data.addItem(f);
        }

        carregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                imprimir.setVisible(true);
                JOptionPane.showMessageDialog(rootPane, "::Data carregada::\n"
                        + "Clique em visualizar impressão");
            }
        });

        imprimir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    String data_escolhida = data.getSelectedItem().toString();
                    data_escolhida = data_escolhida.trim();
                    data_escolhida = data_escolhida.substring(1, data_escolhida.length() - 1);

                    rel.ImprimeRelatorioFaturamento(data_escolhida);
                } catch (Exception ex) {
                    Logger.getLogger(GuiVerFaturamento.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

}
