package projetopoo;

import java.util.Scanner;
import projetopoo.Gerenciamento.GerenciarCarros;
import projetopoo.Gerenciamento.GerenciarOperacoes;
import projetopoo.Gerenciamento.Sistema;

public class ProjetoPOO {

    public static void main(String[] args) {

        menu();

    }

    static void menu() {

        Sistema sistema = new Sistema();
        GerenciarCarros gerCarro = new GerenciarCarros(sistema);
        GerenciarOperacoes gerOperacoes = new GerenciarOperacoes(sistema);
        
        Scanner scanner = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("    \n\nQual operação deseja realizar: ");
            System.out.println("1- Controlar o caixa.\n"
                    + "2- Registrar carro novo.\n"
                    + "3- Vender carro.\n"
                    + "4- Retirada de carros.\n"
                    + "5- Devolução de carros. \n"
                    + "6- Registro de locação. \n"
                    + "7- Buscar carro. \n"
                    + "0- Sair.");
            opcao = scanner.next();
            switch (opcao) {
                case "1":
                    System.out.println("Controlar caixa!");
                    break;
                case "2":
                    gerCarro.adicionarCarro();
                    break;
                case "3":
                    gerCarro.venderCarro();
                    break;
                case "4":
                    gerOperacoes.retirarCarro();
                    break;
                case "5":
                    gerOperacoes.devolverCarro();
                    break;
                case "6":
                    gerOperacoes.registroOperacoes();
                    break;
                case "7":
                    gerCarro.buscarCarro();
                    break;
                case "0":
                    System.out.println("*Você escolheu sair!*");
                    break;
                default:
                    System.out.println("Opção Invalida.");
                    break;
            }
        } while (!opcao.equals("0"));
    }
}
