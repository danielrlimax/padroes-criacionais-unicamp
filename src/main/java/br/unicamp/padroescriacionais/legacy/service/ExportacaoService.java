package br.unicamp.padroescriacionais.legacy.service;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.domain.Relatorio;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactoryProvider;
import br.unicamp.padroescriacionais.legacy.generator.*;

public class ExportacaoService {

    private ConfiguracaoSistema configuracao = ConfiguracaoSistema.getInstance();

    public void exportar(Relatorio relatorio, FormatoRelatorio formato) {
        //Alterando a configuração global para a exportação
        configuracao.setAmbiente("PROD");
        configuracao.setDiretorioExportacao("/var/exports/relatorios");
        configuracao.setDebugAtivo(false);
        String conteudoFormatado;

        RelatorioGeneratorFactory factory = RelatorioGeneratorFactoryProvider.getFactory(formato);
        RelatorioGenerator generator = factory.criarGenerator();

        conteudoFormatado = generator.gerar(relatorio);

        String nomeArquivo = relatorio.getTitulo()
                .replace(" ", "_")
                .toLowerCase()
                + "." + formato.name().toLowerCase();

        String caminhoCompleto = configuracao.getDiretorioExportacao() + "/" + nomeArquivo;

        System.out.println("[EXPORTACAO] Empresa  : " + configuracao.getNomeEmpresa());
        System.out.println("[EXPORTACAO] Ambiente : " + configuracao.getAmbiente());
        System.out.println("[EXPORTACAO] Arquivo  : " + caminhoCompleto);
        System.out.println("[EXPORTACAO] Conteudo :");
        System.out.println(conteudoFormatado);
    }
}
