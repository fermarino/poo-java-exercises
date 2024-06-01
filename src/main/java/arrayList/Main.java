package arrayList;

import arrayList.Banco;
import arrayList.Conta;
import arrayList.exceptions.ContaNaoEncontradaException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Buscar conta por número");
            System.out.println("5. Listar todas as contas");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    String numero = scanner.nextLine();
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine();  // Consumir nova linha

                    Conta novaConta = new Conta(numero, nomeCliente, saldoInicial);
                    banco.adicionarConta(novaConta);
                    System.out.println("Conta adicionada com sucesso!");
                    break;
                case 2:
                    try {
                        System.out.print("Número da conta: ");
                        String numeroDeposito = scanner.nextLine();
                        System.out.print("Valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();  // Consumir nova linha

                        banco.depositar(numeroDeposito, valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } catch (ContaNaoEncontradaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Número da conta: ");
                        String numeroSaque = scanner.nextLine();
                        System.out.print("Valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();  // Consumir nova linha

                        banco.sacar(numeroSaque, valorSaque);
                        System.out.println("Saque realizado com sucesso!");
                    } catch (ContaNaoEncontradaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Número da conta: ");
                        String numeroBusca = scanner.nextLine();
                        Conta contaEncontrada = banco.buscarContaPorNumero(numeroBusca);
                        System.out.println("Conta encontrada: " + contaEncontrada);
                    } catch (ContaNaoEncontradaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Listando todas as contas:");
                    for (Conta conta : banco.getContas()) {
                        System.out.println(conta);
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}