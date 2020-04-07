package Gui;

import Controle.ControleImpressora;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GuiCadastro extends JFrame {

    private JButton voltar, incluir;
    private JLabel nome, ip, unidade, modelo, serial, status, status2, titulo;
    private JTextField fnome, funidade, fmodelo, fserial;
    private JFormattedTextField ftip;

    public GuiCadastro() {
        iniciarComponente();
        iniciarEvento();

    }

    private void iniciarComponente() {
        setLayout(null);
        setBounds(0, 0, 400, 300);
        setTitle("Cadastrar Impressora");
        setResizable(false);
        titulo = new JLabel("Cadastrar Impressora");
        nome = new JLabel("Nome");
        unidade = new JLabel("Unidade");
        modelo = new JLabel("Modelo");
        serial = new JLabel("Serial");
        status = new JLabel("Status");
        status2 = new JLabel();
        voltar = new JButton("Voltar");
        incluir = new JButton("Incluir");
        fnome = new JTextField();
        funidade = new JTextField();
        fmodelo = new JTextField();
        fserial = new JTextField();
        ftip = new JFormattedTextField();
        ip = new JLabel("IP");
        ip.setBounds(10, 30, 50, 25);
        nome.setBounds(10, 60, 50, 25);
        unidade.setBounds(10, 90, 50, 25);
        modelo.setBounds(10, 120, 50, 25);
        serial.setBounds(10, 150, 50, 25);
        status.setBounds(10, 180, 50, 25);
        ftip.setBounds(70, 30, 300, 25);
        fnome.setBounds(70, 60, 300, 25);
        funidade.setBounds(70, 90, 300, 25);
        fmodelo.setBounds(70, 120, 300, 25);
        fserial.setBounds(70, 150, 300, 25);
        fserial.setEnabled(false);
        status2.setBounds(70, 180, 300, 25);
        titulo.setBounds(135, 0, 200, 25);
        voltar.setBounds(10, 220, 180, 25);
        incluir.setBounds(200, 220, 170, 25);
        add(voltar);
        add(incluir);
        add(ip);
        add(nome);
        add(unidade);
        add(modelo);
        add(serial);
        add(status);
        add(ftip);
        add(fnome);
        add(funidade);
        add(fmodelo);
        add(fserial);
        add(status2);
        add(titulo);
    }

    private void iniciarEvento() {

        incluir.addActionListener((ActionEvent e) -> {
            try {
                ControleImpressora imp = new ControleImpressora("teste.db");
                if (fnome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Falta inserir nome");
                }
                if (funidade.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Falta inserir Unidade");
                }
                if (fmodelo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Falta inserir Modelo");
                }
                if (ftip.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Falta inserir IP");
                }
                if (ftip.getText().contains("192.168") && ftip.getText().length() < 15) {
                    imp.inserirDadosImpressora(fnome.getText().trim().toUpperCase(), funidade.getText().trim().toUpperCase(), ftip.getText().trim().toUpperCase(), fserial.getText().trim().toUpperCase(), fmodelo.getText().trim().toUpperCase(), "");
                    fnome.setText(null);
                    funidade.setText(null);
                    ftip.setText(null);
                    fserial.setText(null);
                    fmodelo.setText(null);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Sequencia IP esta incorreta");
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(GuiCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        voltar.addActionListener((ActionEvent e) -> {
            this.dispose();

        });
    }

}
