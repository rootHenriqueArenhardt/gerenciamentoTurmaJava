import java.util.ArrayList;

public class Turma {
    private String codigo;
    private ArrayList<Aluno> alunos;

    public Turma(String codigo) {
        this.codigo = codigo;
        alunos = new ArrayList<Aluno>();
    }

    public boolean matricular(Aluno aluno) {
        if (aluno == null)
            return false;
        if (aluno.getMatricula() == null)
            return false; // OU usar exceções
        if (buscarPorMatricula(aluno.getMatricula()) != null)
            return false;
        alunos.add(aluno);
        return true;
    }

    public Aluno buscarPorMatricula(String matricula) {
        if (matricula == null)
            return null;
        for (int i = 0; i < alunos.size(); i++) {
            Aluno atual = alunos.get(i);
            if (matricula.equals(atual.getMatricula())) {
                return atual;
            }
        }
        return null;
    }

    public boolean desmatricular(String matricula) {

        if (matricula == null)
            return false;

        for (int i = 0; i < alunos.size(); i++) {
            Aluno atual = alunos.get(i);
            if (matricula.equals(atual.getMatricula())) {
                alunos.remove(i);
                return true;
            }
        }
        return false;
    }
}