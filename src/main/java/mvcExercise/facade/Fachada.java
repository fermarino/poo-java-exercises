package mvcExercise.facade;

import java.util.ArrayList;
import mvcExercise.entity.Conta;
import mvcExercise.repository.IRepositorioConta;
import mvcExercise.repository.RepositorioContaArrayList;

public class Fachada implements IFachada {
    private IRepositorioConta repositorio;

    public Fachada() {
        this.repositorio = new RepositorioContaArrayList();
    }

    @Override
    public void inserirConta(Conta c) {
        repositorio.inserirConta(c);
    }

    @Override
    public void alterarConta(Conta c) {
        repositorio.alterarConta(c);
    }

    @Override
    public void removerConta(int numero) {
        Conta c = repositorio.buscarConta(numero);
        if (c != null) {
            repositorio.removerConta(c);
        }
    }

    @Override
    public Conta buscarConta(int numero) {
        return repositorio.buscarConta(numero);
    }

    @Override
    public ArrayList<Conta> buscarTodas() {
        return repositorio.buscarTodas();
    }
}
