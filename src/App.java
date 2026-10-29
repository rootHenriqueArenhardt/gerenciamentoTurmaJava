import java.util.ArrayList;
import turma.*;
import tools.*;
import repository.*;

public class App {
    public static void main(String[] args) throws Exception {

        Repositorio repositorioAlunos = new Repositorio();
        Turma turmaAlunos = new Turma("001");
        Aluno alunoTeste = new Aluno("0","Teste");
        

        repositorioAlunos.guardarAluno(new Aluno("1", "Henrique"));
        repositorioAlunos.guardarAluno(new Aluno("2", "Ricardo"));

        repositorioAlunos.salvar("C:\\Users\\henrique.arenhardt\\Desktop\\Java");

    }
}
