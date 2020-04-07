package Modelos;

/**
 *
 * @author paulosouza
 */
public class Impressoras {

    private String ip;
    private String nome;
    private String unidade;
    private String serial;
    private String status;
    private String modelo;
    private String oid;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String inf = "IP : " + this.ip + ""
                + "\nNome : " + this.nome
                + "\nUnidade : " + this.unidade
                + "\nSerial : " + this.serial
                + "\nStatus Ligada: " + this.status + "\n";
        return inf;
    }

}
