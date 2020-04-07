package Gui;

import Controle.ControleImpressora;
import Dao.Conexao;
import Modelos.Impressoras;
import Relatorio.GerarArquivoCSV;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class GuiPrincipal extends JFrame {

    private JTable tabela;
    private JScrollPane barraRolagem;
    private JMenuBar menuBarra;
    private JMenu Operacoes, Faturamento, recriarTabelas;
    private JMenuItem cadastrarImpressora, consultarRegistroImpressora, recriar, removerImpressoras, gerarFaturamento, verFaturamentoAnterior;
    ControleImpressora imp;
    DefaultTableModel modelo;
    GerarArquivoCSV rel = new GerarArquivoCSV("teste.db");

    public GuiPrincipal() throws SQLException, ClassNotFoundException {
        iniciarComponentes();
        iniciarEventos();
    }

    private void iniciarComponentes() throws SQLException, ClassNotFoundException {
        setTitle("Faturamento de Impressoras");
        setResizable(false);
        setLayout(null);
        setBounds(0, 0, 510, 600);
        menuBarra = new JMenuBar();
        Operacoes = new JMenu("Operacoes");
        Faturamento = new JMenu("Faturamento");
        recriarTabelas = new JMenu("Opções Administrativas");
        cadastrarImpressora = new JMenuItem("Cadastrar");
        removerImpressoras = new JMenuItem("Remover");
        gerarFaturamento = new JMenuItem("Gerar Faturamento");
        consultarRegistroImpressora = new JMenuItem("Consultar Impressoras Registradas");
        verFaturamentoAnterior = new JMenuItem("Faturamento Anterior");
        recriar = new JMenuItem("Recriar Banco de Dados");
        Faturamento.add(gerarFaturamento);
        Faturamento.add(verFaturamentoAnterior);
        Operacoes.add(cadastrarImpressora);
        Operacoes.add(removerImpressoras);
        recriarTabelas.add(recriar);
        recriarTabelas.add(consultarRegistroImpressora);
        menuBarra.add(Operacoes);
        menuBarra.add(Faturamento);
        menuBarra.add(recriarTabelas);
        setJMenuBar(menuBarra);
        barraRolagem = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        modelo = new DefaultTableModel();
        modelo.addColumn("IP");
        modelo.addColumn("Nome");
        modelo.addColumn("Unidade");
        modelo.addColumn("Serial");
        modelo.addColumn("Status");
        modelo.addColumn("Modelo");
        modelo.isCellEditable(-0, -0);
        tabela.setModel(modelo);
        barraRolagem.setViewportView(tabela);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(barraRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(barraRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );

        pack();
        //tabela.setAutoResizeMode(AUTO_RESIZE_OFF);
        tabela.setEnabled(false);
        tabela.getTableHeader().setReorderingAllowed(false);
        CarregarDados();
    }

    private void iniciarEventos() throws SQLException, ClassNotFoundException {
        cadastrarImpressora.addActionListener((ActionEvent e) -> {
            GuiCadastro gui = new GuiCadastro();
            gui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle r = gui.getBounds();
            int width1 = r.width;
            int height1 = r.height;
            int posx = (d.width / 2) - (width1 / 2);
            int posy = (d.height / 2) - (height1 / 2);
            gui.setBounds(posx, posy, width1, height1);
            gui.setVisible(true);
        });

        recriar.addActionListener((ActionEvent e) -> {
            String senha = JOptionPane.showInputDialog(":::Recriar tabelas:::\nDigite sua Senha para Prosseguir::");
            if ("morada48#".equals(senha)) {

                try {
                    Conexao con = new Conexao("teste.db");
                    con.reCriarTB();
                } catch (SQLException | ClassNotFoundException | IOException ex) {
                    Logger.getLogger(GuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Senha incorreta,\nEntre em contato com o Fabricante");
            }
        });

        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                try {
                    CarregarDados();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(GuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    CarregarDados();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(GuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        removerImpressoras.addActionListener((ActionEvent e) -> {
            GuiRemover gui = new GuiRemover();
            gui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle r = gui.getBounds();
            int width1 = r.width;
            int height1 = r.height;
            int posx = (d.width / 2) - (width1 / 2);
            int posy = (d.height / 2) - (height1 / 2);
            gui.setBounds(posx, posy, width1, height1);
            gui.setVisible(true);
        });

        gerarFaturamento.addActionListener((ActionEvent e) -> {
            GuiGerar gui = new GuiGerar();
            gui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle r = gui.getBounds();
            int width1 = r.width;
            int height1 = r.height;
            int posx = (d.width / 2) - (width1 / 2);
            int posy = (d.height / 2) - (height1 / 2);
            gui.setBounds(posx, posy, width1, height1);
            gui.setVisible(true);
        });
        verFaturamentoAnterior.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                GuiVerFaturamento gui;
                try {
                    gui = new GuiVerFaturamento();
                    gui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                    Rectangle r = gui.getBounds();
                    int width1 = r.width;
                    int height1 = r.height;
                    int posx = (d.width / 2) - (width1 / 2);
                    int posy = (d.height / 2) - (height1 / 2);
                    gui.setBounds(posx, posy, width1, height1);
                    gui.setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(GuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    @SuppressWarnings("empty-statement")
    public void CarregarDados() throws SQLException, ClassNotFoundException {
        modelo.setRowCount(0);
        imp = new ControleImpressora("teste.db");
        for (Impressoras pp : imp.exibirDadosImpressora()) {
            modelo.addRow(new Object[]{
                pp.getIp(),
                pp.getNome(),
                pp.getUnidade(),
                pp.getSerial(),
                pp.getStatus(),
                pp.getModelo()
            });
        };

        consultarRegistroImpressora.addActionListener((ActionEvent e) -> {
            GuiRegistros gui = new GuiRegistros();
            gui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle r = gui.getBounds();
            int width1 = r.width;
            int height1 = r.height;
            int posx = (d.width / 2) - (width1 / 2);
            int posy = (d.height / 2) - (height1 / 2);
            gui.setBounds(posx, posy, width1, height1);
            gui.setVisible(true);
        });

    }

}
