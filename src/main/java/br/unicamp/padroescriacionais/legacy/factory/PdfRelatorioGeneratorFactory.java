package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.generator.PdfRelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class PdfRelatorioGeneratorFactory implements RelatorioGeneratorFactory{
    @Override
    public RelatorioGenerator criarGenerator() {
        return new PdfRelatorioGenerator();
    }
}
