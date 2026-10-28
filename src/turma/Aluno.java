import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Aluno implements Serializable {
    private String matricula;
    private String nome;

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void salvar(String caminho, ArrayList<Aluno> lista) throws IOException {

        ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(caminho));

        try {
            saida.writeObject(lista);
        } finally {
            saida.close();
        }
    }

    public ArrayList<Aluno> carregar(String caminho)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(caminho))) {

            Object dados = entrada.readObject();

            return (ArrayList<Aluno>) dados;
        }
    }

}