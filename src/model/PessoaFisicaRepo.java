
/**
 *
 * @author ruanf
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private List<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }

    /* Método para inserir Pessoa Fisica no Sistema */
    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    /* Método para alterar Pessoa Fisica no Sistema */
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            PessoaFisica pf = pessoasFisicas.get(i);
            if (pf.getId() == pessoaFisica.getId()) {
                pessoasFisicas.set(i, pessoaFisica);
                break;
            }
        }
    }

    /* Método para excluir Pessoa Fisica no Sistema */
    public void excluir(int id) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            PessoaFisica pf = pessoasFisicas.get(i);
            if (pf.getId() == id) {
                pessoasFisicas.remove(i);
                break;
            }
        }
    }

    /* Método para obter Pessoa Juridica do Sistema pelo id */
    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : pessoasFisicas) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }

    /* Método para obter todas as Pessoas Juridicas do Sistema */
    public List<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    /* Método para persistir os dados */
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasFisicas);
        }
    }

    /* Método para recuperar os dados */
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (List<PessoaFisica>) inputStream.readObject();
        }
    }
}

