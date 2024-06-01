package mvcExercise.ui;

import mvcExercise.facade.Fachada;
import mvcExercise.entity.Conta;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fachada fachada = new Fachada();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar conta");
            System.out.println("2. Alterar conta");
            System.out.println("3. Remover conta");
            System.out.println("4. Buscar conta");
            System.out.println("5. Verificar existência de conta");
            System.out.println("6. Imprimir todas as contas");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    int numero = scanner.nextInt();
                    System.out.print("Agência: ");
                    int agencia = scanner.nextInt();
                    System.out.print("Saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine();  // Consumir nova linha
                    System.out.print("Titular: ");
                    String titular = scanner.nextLine();

                    Conta novaConta = new Conta();
                    novaConta.setNumero(numero);
                    novaConta.setAgencia(agencia);
                    novaConta.setSaldo(saldoInicial);
                    novaConta.setTitular(titular);

                    fachada.inserirConta(novaConta);
                    System.out.println("Conta adicionada com sucesso!");
                    break;

                case 2:
                    System.out.print("Número da conta a alterar: ");
                    int numeroAlterar = scanner.nextInt();
                    Conta contaAlterar = fachada.buscarConta(numeroAlterar);
                    if (contaAlterar != null) {
                        System.out.print("Novo saldo: ");
                        double novoSaldo = scanner.nextDouble();
                        scanner.nextLine();  // Consumir nova linha
                        contaAlterar.setSaldo(novoSaldo);
                        fachada.alterarConta(contaAlterar);
                        System.out.println("Conta alterada com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta a remover: ");
                    int numeroRemover = scanner.nextInt();
                    fachada.removerConta(numeroRemover);
                    System.out.println("Conta removida com sucesso!");
                    break;

                case 4:
                    System.out.print("Número da conta a buscar: ");
                    int numeroBuscar = scanner.nextInt();
                    Conta contaBuscar = fachada.buscarConta(numeroBuscar);
                    if (contaBuscar != null) {
                        System.out.println("Conta encontrada: " + contaBuscar);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta a verificar: ");
                    int numeroVerificar = scanner.nextInt();
                    boolean existe = fachada.buscarConta(numeroVerificar) != null;
                    System.out.println("Conta " + (existe ? "existe" : "não existe") + ".");
                    break;

                case 6:
                    System.out.println("Todas as contas cadastradas:");
                    for (Conta conta : fachada.buscarTodas()) {
                        System.out.println(conta);
                    }
                    break;

                case 7:
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
