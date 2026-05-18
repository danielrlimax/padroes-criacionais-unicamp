package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class XmlRelatorioGenerator implements RelatorioGenerator{
    public String gerar(Relatorio relatorio){
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<relatorio>\n");
        sb.append("    <titulo>").append(scapeXml(relatorio.getTitulo())).append("</titulo>\n");
        sb.append("    <tipo>").append(relatorio.getTipo()).append("</tipo>\n");
        sb.append("    <dataGeracao>").append(relatorio.getDataGeracao()).append("</dataGeracao>\n");
        sb.append("    <conteudo>").append(scapeXml(relatorio.getConteudo())).append("</conteudo>\n");
        sb.append("</relatorio>\n");

        return sb.toString();
    }

    private String scapeXml(String valor){
        if(valor == null){
            return "";
        }
        return valor.replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&apos;")
                    .replace("&", "&amp;");
    }
}
