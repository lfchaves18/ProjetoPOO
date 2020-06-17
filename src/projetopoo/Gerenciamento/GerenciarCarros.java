package projetopoo.Gerenciamento;

import java.util.List;
import java.util.Scanner;
import projetopoo.Entidades.Carro;

public class GerenciarCarros {

    private Sistema _sistema;

    public GerenciarCarros(Sistema sistema) {
        _sistema = sistema;
    }

    public Sistema adicionarCarro() {

        Carro carro = new Carro();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite a marca do carro: ");
        carro.marca = scanner.next().toUpperCase();

        System.out.println("\nDigite o modelo do carro: ");
        carro.modelo = scanner.next().toUpperCase();

        System.out.println("\nDigite o ano: ");
        carro.ano = scanner.next().toUpperCase();

        System.out.println("\nDigite a placa: ");
        carro.placa = scanner.next().toUpperCase();

        System.out.println("\nDigite o tipo de carro: \n 1-Economico, 2-Sedan, 3-SUV, 4-Premium");
        String tipoCarro = scanner.next();
        while (!tipoCarro.equals("1") && !tipoCarro.equals("2") && !tipoCarro.equals("3") && !tipoCarro.equals("4")) {
            System.out.println("\nDigite novamente o tipo de carro: \n 1-Economico, 2-Sedan, 3-SUV, 4-Premium");
            tipoCarro = scanner.next();
        }
        switch (tipoCarro) {
            case "1":
                carro.tipoCarro = "ECONOMICO";
                break;
            case "2":
                carro.tipoCarro = "SEDAN";
                break;
            case "3":
                carro.tipoCarro = "SUV";
                break;
            case "4":
                carro.tipoCarro = "PREMIUM";
                break;
        }

        System.out.println("\nDigite o KM do carro: ");
        carro.km = scanner.nextDouble();

        System.out.println("\nDigite a situação do tanque do carro: \n 1-VAZIO, 2-UM QUARTO, 3-METADE, 4-TRES QUARTOS, 5-CHEIO");
        String tanqueCarro = scanner.next();
        while (!tanqueCarro.equals("1") && !tanqueCarro.equals("2") && !tanqueCarro.equals("3") && !tanqueCarro.equals("4") && !tanqueCarro.equals("5")) {
            System.out.println("\nDigite novamente a situação do tanque do carro: \n 1-VAZIO, 2-UM QUARTO, 3-METADE, 4-TRES QUARTOS, 5-CHEIO");
            tanqueCarro = scanner.next();
        }
        switch (tanqueCarro) {
            case "1":
                carro.tanque = "VAZIO";
                break;
            case "2":
                carro.tanque = "UM QUARTO";
                break;
            case "3":
                carro.tanque = "METADE";
                break;
            case "4":
                carro.tanque = "TRES QUARTOS";
                break;
            case "5":
                carro.tanque = "CHEIO";
                break;
        }

        System.out.println("\nDisponiblidade do carro para locação: 1-Sim  2-Não");
        String locar = scanner.next();
        while (!locar.equals("1") && !locar.equals("2")) {
            System.out.println("\nDigite novamente a situação do tanque do carro: \n 1-VAZIO, 2-UM QUARTO, 3-METADE, 4-TRES QUARTOS, 5-CHEIO");
            locar = scanner.next();
        }
        switch (locar) {
            case "1":
                carro.disponibilidade = true;
                break;
            case "2":
                carro.disponibilidade = false;
                break;
        }

        if (carro.disponibilidade == false) {
            _sistema.listCarro.add(carro);
        } else {
            _sistema.listCarro.add(carro);
            _sistema.listCarroDisponivel.add(carro);
        }
        return _sistema;
    }

    public void mostrarCarro(List<Carro> listcarro, boolean mostrarTudo) {

        if (mostrarTudo == false) {
            for (Carro x : listcarro) {
                System.out.println("\nID: " + listcarro.indexOf(x) + "\nCarro: " + x.marca +" " + x.modelo + "\nPlaca: " + x.placa);
            }
        }
        else {
         for (Carro x : listcarro) {
                System.out.println("\nID: " + listcarro.indexOf(x) + "\nCarro: " + x.marca +" " + x.modelo +
                        "\nAno: "+x.ano+ "\nPlaca: " + x.placa + "\nTipo de carro: "+x.tipoCarro + "\nKilometragem" + x.km
                +"\nTanque: "+x.tanque);
                System.out.println(x.disponibilidade==true ? "Disponivel para locação" : "Indisponivel para locação");
            }
        }
    }

    public Sistema venderCarro() {

        Scanner scanner = new Scanner(System.in);
        mostrarCarro(_sistema.listCarro, false);
        System.out.println("\nDigite a placa do carro que deseja selecionar: ");
        String placaRemove = scanner.next();

        _sistema.listCarro.removeIf(x -> x.placa.equals(placaRemove));
        _sistema.listCarroAlugado.removeIf(x -> x.placa.equals(placaRemove));
        _sistema.listCarroDisponivel.removeIf(x -> x.placa.equals(placaRemove));
        return _sistema;
    }

    public Sistema buscarCarro() {
        mostrarCarro(_sistema.listCarro, true);
        return _sistema;
    }

}
