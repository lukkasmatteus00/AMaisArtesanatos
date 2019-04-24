package JavaBeans;


public class Fisica extends Cliente{
    private String nomeCompleto;
    private String cpf;
    private String sexo;
    private String dataNascimento;

    public Fisica() {
    }

    public Fisica(String nomeCompleto, String cpf, String sexo,
            String dataNascimento , String email, String cep,
            String logradouro, String complemento, String bairro,
            String cidade, String estado, String numero,
            String telefoneCel, String telefoneFixo) {
        
        super(email, cep, logradouro, complemento,
                bairro, cidade, estado, numero,
                telefoneCel, telefoneFixo);
        
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
