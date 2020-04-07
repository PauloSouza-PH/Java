package Gui;

import Banco.Consultas;
import Banco.Remover;
import Classes.TabelaModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Principal extends JFrame {

    private JScrollPane scroll;
    private JTable tabela;
    private JMenu Menu;
    private JMenuBar bar;
    private JMenuItem item;
    private JButton Deletar;
    TabelaModel model;

    public Principal() {
        super("F.R.D.C");
        Componentes();
        Eventos();
    }

    private void Componentes() {
        //Propriedades do form
        setTitle("F.R.D.C");
        setLayout(null);
        setSize(new Dimension(900, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //--------------------------------------
        //Propriedade dos componentes
        scroll = new JScrollPane();
        tabela = new JTable();
        bar = new JMenuBar();
        Menu = new JMenu("Cadastro");
        item = new JMenuItem("Cadastrar");
        Deletar = new JButton("Remover Selecionado");
        //--------------------------------------
        model = new TabelaModel();
        Banco.Consultas c = new Consultas();
        model.addListaDeClientes(c.Consultar("SELECT * FROM vision"));
        //--------------------------------------
        Deletar.setBounds(670, 05, 200, 25);
        model.isCellEditable(-1, -1);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setModel(model);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll.setViewportView(tabela);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(new LineBorder(Color.red));
        scroll.setBounds(10, 40, 860, 380);
        Menu.add(item);
        bar.add(Menu);
        setJMenuBar(bar);
        add(scroll);
        add(Deletar);

    }

    private void Eventos() {
        tabela.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                model.limpar();
                model.addListaDeClientes(new Consultas().Consultar("SELECT * FROM vision"));
            }

            @Override
            public void focusLost(FocusEvent e) {
                model.limpar();
                model.addListaDeClientes(new Consultas().Consultar("SELECT * FROM vision"));
            }
        });

        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastro cd = new Cadastro();
                cd.setVisible(true);
            }
        });

        Deletar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do registro que deseja remover"));
                Remover rm = new Remover();
                rm.remover(id);

            }
        });

    }

}
