package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;

public class RelatorioGeneratorFactoryProvider {
    public static RelatorioGeneratorFactory getFactory(FormatoRelatorio formato){
        return switch (formato){
            case PDF -> new PdfRelatorioGeneratorFactory();
            case CSV -> new CsvRelatorioGeneratorFactory();
            case JSON -> new JsonRelatorioGeneratorFactory();
            case XML -> new XmlRelatorioGeneratorFactory();
            case HTML -> new HtmlRelatorioGeneratorFactory();
        };
    }
}
