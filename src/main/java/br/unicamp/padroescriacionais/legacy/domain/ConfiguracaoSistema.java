package br.unicamp.padroescriacionais.legacy.domain;

public class ConfiguracaoSistema {

    //Instancia estática e privada
    private static ConfiguracaoSistema instance;

    private String nomeEmpresa;
    private String ambiente;
    private String diretorioExportacao;
    private boolean debugAtivo;

    //Construtor privado
    private ConfiguracaoSistema(){
        this.nomeEmpresa = "Empresa XPTO Ltda.";
        this.ambiente = "DEV";
        this.diretorioExportacao = "/tmp/relatorios";
        this.debugAtivo = true;
    }

    //Metodo global para acessar instancia unica
    public static ConfiguracaoSistema getInstance(){
        if(instance == null){
            instance = new ConfiguracaoSistema();
        }

        return instance;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getDiretorioExportacao() {
        return diretorioExportacao;
    }

    public void setDiretorioExportacao(String diretorioExportacao) {
        this.diretorioExportacao = diretorioExportacao;
    }

    public boolean isDebugAtivo() {
        return debugAtivo;
    }

    public void setDebugAtivo(boolean debugAtivo) {
        this.debugAtivo = debugAtivo;
    }
}
