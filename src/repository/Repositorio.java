package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.print.DocFlavor.READER;

import turma.Aluno;

public class Repositorio implements Serializable {

    private ArrayList<Aluno> alunos;

    public Repositorio(){
        alunos = new ArrayList<Aluno>();
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

    public void guardarAluno(Aluno aluno){

        if(aluno == null){
            throw new IllegalArgumentException("ERRO! Aluno Invalido");
        }

            this.alunos.add(aluno);

    }

    public int getSizeAlunos(){

        return this.alunos.size();

    }


}
