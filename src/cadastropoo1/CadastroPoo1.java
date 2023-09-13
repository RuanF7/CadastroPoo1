
package cadastropoo1;

/**
 *
 * @author ruanf
 */
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPoo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("#####################");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Persistir dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("#####################");            
            

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    /* Incluir Pessoa no Sistema*/
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica ");
                    String incluirPessoa = scanner.nextLine();                   

                    if (incluirPessoa.equals("F")) {
                        /* Incluir Pessoa Física */
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Insira os dados... ");                        
                        System.out.print("\n Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();

                        PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                        repoFisica.inserir(pf);
                        System.out.println("Pessoa Física adicionada com sucesso.");
                    } else if (incluirPessoa.equals("J")) {
                        /* Incluir Pessoa Jurídica */
                        System.out.print("Digite o id da pessoa: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Insira os dados... ");
                        scanner.nextLine();
                        System.out.print("Nome da Empresa: ");
                        String nomeEmpresa = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica pj = new PessoaJuridica( id, nomeEmpresa, cnpj);
                        repoJuridica.inserir(pj);
                        System.out.println("Pessoa Jurídica adicionada com sucesso.");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    /* Alterar Pessoa no Sistema */
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica ");
                    String alterarPessoa = scanner.nextLine();
                    scanner.nextLine(); 
                    System.out.print("Digite o ID da Pessoa para alterar: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); 

                    if (alterarPessoa.equals("F")) {
                        /* Alterar Pessoa Física */
                        PessoaFisica pf = repoFisica.obter(idAlterar);
                        if (pf != null) {
                            System.out.print("Novo Nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("Novo CPF: ");
                            String novoCpf = scanner.nextLine();
                            System.out.print("Nova Idade: ");
                            int novaIdade = scanner.nextInt();

                            pf.setNome(novoNome);
                            pf.setCpf(novoCpf);
                            pf.setIdade(novaIdade);
                            
                            /* Chamando o método para alterar passando o objeto modificado */
                            repoFisica.alterar(pf); 
                            System.out.println("Pessoa Física alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (alterarPessoa.equals("J")) {
                        /* Alterar Pessoa Jurídica */
                        PessoaJuridica pj = repoJuridica.obter(idAlterar);
                        if (pj != null) {
                            System.out.print("Novo Nome da Empresa: ");
                            String novoNomeEmpresa = scanner.nextLine();
                            System.out.print("Novo CNPJ: ");
                            String novoCnpj = scanner.nextLine();

                            pj.setNome(novoNomeEmpresa);
                            pj.setCnpj(novoCnpj);
                            /* Chamando o método para alterar passando o objeto modificado */
                            repoJuridica.alterar(pj);
                            System.out.println("Pessoa Jurídica alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 3:
                    /* Excluindo Pessoa do Sistema */
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica ");
                    String excluirPessoa = scanner.nextLine();
                    scanner.nextLine(); 
                    System.out.print("Digite o ID da Pessoa que para excluir: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine(); 

                    if (excluirPessoa.equals("F")) {
                        /* Excluir Pessoa Física */
                        repoFisica.excluir(idExcluir);
                        System.out.println("Pessoa Física excluída com sucesso.");
                    } else if (excluirPessoa.equals("J")) {
                        /* Excluir Pessoa Jurídica */
                        repoJuridica.excluir(idExcluir);
                        System.out.println("Pessoa Jurídica excluída com sucesso.");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 4:
                    /* Exibir Pessoa do Sistema pelo ID */
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica ");
                    String exibirPorId = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Digite o ID da Pessoa para exibir: ");
                    int idExibir = scanner.nextInt();
                    scanner.nextLine();

                    if (exibirPorId.equals("F")) {
                        /* Exibir Pessoa Física por ID */
                        PessoaFisica pf = repoFisica.obter(idExibir);
                        if (pf != null) {
                            pf.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (exibirPorId.equals("J")) {
                        /* Exibir Pessoa Jurídica por ID */
                        PessoaJuridica pj = repoJuridica.obter(idExibir);
                        if (pj != null) {
                            pj.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 5:
                    /* Exibir Todas as Pessoas do Sistema */
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica ");
                    String exibirTodos = scanner.nextLine();                    

                    if (exibirTodos.equals("F")) {
                        /* Exibir todas as Pessoas Físicas */
                        for (PessoaFisica pf : repoFisica.obterTodos()) {
                            pf.exibir();
                        }
                    } else if (exibirTodos.equals("J")) {
                        /* Exibir todas as Pessoas Jurídicas */
                        for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                            pj.exibir();
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 6:
                    /* Persistir dados */
                    System.out.print("Digite um id para Salvar o arquivo: ");
                    String persistirDados = scanner.nextLine();

                    try {
                        repoFisica.persistir(persistirDados + ".fisica.bin");
                        repoJuridica.persistir(persistirDados + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;

                case 7:
                    /* Recuperar dados */
                    System.out.print("Digite o id do arquivo para recuperação: ");
                    String recuperarDados = scanner.nextLine();

                    try {
                        repoFisica.recuperar(recuperarDados + ".fisica.bin");
                        repoJuridica.recuperar(recuperarDados + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;

                case 0:
                    /* Sair */
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
                }
        }
        
    }
    
}
