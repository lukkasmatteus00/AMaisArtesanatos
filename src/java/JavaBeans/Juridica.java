package JavaBeans;

public class Juridica extends Cliente{
    private String cnpj;
    private String razaoSocial;

    public Juridica() {
    }

    public Juridica(String cnpj, String razaoSocial , String email,
            String cep, String logradouro, String complemento,
            String bairro, String cidade, String estado, 
            String numero, String telefoneCel, String telefoneFixo) {
        
        super(email, cep, logradouro, complemento, bairro, 
                cidade, estado, numero, telefoneCel,
                telefoneFixo);
        
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
