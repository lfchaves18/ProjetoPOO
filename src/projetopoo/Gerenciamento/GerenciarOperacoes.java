package projetopoo.Gerenciamento;

import java.util.List;
import java.util.Scanner;
import projetopoo.Entidades.Carro;
import projetopoo.Entidades.Operacao;

public class GerenciarOperacoes {

    private Sistema _sistema;

    public GerenciarOperacoes(Sistema sistema) {
        _sistema = sistema;
    }

    Scanner scanner = new Scanner(System.in);

    GerenciarCarros gerCarro = new GerenciarCarros(_sistema);

    public Sistema retirarCarro() {

        gerCarro.mostrarCarro(_sistema.listCarroDisponivel, false);
        System.out.println("\nDigite a placa do carro que deseja selecionar: ");
        String placa = scanner.next();

        Carro carroResult;

        for (int i = 0; i < _sistema.listCarroDisponivel.size(); i++) {
           
            carroResult = _sistema.listCarroDisponivel.get(i);
             
            if (carroResult.placa.equals(placa)) {
                _sistema.listCarroAlugado.add(carroResult);
                _sistema.listCarroDisponivel.remove(carroResult);
                System.out.println("\nCarro alugado com sucesso");
            } else {
                System.out.println("\nNão foi possível alugar o carro!");
            }
        }

        return _sistema;
    }

    public Sistema devolverCarro() {
        gerCarro.mostrarCarro(_sistema.listCarroAlugado, false);
        System.out.println("\nDigite a placa do carro que deseja selecionar: ");
        String placa = scanner.next();

        Carro carroResult;

        for (int i = 0; i < _sistema.listCarroAlugado.size(); i++) {

            carroResult = _sistema.listCarroAlugado.get(i);

            if (carroResult.placa.equals(placa)) {
                _sistema.listCarroDisponivel.add(carroResult);
                _sistema.listCarroAlugado.remove(carroResult);
                System.out.println("\nCarro devolvido com sucesso");
            } else {
                System.out.println("\nNão foi possível devolver o carro!");
            }
        }
        return _sistema;
    }

    public Sistema registroOperacoes() {

        return _sistema;
    }
}
