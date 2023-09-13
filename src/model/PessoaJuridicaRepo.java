
/**
 *
 * @author ruanf
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private final ArrayList<PessoaJuridica> listaPessoasJuridicas;

    public PessoaJuridicaRepo() {
        listaPessoasJuridicas = new ArrayList<>();
    }
    /* Método para inserir Pessoa Juridica no Sistema */
    public void inserir(PessoaJuridica pessoaJuridica) {
        listaPessoasJuridicas.add(pessoaJuridica);
    }
    
    /* Método para alterar Pessoa Juridica no Sistema */
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
            PessoaJuridica pj = listaPessoasJuridicas.get(i);
            if (pj.getId() == pessoaJuridica.getId()) {
                listaPessoasJuridicas.set(i, pessoaJuridica);
                break;
            }
        }
    }

    /* Método para excluir Pessoa Juridica no Sistema */
    public void excluir(int id) {
        listaPessoasJuridicas.removeIf(p -> p.getId() == id);
    }

    /* Método para obter Pessoa Juridica do Sistema pelo id */
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoaJuridica : listaPessoasJuridicas) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }
    
    /* Método para obter todas as Pessoas Juridicas do Sistema */
    public ArrayList<PessoaJuridica> obterTodos() {
        return new ArrayList<>(listaPessoasJuridicas);
    }

    /* Método para persistir os dados */
    public void persistir(String nomeArquivo) throws IOException {
        try (FileWriter fileWriter = new FileWriter(nomeArquivo);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (PessoaJuridica pessoaJuridica : listaPessoasJuridicas) {
                bufferedWriter.write(
                        pessoaJuridica.getId() + "," +
                                pessoaJuridica.getNome() + "," +
                                pessoaJuridica.getCnpj() + ",");
                bufferedWriter.newLine();
            }
        }
    }

    /* Método para recuperar os dados */
    public void recuperar(String nomeArquivo) throws IOException {
        try (FileReader fileReader = new FileReader(nomeArquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            listaPessoasJuridicas.clear();
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] campos = linha.split(",");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                String cnpj = campos[2];
                PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                listaPessoasJuridicas.add(pessoaJuridica);
            }
        }
        System.out.println("Dados das pessoas jurídicas foram recuperados do arquivo " + nomeArquivo);
    }
    
    
}

/*public PessoaJuridica procurarPorId(int idProcurado) {
        for (PessoaJuridica pessoa : listaPessoasJuridicas) {
            if (pessoa.getId() == idProcurado) {
                return pessoa;
            }
        }
        return null;
    }
*/