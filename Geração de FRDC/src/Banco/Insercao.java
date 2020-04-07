/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Modelo.Cliente;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class Insercao extends Conexao {

    public Insercao() {
        Conexao();
    }

    public void inserir(Cliente cliente) {
        Cliente cs = cliente;
        String sql = "INSERT INTO dados(Nome,"
                + "Idade,"
                + "Sexo,"
                + "Estatura,"
                + "Peso,"
                + "Abdom,"
                + "Quad,"
                + "Colesterol,"
                + "Glicose,"
                + "HDL,"
                + "LDL,"
                + "Funcao,"
                + "Tempo) "
                + "VALUES('"
                + "" + cs.getNome() + "',"
                + "" + cs.getIdade() + ","
                + "'" + cs.getSexo() + "',"
                + " " + cs.getEstatura() + ","
                + " " + cs.getPeso() + ","
                + " " + cs.getAbdom() + ","
                + " " + cs.getQUad() + ","
                + " " + cs.getColesterol() + ","
                + " " + cs.getGlicose() + ","
                + " " + cs.getHDL() + ","
                + " " + cs.getLDL() + ","
                + "'" + cs.getFuncao() + "',"
                + "'" + cs.getTempo() + "' "
                + " )";

        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

}
