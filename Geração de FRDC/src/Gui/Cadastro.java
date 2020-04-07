/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Banco.Insercao;
import Funcoes.Calculos;
import Modelo.Cliente;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author Paulo
 */
public class Cadastro extends JFrame {

    private JButton Confirmar, Calcular;
    private JTextField Nome, Idade, Estatura, Peso, Abdom, Quad, Colesterol, Glicose, HDL, LDL, Funcao, Tempo, RQC, CRQC, SitGlicose, indConicidade;
    private JLabel lNome, lIdade, lSexo, lEstatura, lPeso, lAbdom, lQuad, lColesterol, lGlicose, lHDL, lLDL, lFuncao, lTempo;
    private JRadioButton sexoM, sexoF;
    private ButtonGroup grupo;
    static int Linha, Altura;
    private boolean bIdade, bSexo, bEstatura, bGlicose, bPeso, bPqua, bPabd = false;
    String sexo;

    public Cadastro() {
        Componentes();
        Eventos();
    }

    private void Componentes() {
        setTitle("Cadastro");
        setLayout(null);
        setSize(new Dimension(500, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //-----------------------------------------
        int Coluna = 10;
        Linha = 10;
        Altura = 25;
        int largura = 100;
        //------------------------------------------
        Confirmar = new JButton("Confirmar");
        Calcular = new JButton("Calcular");
        sexoM = new JRadioButton("Masculino");
        sexoF = new JRadioButton("Feminino");
        grupo = new ButtonGroup();
        Nome = new JTextField();
        Idade = new JTextField();
        Estatura = new JTextField();
        Peso = new JTextField();
        Abdom = new JTextField();
        Quad = new JTextField();
        Colesterol = new JTextField();
        Glicose = new JTextField();
        HDL = new JTextField();
        LDL = new JTextField();
        Funcao = new JTextField();
        RQC = new JTextField();
        CRQC = new JTextField();
        SitGlicose = new JTextField();
        indConicidade = new JTextField();
        Tempo = new JTextField();
        lNome = new JLabel("Nome");
        lIdade = new JLabel("Idade");
        lSexo = new JLabel("Sexo");
        lEstatura = new JLabel("Estatura");
        lPeso = new JLabel("Peso");
        lAbdom = new JLabel("Abdomen");
        lQuad = new JLabel("Quadril");
        lColesterol = new JLabel("Colesterol");
        lGlicose = new JLabel("Glicose");
        lHDL = new JLabel("HDL");
        lLDL = new JLabel("LDL");
        lFuncao = new JLabel("Funcao");
        lTempo = new JLabel("Tempo");
        //------------------------------------------
        grupo.add(sexoM);
        grupo.add(sexoF);
        sexoF.setBounds(85, 115, largura, Altura);
        sexoM.setBounds(195, 115, largura, Altura);
        lNome.setBounds(Coluna, C(), largura, Altura);
        lIdade.setBounds(Coluna, C(), largura, Altura);
        lSexo.setBounds(Coluna, C(), largura, Altura);
        lEstatura.setBounds(Coluna, C(), largura, Altura);
        lPeso.setBounds(Coluna, C(), largura, Altura);
        lAbdom.setBounds(Coluna, C(), largura, Altura);
        lQuad.setBounds(Coluna, C(), largura, Altura);
        lColesterol.setBounds(Coluna, C(), largura, Altura);
        lGlicose.setBounds(Coluna, C(), largura, Altura);
        lHDL.setBounds(Coluna, C(), largura, Altura);
        lLDL.setBounds(Coluna, C(), largura, Altura);
        lFuncao.setBounds(Coluna, C(), largura, Altura);
        lTempo.setBounds(Coluna, C(), largura, Altura);
        //---------------------------------------------
        Coluna = Coluna + 80;
        Linha = 10;
        //---------------------------------------------
        Nome.setBounds(Coluna, C(), 150, Altura);
        Idade.setBounds(Coluna, C(), 40, Altura);
        C();
        Estatura.setBounds(Coluna, C(), 40, Altura);
        Peso.setBounds(Coluna, C(), 40, Altura);
        Abdom.setBounds(Coluna, C(), 40, Altura);
        Quad.setBounds(Coluna, C(), 40, Altura);
        Colesterol.setBounds(Coluna, C(), 40, Altura);
        Glicose.setBounds(Coluna, C(), 40, Altura);
        SitGlicose.setText("Sit. Glicose");
        SitGlicose.setToolTipText("Situacao da glicose");
        SitGlicose.setEditable(false);
        SitGlicose.setBorder(new BasicBorders.FieldBorder(Color.red, Color.cyan, Color.magenta, Color.lightGray));
        SitGlicose.setBounds(170, 325, 150, Altura);
        HDL.setBounds(Coluna, C(), 40, Altura);
        LDL.setBounds(Coluna, C(), 40, Altura);
        Funcao.setBounds(Coluna, C(), largura, Altura);
        Tempo.setBounds(Coluna, C(), largura, Altura);
        RQC.setText("RQC");
        RQC.setToolTipText("RQC");
        RQC.setEditable(false);
        RQC.setBorder(new BasicBorders.FieldBorder(Color.red, Color.cyan, Color.magenta, Color.lightGray));
        RQC.setBounds(170, 186, 60, Altura);
        CRQC.setText("CRQC");
        CRQC.setToolTipText("CRQC");
        CRQC.setEditable(false);
        CRQC.setBorder(new BasicBorders.FieldBorder(Color.red, Color.cyan, Color.magenta, Color.lightGray));
        CRQC.setBounds(250, 186, 150, Altura);
        indConicidade.setText("Ind. Conicidade");
        indConicidade.setToolTipText("Ind. Conicidade");
        indConicidade.setEditable(false);
        indConicidade.setBorder(new BasicBorders.FieldBorder(Color.red, Color.cyan, Color.magenta, Color.lightGray));
        indConicidade.setBounds(170, 222, 100, Altura);
        //----------------------------------------------
        Confirmar.setBounds(350, 520, 100, 25);
        Calcular.setBounds(350, 45, 100, 100);
        //----------------------------------------------
        Confirmar.setEnabled(false);
        Confirmar.setToolTipText("Só será habilitado após preencher todos os campos");
        //----------------------------------------------
        add(lNome);
        add(lIdade);
        add(lSexo);
        add(lEstatura);
        add(lPeso);
        add(lAbdom);
        add(lQuad);
        add(lColesterol);
        add(lGlicose);
        add(lHDL);
        add(lLDL);
        add(lTempo);
        add(lFuncao);
        //-----------------------------------------------
        add(Nome);
        add(Idade);
        add(Estatura);
        add(Peso);
        add(Abdom);
        add(Quad);
        add(Colesterol);
        add(Glicose);
        add(SitGlicose);
        add(HDL);
        add(LDL);
        add(Tempo);
        add(Funcao);
        add(CRQC);
        add(RQC);
        add(indConicidade);
        //-----------------------------------------------
        add(Confirmar);
        add(Calcular);
        add(sexoF);
        add(sexoM);

    }

    public static int C() {
        Linha = Linha + 35;
        return Linha;
    }

    private void Eventos() {
        Nome.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                validacao(Nome);
                Idade.requestFocus();
            }
        });
        Idade.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (validacao(Idade) && isNumber(Idade)) {
                    bIdade = true;
                    sexoF.requestFocus();
                }

            }
        });
        Estatura.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (validacao(Estatura) && isNumber(Estatura)) {
                    bEstatura = true;
                    Peso.requestFocus();
                }
            }
        });
        Peso.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (validacao(Peso) && isNumber(Peso)) {
                    bPeso = true;
                    Abdom.requestFocus();
                }
            }
        });
        Abdom.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (validacao(Abdom) && isNumber(Abdom)) {
                    bPabd = true;
                    Quad.requestFocus();
                }
            }
        });
        Quad.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (validacao(Quad) && isNumber(Quad)) {
                    bPqua = true;
                }
            }
        });
        Colesterol.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                validacao(Colesterol);
                isNumber(Colesterol);
            }
        });
        Glicose.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (validacao(Glicose) && isNumber(Glicose)) {
                    bGlicose = true;
                    HDL.requestFocus();
                }
            }
        });

        Calcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (bIdade && bEstatura && bSexo && bGlicose && bPabd && bPqua && bPeso) {
                    Funcoes.Calculos cl = new Calculos();

                    double peso = Double.parseDouble(Peso.getText());
                    double quadril = Double.parseDouble(Quad.getText());
                    double abdomen = Double.parseDouble(Abdom.getText());
                    double estatura = Double.parseDouble(Estatura.getText());
                    double glicose = Double.parseDouble(Glicose.getText());
                    int idade = Integer.parseInt(Idade.getText());

                    RQC.setText(cl.Rqc(quadril, abdomen).substring(0, 3));
                    CRQC.setText(cl.Crqc(abdomen / quadril, idade, sexo));
                    SitGlicose.setText(cl.SitGlicose(glicose));
                    indConicidade.setText(cl.Conicidade(peso, estatura, abdomen).substring(0, 5));
                    Confirmar.setEnabled(true);
                } else {

                    JOptionPane.showMessageDialog(null, "Existem campos em branco");

                }

            }
        });

        sexoF.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bSexo = true;
                sexo = "F";

            }
        });

        sexoM.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bSexo = true;
                sexo = "M";
            }
        });

        Confirmar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Modelo.Cliente c = new Cliente();
                Banco.Insercao ins = new Insercao();
                c.setNome(Nome.getText());
                c.setIdade(Integer.parseInt(Idade.getText()));
                c.setSexo(sexo);
                c.setEstatura(Double.parseDouble(Estatura.getText()));
                c.setPeso(Double.parseDouble(Peso.getText()));
                c.setQUad(Double.parseDouble(Quad.getText()));
                c.setAbdom(Double.parseDouble(Abdom.getText()));
                c.setHDL(Double.parseDouble(HDL.getText()));
                c.setLDL(Double.parseDouble(LDL.getText()));
                c.setColesterol(Double.parseDouble(Colesterol.getText()));
                c.setGlicose(Double.parseDouble(Glicose.getText()));
                c.setTempo(Tempo.getText());
                c.setFuncao(Funcao.getText());
                ins.inserir(c);
                limpaCampo();
            }
        });

    }

    public boolean validacao(JTextField campo) {

        if (campo.getText().isEmpty()) {
            campo.setBackground(Color.red);
            campo.requestFocus();
            return false;
        } else {
            campo.setBackground(Color.GREEN);
            return true;
        }

    }

    public boolean isNumber(JTextField campo) {
        boolean retorno = false;
        if (!campo.getText().isEmpty()) {
            try {
                Double.parseDouble(campo.getText());
                return true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Não é numero \n" + e.getMessage());
                campo.requestFocus();
            }
        }
        return retorno;
    }

    public void limpaCampo() {
        //--------------------
        bIdade = false;
        bEstatura = false;
        bSexo = false;
        bGlicose = false;
        bPabd = false;
        bPqua = false;
        bPeso = false;
        //--------------------
        Nome.setText(null);
        Idade.setText(null);
        Estatura.setText(null);
        Peso.setText(null);
        Abdom.setText(null);
        Quad.setText(null);
        Colesterol.setText(null);
        Glicose.setText(null);
        HDL.setText(null);
        LDL.setText(null);
        Funcao.setText(null);
        RQC.setText(null);
        CRQC.setText(null);
        SitGlicose.setText(null);
        indConicidade.setText(null);
        Tempo.setText(null);
        //---------------------
        Nome.setBackground(Color.white);
        Idade.setBackground(Color.white);
        Estatura.setBackground(Color.white);
        Peso.setBackground(Color.white);
        Abdom.setBackground(Color.white);
        Quad.setBackground(Color.white);
        Colesterol.setBackground(Color.white);
        Glicose.setBackground(Color.white);
        HDL.setBackground(Color.white);
        LDL.setBackground(Color.white);
        Funcao.setBackground(Color.white);
        Tempo.setBackground(Color.white);

    }
}
