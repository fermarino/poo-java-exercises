package arrayList;

import arrayList.exceptions.ContaNaoEncontradaException;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public void depositar(String numeroConta, double valor) throws ContaNaoEncontradaException {
        Conta conta = buscarContaPorNumero(numeroConta);
        conta.depositar(valor);
    }

    public void sacar(String numeroConta, double valor) throws ContaNaoEncontradaException {
        Conta conta = buscarContaPorNumero(numeroConta);
        conta.sacar(valor);
    }

    public Conta buscarContaPorNumero(String numeroConta) throws ContaNaoEncontradaException {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("Conta com número " + numeroConta + " não encontrada.");
    }

    public Conta buscarConta(Conta c) throws ContaNaoEncontradaException {
        for (Conta conta : contas) {
            if (conta.equals(c)) {
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("Conta não encontrada.");
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}