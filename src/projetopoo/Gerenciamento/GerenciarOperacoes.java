package projetopoo.Gerenciamento;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import projetopoo.Entidades.Carro;
import projetopoo.Entidades.Operacao;

public class GerenciarOperacoes {

    private Sistema _sistema;

    public GerenciarOperacoes(Sistema sistema) {
        _sistema = sistema;
    }

    Scanner scanner = new Scanner(System.in);

    GerenciarCarros gerCarro = new GerenciarCarros(_sistema);

    //Controlar caixa, opção 1
    public Sistema controlarCaixa() {

        Operacao operacao;
        double valorCaixa = 0;

        for (int i = 0; i < _sistema.listOperacao.size(); i++) {

            operacao = _sistema.listOperacao.get(i);

            if (operacao.tipoOperacao.equals("VENDA") || operacao.tipoOperacao.equals("DEVOLUÇÃO") || operacao.tipoOperacao.equals("RETIRADA")) {
                valorCaixa = valorCaixa + operacao.valor;
            } else {
                valorCaixa = valorCaixa - operacao.valor;
            }
        }

        System.err.println("\nO valor do caixa é de: " + valorCaixa % 2f + "\n");

        return _sistema;
    }

    //Registrar novo carro, opção 2
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

        Operacao operacao = new Operacao();
        System.out.println("Informe o valor da operação: ");
        operacao.valor = scanner.nextDouble();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        operacao.tipoOperacao = "COMPRA";
        operacao.dataHora = date;
        operacao.carro = carro;
        operacao.Tanque = carro.tanque;
        operacao.km = carro.km;

        System.out.println("\nSua opereção foi realizada com sucesso!");

