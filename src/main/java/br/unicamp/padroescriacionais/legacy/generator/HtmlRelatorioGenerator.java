package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class HtmlRelatorioGenerator {
    public String gerar(Relatorio relatorio){
        StringBuilder sb = new StringBuilder();
        String conteudo = scapeHtml(relatorio.getConteudo()).replace("\n", "<br>\n");

        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"pt-BR\">\n");
        sb.append("<head>\n");
        sb.append("  <meta charset\"UTF-8\">\n");
        sb.append("  <title>").append(scapeHtml(relatorio.getTitulo())).append("</title>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("  <h1>").append(scapeHtml(relatorio.getTitulo())).append("</h1>\n");
        sb.append("  <p><strong>Tipo:</strong> ").append(relatorio.getTipo()).append("</p>\n");        
        sb.append("  <p><strong>Gerado em:</strong> ").append(relatorio.getDataGeracao()).append("</p>\n"); 
        sb.append("  <hr>\n");
        sb.append("  <div>\n");
        sb.append("    ").append(conteudo);
        sb.append("\n  </div>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }

        private String scapeHtml(String valor){
        if(valor == null){
            return "";
        }
        return valor.replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("&", "&amp;");
    }
}

