package Gui;

import Controle.ControleImpressora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Modelos.Impressoras;

public class GuiRemover extends JFrame {
    
    private JLabel ip;
    private JButton excluir, voltar;
    private JFormattedTextField fip;
    
    public GuiRemover() {
        iniciarComponente();
        iniciarEvento();
        
    }
    
    private void iniciarComponente() {
        setTitle("Remover impressora");
        setLayout(null);
        setBounds(0, 0, 300, 150);
        setResizable(false);
        ip = new JLabel("IP");
        fip = new JFormattedTextField();
        excluir = new JButton("Excluir");
        voltar = new JButton("Voltar");
        ip.setBounds(10, 30, 50, 25);
        fip.setBounds(110, 30, 170, 25);
        excluir.setBounds(10, 80, 100, 25);
        voltar.setBounds(180, 80, 100, 25);
        
        add(ip);
        add(fip);
        add(excluir);
        add(voltar);
        
    }
    
    private void iniciarEvento() {
        voltar.addActionListener((ActionEvent e) -> {
            this.dispose();
        });
        
        excluir.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ControleImpressora imp = new ControleImpressora("teste.db");
                    
                    for (Impressoras pp : imp.exibirDadosImpressora()) {
                        if (pp.getIp().equals(fip.getText().trim())) {
                            String mensagem = "Deseja realmente exluir?\n"
                                    + pp.getNome() + "\n"
                                    + pp.getModelo() + "\n"
                                    + pp.getUnidade() + "\n\n";
                            int resposta = JOptionPane.showConfirmDialog(null, mensagem, "Confirmação", JOptionPane.YES_NO_OPTION);
                            if (resposta == JOptionPane.YES_OPTION) {
                                imp.Deletar(fip.getText());
                                fip.setText(null);
                            } else if (resposta == JOptionPane.NO_OPTION) {
                                fip.setText(null);
                            }
                            
                        }
                        
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(GuiRemover.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GuiRemover.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
    }
    
}
