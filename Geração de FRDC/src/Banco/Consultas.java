package Banco;

import Modelo.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Consultas extends Conexao {

    public Consultas() {
        Conexao();
    }

    public ArrayList<Cliente> Consultar(String sql) {
        ArrayList<Cliente> List = new ArrayList<>();
        try {

            System.out.println(sql);
            rs = st.executeQuery(sql);
            Cliente c;

            while (rs.next()) {
                c = new Cliente();
                
                c.setId(rs.getInt(1));
                c.setNome(rs.getNString(2));
                c.setIdade(rs.getInt(3));
                c.setSexo(rs.getNString(4));
                c.setEstatura(rs.getDouble(5));
                c.setPeso(rs.getDouble(6));
                c.setAbdom(rs.getDouble(7));
                c.setQUad(rs.getDouble(8));
                c.setColesterol(rs.getDouble(9));
                c.setGlicose(rs.getDouble(10));
                c.setSitGlicose(rs.getNString(11));
                c.setHDL(rs.getDouble(12));
                c.setLDL(rs.getDouble(13));
                c.setFuncao(rs.getNString(14));
                c.setTempo(rs.getNString(15));
                c.setRCQ(rs.getDouble(16));
                c.setCRCQ(rs.getNString(17));
                c.setIndConicidade(rs.getDouble(18));
                
                List.add(c);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco ~~ " + ex.getMessage());
            Close();
        }

        return List;

    }

}
