package turma;


import java.util.ArrayList;

import repository.Repositorio;

public class Turma {
    private String codigo;
    private Repositorio repositorioAlunos;

    public Turma(String codigo) {
        this.codigo = codigo;
    }

    public boolean matricular(Aluno aluno) {
        if (aluno == null)
            return false;
        if (aluno.getMatricula() == null)
            return false; // OU usar exceções
        if (buscarPorMatricula(aluno.getMatricula()) != null)
            return false;
        repositorioAlunos.guardarAluno(aluno);
        return true;
    }

    public Aluno buscarPorMatricula(String matricula) {
        if (matricula == null)
            return null;
        for (int i = 0; i < repositorioAlunos.getSizeAlunos(); i++) {
            Aluno atual = repositorioAlunos.getAluno(i);
            if (matricula.equals(atual.getMatricula())) {
                return atual;
            }
        }
        return null;
    }

    public boolean desmatricular(String matricula) {

        if (matricula == null)
            return false;

        for (int i = 0; i < repositorioAlunos.getSizeAlunos(); i++) {
            Aluno atual = repositorioAlunos.getAluno(i);
            if (matricula.equals(atual.getMatricula())) {
                alunos.remove(i);
                return true;
            }
        }
        return false;
    }
}