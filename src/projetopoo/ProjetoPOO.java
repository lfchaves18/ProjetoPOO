package projetopoo;

import java.util.Scanner;

public class ProjetoPOO {

    public static void main(String[] args) {

        menu();

    }

    static void menu() {

        Scanner scanner = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("    *Bem-vindo*\nDigite a opção desejada: ");
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
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
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
