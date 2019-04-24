package JavaBeans;

public class Funcionario {
    private String matricula;
    private String senha;
    private String cargo;
    private String nomeCompleto;
    private String cpf;
    private String dataAdmissao;
    private String logradouro;
    private String cep;
    private String complemento;
    private String bairro;
    private String estado;
    private String numero;
    private String cidade;
    private String telefoneCel;
    private String telefoneFixo;
    

    public Funcionario() {
    }

    public Funcionario(String matricula, String senha, String cargo, 
            String nomeCompleto, String cpf, String dataAdmissao,
            String logradouro, String cep, String complemento,
            String bairro, String estado, String numero, 
            String cidade, String telefoneCel, 
            String telefoneFixo ) {
        
        this.matricula = matricula;
        this.senha = senha;
        this.cargo = cargo;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.logradouro = logradouro;
        this.cep = cep;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
        this.numero = numero;
        this.cidade = cidade;
        this.telefoneCel = telefoneCel;
        this.telefoneFixo = telefoneFixo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefoneCel() {
        return telefoneCel;
    }

    public void setTelefoneCel(String telefoneCel) {
        this.telefoneCel = telefoneCel;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

   
   
}