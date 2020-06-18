
package projetopoo.Entidades;

public class Carro {
    public String marca;
    public String modelo;
    public String ano;
    public String placa;
    public String tipoCarro;
    public double km;
    public String tanque;
    public boolean disponibilidade;

    public Carro() {
    }

    public Carro(String marca, String modelo, String ano, String placa, String tipoCarro, double km, String tanque, boolean disponibilidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.tipoCarro = tipoCarro;
        this.km = km;
        this.tanque = tanque;
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", placa=" + placa + ", tipoCarro=" + tipoCarro + ", km=" + km + ", tanque=" + tanque + ", disponibilidade=" + disponibilidade + '}';
    }
    
}
