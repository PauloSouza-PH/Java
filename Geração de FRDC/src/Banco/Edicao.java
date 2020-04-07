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
public class Edicao extends Conexao {

    public Edicao() {
        Conexao();
    }

    public void Editar(int id, Cliente valor) {
        String sexo = valor.getSexo();
        if (sexo.equals("MASCULINO")) {
            sexo = "M";
        } else {
            sexo = "F";
        }
        try {
            rs = st.executeQuery("SELECT * FROM dados WHERE IdInfor = " + id + " ");
            st.executeUpdate("UPDATE dados SET Nome = '" + valor.getNome() + "' ,"
                    + "Idade = " + valor.getIdade() + " ,"
                    + "Sexo = '" + sexo + "' ,"
                    + "Estatura = " + valor.getEstatura() + " ,"
                    + "Peso = " + valor.getPeso() + " ,"
                    + "Abdom = " + valor.getAbdom() + " ,"
                    + "Quad = " + valor.getQUad() + " ,"
                    + "Colesterol = " + valor.getColesterol() + " ,"
                    + "Glicose = " + valor.getGlicose() + " ,"
                    + "HDL = " + valor.getHDL() + " ,"
                    + "LDL = " + valor.getLDL() + " ,"
                    + "Funcao = '" + valor.getFuncao() + "' ,"
                    + "Tempo = '" + valor.getTempo() + "' "
                    + "WHERE IdInfor = " + id + " "
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar ID " + id + "---" + ex.getMessage());
        }

    }

}
