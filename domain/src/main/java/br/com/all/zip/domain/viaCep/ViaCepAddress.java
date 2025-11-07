package br.com.all.zip.domain.viaCep;

public class ViaCepAddress {
    private final String cep;
    private final String logradouro;
    private final String unidade;
    private final String bairro;
    private final String localidade;
    private final String uf;
    private final String estado;
    private final String regiao;
    private final String ibge;
    private final String gia;
    private final String ddd;
    private final String siafi;

    public ViaCepAddress(
            String cep,
            String logradouro,
            String unidade,
            String bairro,
            String localidade,
            String uf,
            String estado,
            String regiao,
            String ibge,
            String gia,
            String ddd,
            String siafi
    ) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.unidade = unidade;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.estado = estado;
        this.regiao = regiao;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }



    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public String getDdd() {
        return ddd;
    }

    public String getSiafi() {
        return siafi;
    }
}