        return _sistema;
    }

    //VenderCarro, opção 3
    public Sistema venderCarro() {

        gerCarro.mostrarCarro(_sistema.listCarroDisponivel, false);
        System.out.println("\nDigite a placa do carro que deseja selecionar: ");
        String placa = scanner.next();

        Carro carroResult = null;

        for (int i = 0; i < _sistema.listCarro.size(); i++) {

            carroResult = _sistema.listCarro.get(i);

            if (carroResult.placa.equals(placa)) {
                _sistema.listCarroAlugado.remove(carroResult);
                _sistema.listCarroDisponivel.remove(carroResult);
                _sistema.listCarro.remove(carroResult);
                System.out.println("\nCarro vendido com sucesso");
            } else {
                System.out.println("\nNão foi possível vender o carro!");
            }
        }

        Operacao operacao = new Operacao();
        System.out.println("\nInforme o valor da operação: ");
        operacao.valor = scanner.nextDouble();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        operacao.tipoOperacao = "VENDA";
        operacao.dataHora = date;
        operacao.carro = carroResult;
        operacao.Tanque = carroResult.tanque;
        operacao.km = carroResult.km;

        System.out.println("\nSua opereção foi realizada com sucesso!");

        return _sistema;

    }

    //Retirar carro, opção 4
    public Sistema retirarCarro() {

        gerCarro.mostrarCarro(_sistema.listCarroDisponivel, false);
        System.out.println("\nDigite a placa do carro que deseja selecionar: ");
        String placa = scanner.next();

        Carro carroResult = null;

        for (int i = 0; i < _sistema.listCarroDisponivel.size(); i++) {

            carroResult = _sistema.listCarroDisponivel.get(i);

            if (carroResult.placa.equals(placa)) {
                _sistema.listCarroAlugado.add(carroResult);
                _sistema.listCarroDisponivel.remove(carroResult);
                System.out.println("\nCarro retirado com sucesso");
            } else {
                System.out.println("\nNão foi possível retirar o carro!");
            }
        }

        Operacao operacao = new Operacao();
        System.out.println("\nInforme o valor da operação: ");
        operacao.valor = scanner.nextDouble();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        operacao.tipoOperacao = "RETIRADA";
        operacao.dataHora = date;
        operacao.carro = carroResult;
        operacao.Tanque = carroResult.tanque;
        operacao.km = carroResult.km;

        System.out.println("\nSua opereção foi realizada com sucesso!");

        return _sistema;
    }

    //Devolver carro, opção 5
    public Sistema devolverCarro() {
        gerCarro.mostrarCarro(_sistema.listCarroAlugado, false);
        System.out.println("\nDigite a placa do carro que deseja selecionar: ");
        String placa = scanner.next();

        Carro carroResult = null;

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

        Operacao operacao = new Operacao();
        System.out.println("\nInforme o valor da operação: ");
        operacao.valor = scanner.nextDouble();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        operacao.tipoOperacao = "DEVOLUÇÃO";
        operacao.dataHora = date;
        operacao.carro = carroResult;
        operacao.Tanque = carroResult.tanque;
        operacao.km = carroResult.km;

        System.out.println("\nSua opereção foi realizada com sucesso!");

        return _sistema;
    }

    //Registro de locações, opção 6
    public Sistema registroOperacoes() {

        List<Operacao> listResult = new ArrayList<Operacao>();
        listResult = _sistema.listOperacao.stream().filter(oper -> oper.tipoOperacao == "RETIRADA").collect(Collectors.toList());

        if (listResult.size() == 0) {
            System.out.println("Não existem operações registradas");
        } else {
            for (Operacao oper : listResult) {

                System.out.println("\n\nOperação: " + oper.tipoOperacao + "\nValor: " + oper.valor % 2f + "\nTanque: " + oper.Tanque
                        + "\nData e hora: " + oper.dataHora + "\nCarro: " + oper.carro.marca + " " + oper.carro.modelo + " " + oper.carro.placa);
            }
        }

        return _sistema;
    }

    //Buscar carro no sistema, opção 7
    public Sistema buscarCarro() {

        System.out.println("\nVocê deseja buscar carro por:\n1-Marca  2-Buscar por preço  3-Categoria");
        String buscaOpcao = scanner.next();

        switch (buscaOpcao) {

            case "1":
                System.out.println("\nQual marca ou modelo deseja buscar? ");
                String marcaModelo = scanner.next().toUpperCase();

                List<Carro> listResult = new ArrayList<Carro>();
                List<Carro> listResult2 = new ArrayList<Carro>();
                listResult = _sistema.listCarro.stream().filter(carro -> carro.marca.equals(marcaModelo)).collect(Collectors.toList());
                listResult2 = _sistema.listCarro.stream().filter(carro -> carro.modelo.equals(marcaModelo)).collect(Collectors.toList());

                gerCarro.mostrarCarro(listResult, false);
                gerCarro.mostrarCarro(listResult2, false);
                break;
                
            case "2":
                System.out.println("\nDigite o preço maximo que deseja dos veiculos: ");
                double preco = scanner.nextDouble();
                List<Operacao> listResultPreco = new ArrayList<Operacao>();
                listResultPreco = _sistema.listOperacao.stream().filter(operacao -> operacao.tipoOperacao.equals("COMPRA") && operacao.valor >= preco).collect(Collectors.toList());

                for (Operacao op : listResultPreco) {
                    System.out.println("Carros: " + op.carro.marca + " " + op.carro.modelo + " " + op.carro.placa);
                }
                break;
                
            case "3":
                System.out.println("\nQual marca ou modelo deseja buscar? (ECONOMICO, SEDAN, SUV OU PREMIUM) ");
                String categoria = scanner.next().toUpperCase();
                List<Carro> listCategoria = new ArrayList<Carro>();
                listCategoria = _sistema.listCarro.stream().filter(carro -> carro.tipoCarro.equals(categoria)).collect(Collectors.toList());

                gerCarro.mostrarCarro(listCategoria, false);
                break;
                
            default:
                System.out.println("Opção invalida. ");
                break;
        }

        return _sistema;
    }

}
