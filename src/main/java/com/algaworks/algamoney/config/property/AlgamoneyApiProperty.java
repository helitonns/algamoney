package com.algaworks.algamoney.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("algamoney")
public class AlgamoneyApiProperty {

    private final Seguranca seguranca = new Seguranca();
//    private String origemPermitida = "http://localhost:8000";
    private String origemPermitida = "http://localhost:9990";
    
    
    //--------------------------------------------------------------------------
    public Seguranca getSeguranca() {
        return seguranca;
    }

    public String getOrigemPermitida() {
        return origemPermitida;
    }

    public void setOrigemPermitida(String origemPermitida) {
        this.origemPermitida = origemPermitida;
    }
    
    //==========================================================================
    //==========================================================================
    public static class Seguranca {

        private boolean enableHttps;

        //----------------------------------------------------------------------

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }
        
    }
}
