package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import Relatorio.GerarArquivoCSV;

public class GuiRegistros extends JFrame {

    private JButton excluir;

    public GuiRegistros() {
        iniciarComponente();
        iniciarEvento();

    }

    private void iniciarComponente() {
        setTitle("Visualizar impressao");
        setLayout(null);
        setBounds(0, 0, 300, 100);
        setResizable(false);
        excluir = new JButton("Visualizar Impressão");
        excluir.setBounds(60, 20, 170, 25);
       
        add(excluir);
       
    }

    private void iniciarEvento() {
    

        excluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GerarArquivoCSV rel = new GerarArquivoCSV("teste.db");
                    rel.ImprimeRelatorioImpressora();

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(GuiRegistros.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GuiRegistros.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

}
