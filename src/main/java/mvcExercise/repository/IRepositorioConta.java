package mvcExercise.repository;

import java.util.ArrayList;
import mvcExercise.entity.Conta;

public interface IRepositorioConta {
    void inserirConta(Conta c);
    void alterarConta(Conta c);
    void removerConta(Conta c);
    Conta buscarConta(int numero);
    boolean verificarExistenciaDeConta(int numero);
    ArrayList<Conta> buscarTodas();
}

