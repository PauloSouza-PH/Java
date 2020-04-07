/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class Remover extends Conexao {

    public Remover() {
        Conexao();
    }

    public void remover(int id) {
        try {
            st.executeUpdate("DELETE FROM dados WHERE IdInfor = " + id + " ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel deletar\n" + ex.getMessage());
        }
    }

}
