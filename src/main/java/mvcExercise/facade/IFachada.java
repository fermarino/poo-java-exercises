package mvcExercise.facade;
import java.util.ArrayList;
import mvcExercise.entity.Conta;

public interface IFachada {
    void inserirConta(Conta c);
    void alterarConta(Conta c);
    void removerConta(int numero);
    Conta buscarConta(int numero);
    ArrayList<Conta> buscarTodas();
}

