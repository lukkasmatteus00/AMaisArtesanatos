package JavaBeans;

public class FaleConosco {
    
    private int FaleConosco;
    private String tituto;
    private String mensagem;
    private Funcionario Funcionario_matricula;

    public FaleConosco() {
    }

    public FaleConosco(int FaleConosco, String tituto, String mensagem, Funcionario Funcionario_matricula ) {
        this.FaleConosco = FaleConosco;
        this.tituto = tituto;
        this.mensagem = mensagem;
        this.Funcionario_matricula = Funcionario_matricula;
    }

    public FaleConosco(int i, String titulo, String mensagem, String Funcionario_matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getFaleConosco() {
        return FaleConosco;
    }

    public void setFaleConosco(int FaleConosco) {
        this.FaleConosco = FaleConosco;
    }

    public String getTituto() {
        return tituto;
    }

    public void setTituto(String tituto) {
        this.tituto = tituto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Funcionario getFuncionario() {
        return Funcionario_matricula;
    }

    public void setFuncionario(Funcionario Funcionario_matricula) {
        this.Funcionario_matricula = Funcionario_matricula;
    }
    
    
}
