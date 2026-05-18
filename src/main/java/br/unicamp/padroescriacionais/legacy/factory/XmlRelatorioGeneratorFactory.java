package br.unicamp.padroescriacionais.legacy.factory;

import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.XmlRelatorioGenerator;

public class XmlRelatorioGeneratorFactory implements RelatorioGeneratorFactory{
    @Override
    public RelatorioGenerator criarGenerator() {
        return new XmlRelatorioGenerator();
    }
}
