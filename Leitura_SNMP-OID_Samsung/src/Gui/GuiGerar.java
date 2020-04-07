package Gui;

import Controle.ControleFaturamento;
import Dao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class GuiGerar extends JFrame {

    private JButton gerar;
    public static JProgressBar progresso;

    //teste Gitable
    public GuiGerar() {
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarComponentes() {
        setLayout(null);
        setTitle("Gerar Contador");
        setResizable(false);
        setBounds(0, 0, 250, 200);
        gerar = new JButton("Gerar Contadores");
        gerar.setBounds(25, 50, 200, 25);
        progresso = new JProgressBar();
        progresso.setBounds(25, 80, 200, 25);
        progresso.setMinimum(0);
        progresso.setMaximum(100);
        progresso.setStringPainted(true);
        add(gerar);
        add(progresso);

    }

    private void iniciarEventos() {
        gerar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String senha = JOptionPane.showInputDialog("Deseja realmente Gerar os contadores?\n\n"
                        + "::Favor informe sua senha::");
                if (senha.equals("morada48#")) {
                    try {
                        ControleFaturamento fatura = new ControleFaturamento("teste.db");
                        JOptionPane.showMessageDialog(null, "Processo poderá demorar");
                        fatura.GerarFaturamento();
                        progresso.setValue(100);
                    } catch (SQLException | ClassNotFoundException | IOException ex) {
                        Logger.getLogger(GuiGerar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Senha incorreta");
                }
            }
        });

    }

}
