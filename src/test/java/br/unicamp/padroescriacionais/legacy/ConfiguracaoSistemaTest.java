package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.service.ConfiguracaoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracaoSistemaTest {

    //ConfiguracaoSistema configuracao = ConfiguracaoSistema.getInstance();

    @Test
    void deveCriarConfiguracaoComValoresInformados() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setNomeEmpresa("Empresa Teste");
        config.setDiretorioExportacao("/tmp/test");

        assertEquals("Empresa Teste", config.getNomeEmpresa());
        assertEquals("DEV", config.getAmbiente());
        assertEquals("/tmp/test", config.getDiretorioExportacao());
        assertTrue(config.isDebugAtivo());
    }

    @Test
    void devePermitirAlteracaoDeAmbiente() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setAmbiente("PROD");

        assertEquals("PROD", config.getAmbiente());
    }

    @Test
    void devePermitirAlteracaoDeDebug() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setDebugAtivo(false);

        config.setDebugAtivo(true);

        assertTrue(config.isDebugAtivo());
    }

    @Test
    void devePermitirAlteracaoDeDiretorio() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setDiretorioExportacao("/novo/diretorio");

        assertEquals("/novo/diretorio", config.getDiretorioExportacao());
    }

    @Test
    void deveGarantirQueAInstanciaUnicaSejaCompartilhada() {
        ConfiguracaoSistema configDev = ConfiguracaoSistema.getInstance();
        configDev.setAmbiente("DEV");

        ConfiguracaoSistema configProd = ConfiguracaoSistema.getInstance();
        configProd.setAmbiente("PROD"); //Ao alterar no configProd, altera para o sistema todo

        //As variáveis apontam para o mesmo espaço de memória
        assertSame(configDev, configProd); 
        
        //O ambiente de configDev agora é PROD, porque configProd sobrescreveu a instância global
        assertEquals("PROD", configDev.getAmbiente()); 
        assertEquals("PROD", configProd.getAmbiente());
    }
    
    @Test
    void alteracaoEmUmaReferenciaAfetaTodasAsOutrasNoSingleton() {
        ConfiguracaoSistema config1 = ConfiguracaoSistema.getInstance();
        ConfiguracaoSistema config2 = ConfiguracaoSistema.getInstance();

        // Alteramos a config1
        config1.setAmbiente("PROD");

        //Ambas devem ser PROD, porque config1 e config2 são a MESMA instância
        assertEquals("PROD", config1.getAmbiente());
        assertEquals("PROD", config2.getAmbiente());
    }

    @Test
    void configuracaoServiceDeveRetornarConfiguracaoNaoNula() {
        ConfiguracaoService service = new ConfiguracaoService();
        assertNotNull(service.getConfiguracao());
        assertFalse(service.getConfiguracao().getNomeEmpresa().isBlank());
    }
}
