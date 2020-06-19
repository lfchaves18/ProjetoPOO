package projetopoo.Entidades;

import java.util.Date;

public class Operacao {
    
    
    public String tipoOperacao;
    public Carro carro;
    public Date dataHora;
    public double valor;
    public double km;
    public String Tanque;

    public Operacao() {
    }

    public Operacao(String tipoOperacao, Carro carro, Date dataHora, double valor, double km, String Tanque) {
        this.tipoOperacao = tipoOperacao;
        this.carro = carro;
        this.dataHora = dataHora;
        this.valor = valor;
        this.km = km;
        this.Tanque = Tanque;
    }
}
