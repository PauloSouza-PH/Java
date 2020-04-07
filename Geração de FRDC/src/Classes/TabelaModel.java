package Classes;

import Banco.Edicao;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaModel extends AbstractTableModel {

    private String[] coluna = new String[]{"ID",
        "NOME",
        "IDADE",
        "SEXO",
        "ESTATURA",
        "PESO",
        "P ABDOM",
        "P QUAD",
        "COLESTEROL",
        "GLICOSE",
        "SIT GLICOSE",
        "HDL",
        "LDL",
        "FUNCAO",
        "TEMPO",
        "RCQ",
        "CRCQ",
        "IND. CON"};
    private List<Cliente> dados;

    public TabelaModel() {
        dados = new ArrayList<Cliente>();
    }

    public TabelaModel(List<Cliente> cliente) {
        dados = new ArrayList<Cliente>(cliente);
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return coluna.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return coluna[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return Double.class;
            case 5:
                return Double.class;
            case 6:
                return Double.class;
            case 7:
                return Double.class;
            case 8:
                return Double.class;
            case 9:
                return Double.class;
            case 10:
                return String.class;
            case 11:
                return Double.class;
            case 12:
                return Double.class;
            case 13:
                return String.class;
            case 14:
                return String.class;
            case 15:
                return Double.class;
            case 16:
                return String.class;
            case 17:
                return Double.class;
            default:
                throw new IndexOutOfBoundsException("Coluna fora de escopo");
        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente valor = dados.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return valor.getId();
            case 1:
                return valor.getNome();
            case 2:
                return valor.getIdade();
            case 3:
                return valor.getSexo();
            case 4:
                return valor.getEstatura();
            case 5:
                return valor.getPeso();
            case 6:
                return valor.getAbdom();
            case 7:
                return valor.getQUad();
            case 8:
                return valor.getColesterol();
            case 9:
                return valor.getGlicose();
            case 10:
                return valor.getSitGlicose();
            case 11:
                return valor.getHDL();
            case 12:
                return valor.getLDL();
            case 13:
                return valor.getFuncao();
            case 14:
                return valor.getTempo();
            case 15:
                return valor.getRCQ();
            case 16:
                return valor.getCRCQ();
            case 17:
                return valor.getIndConicidade();
            default:
                throw new IndexOutOfBoundsException("Coluna fora de escopo");

        }

    }

    public Cliente getNome(int indiceLinha) {
        return dados.get(indiceLinha);
    }

    @Override
    public void setValueAt(Object cliente, int row, int col) {

        Modelo.Cliente valor = dados.get(row);
        Banco.Edicao ed = new Edicao();
        int id = (int) getValueAt(row, 0);

        switch (col) {

            case 1:
                valor.setNome((String) cliente);
                break;
            case 2:
                valor.setIdade((Integer) cliente);
                break;
            case 3:
                valor.setSexo((String) cliente);
                break;
            case 4:
                valor.setEstatura((Double) cliente);
                break;
            case 5:
                valor.setPeso((Double) cliente);
                break;
            case 6:
                valor.setAbdom((Double) cliente);
                break;
            case 7:
                valor.setQUad((Double) cliente);
                break;
            case 8:
                valor.setColesterol((Double) cliente);
                break;
            case 9:
                valor.setGlicose((Double) cliente);
                break;
            case 11:
                valor.setHDL((Double) cliente);
                break;
            case 12:
                valor.setLDL((Double) cliente);
                break;
            case 13:
                valor.setFuncao((String) cliente);
                break;
            case 14:
                valor.setTempo((String) cliente);
                break;
            default:
                throw new IndexOutOfBoundsException("Coluna fora de escopo");

        }
        ed.Editar(id, valor);
    }

    @Override
    public boolean isCellEditable(int row, int col) {

        return true;

    }


    /* Adiciona um registro. */
    public void addCliente(Cliente cliente) {
        // Adiciona o registro.
        dados.add(cliente);

        // Pega a quantidade de registros e subtrai um para achar
        // o último índice. É preciso subtrair um, pois os índices
        // começam pelo zero.
        int ultimoIndice = getRowCount() - 1;

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeCliente(int indiceLinha) {
        // Remove o sócio da linha especificada.    	
        dados.remove(indiceLinha);

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de sócios ao final dos registros. */
    public void addListaDeClientes(List<Cliente> cliente) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        dados.addAll(cliente);

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    /* Remove todos os registros. */
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        dados.clear();

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableDataChanged();
    }

    /* Verifica se este table model está vazio. */
    public boolean isEmpty() {
        return dados.isEmpty();
    }

}
