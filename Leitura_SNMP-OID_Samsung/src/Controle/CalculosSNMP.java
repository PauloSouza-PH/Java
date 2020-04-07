package Controle;

import java.io.IOException;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class CalculosSNMP {

    public String consultar(String IP, String oid) throws IOException {

        String porta = "161";

        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        snmp.listen();

        PDU pdu = new PDU();
        pdu.setType(PDU.GETBULK);
        pdu.add(new VariableBinding(new OID(oid)));
        pdu.setMaxRepetitions(1);

        Address endereco = GenericAddress.parse(IP + "/" + porta);
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setAddress(endereco);
        target.setVersion(SnmpConstants.version2c);

        ResponseEvent resposta = snmp.get(pdu, target);

        if (resposta.getResponse() != null) {

            PDU PDUResposta = resposta.getResponse();
            if (PDUResposta.getErrorStatusText().equals("Success")) {
                String respostaPDU = PDUResposta.toString();
                return Tratamento(respostaPDU, oid);
            } else {
                return "Sem comunicacao";
            }
        } else {
            return "Sem comunicacao";
        }
    }

    public String Tratamento(String entrada, String oid) {
        entrada = entrada.replaceAll("RESPONSE", "");
        entrada = entrada.replaceAll("requestID", "");
        entrada = entrada.replaceAll("errorStatus", "");
        entrada = entrada.replaceAll("Success", "");
        entrada = entrada.replaceAll("errorIndex", "");
        entrada = entrada.replaceAll("=", "");
        int qtd = entrada.length();
        int qtd2 = entrada.indexOf(oid);
        int qtd3 = oid.length();
        entrada = entrada.substring(qtd2 + qtd3, qtd - 2);
        String Resultado = entrada.trim();
        return Resultado;
    }

}
