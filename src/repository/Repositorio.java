package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import turma.Aluno;

public class Repositorio implements Serializable {

    private ArrayList<Aluno> alunos;

    public Repositorio(){
        alunos = new ArrayList<Aluno>();
    }

    public void salvar(String caminho) throws IOException {

        ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(caminho));

        try {
            saida.writeObject(alunos);
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

    public void guardarAluno(Aluno aluno){

        if(aluno == null){
            throw new IllegalArgumentException("ERRO! Aluno Invalido");
        }

            alunos.add(aluno);

    }

    public void removerAluno(int indice){

        Aluno alunoAtual = alunos.get(indice);

            alunos.remove(alunoAtual);

    }

    public int getSizeAlunos(){

        return alunos.size();

    }

    public Aluno getAluno(int indiceAluno){

        Aluno alunoAtual = alunos.get(indiceAluno);

        return alunoAtual;

    }


}
