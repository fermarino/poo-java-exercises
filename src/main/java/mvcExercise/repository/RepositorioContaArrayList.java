package mvcExercise.repository;

import java.util.ArrayList;
import mvcExercise.entity.Conta;

public class RepositorioContaArrayList implements IRepositorioConta {
    private ArrayList<Conta> contas;

    public RepositorioContaArrayList() {
        this.contas = new ArrayList<>();
    }

    @Override
    public void inserirConta(Conta c) {
        this.contas.add(c);
    }

    @Override
    public void alterarConta(Conta c) {
        int indice = buscarIndiceDeConta(c);
        if (indice != -1) {
            this.contas.set(indice, c);
        }
    }

    @Override
    public void removerConta(Conta c) {
        this.contas.remove(c);
    }

    @Override
    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    private int buscarIndiceDeConta(Conta c) {
        return buscarIndiceDeConta(c.getNumero());
    }

    private int buscarIndiceDeConta(int numero) {
        for (int i = 0; i < this.contas.size(); i++) {
            if (this.contas.get(i).getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean verificarExistenciaDeConta(int numero) {
        return buscarConta(numero) != null;
    }

    @Override
    public ArrayList<Conta> buscarTodas() {
        return new ArrayList<>(contas);
    }
}
