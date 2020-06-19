package projetopoo.Gerenciamento;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import projetopoo.Entidades.Carro;

public class GerenciarCarros {

    private Sistema _sistema;

    public GerenciarCarros(Sistema sistema) {
        _sistema = sistema;
    }

        public void mostrarCarro(List<Carro> listcarro, boolean mostrarTudo) {

        if (mostrarTudo == false) {
            for (Carro x : listcarro) {
                System.out.println("\nID: " + listcarro.indexOf(x) + "\nCarro: " + x.marca + " " + x.modelo + "\nPlaca: " + x.placa);
            }
        } else {
            for (Carro x : listcarro) {
                System.out.println("\nID: " + listcarro.indexOf(x) + "\nCarro: " + x.marca + " " + x.modelo
                        + "\nAno: " + x.ano + "\nPlaca: " + x.placa + "\nTipo de carro: " + x.tipoCarro + "\nKilometragem" + x.km
                        + "\nTanque: " + x.tanque);
                System.out.println(x.disponibilidade == true ? "Disponivel para locação" : "Indisponivel para locação");
            }
        }
    }
}
