package classes;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import infraestrutura.DAO;

@Entity
@Table(name = "Passageiros")
public class Passageiro {
    @Id
    private int idPassageiro;
    private String cpf;
    private String nome;
    private String dataNascimento;
    private String email;
    private String telefone;
    //@OneToMany(mappedBy = "passageiro")
    private String reservas;
    private String documento; // Adicionado ponto e vírgula aqui

    public Passageiro() {

    }

    public Passageiro(int idPassageiro, String cpf, String nome, String dataNascimento, String email, String telefone,
            String documento) { // Removido o parâmetro 'numeroCartao' aqui
        super();
        this.idPassageiro = idPassageiro;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.documento = documento;
        // Removido o parâmetro 'numeroCartao' da lista de parâmetros
    }

    public int getIdPassageiro() {
        return idPassageiro;
    }

    public void setIdPassageiro(int idPassageiro) {
        this.idPassageiro = idPassageiro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    // Adicionado o método toString
    @Override
    public String toString() {
        return "Passageiro [idPassageiro=" + idPassageiro + ", cpf=" + cpf + ", nome=" + nome + ", dataNascimento="
                + dataNascimento + ", email=" + email + ", telefone=" + telefone + ", reservas=" + reservas
                + ", documento=" + documento + "]";
    }

    // ler dados do usuario para passageiro
    public static Passageiro obterPassageiro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o novo id do passageiro:");
        int IdPassageiro = scanner.nextInt();

        System.out.println("Digite o cpf do passageiro:");
        scanner.nextLine(); // Consumir a quebra de linha
        String Cpf = scanner.nextLine();

        System.out.println("Digiteo nome do passageiro:");
        String Nome = scanner.nextLine();

        System.out.println("Digite a data de nascimento do passageiro:");
        String DataNascimento = scanner.nextLine();

        System.out.println("Digite o email do passageiro:");
        String Email = scanner.nextLine();

        System.out.println("Digiteo telefone do passageiro:");
        String Telefone = scanner.nextLine();
        
        System.out.println("Digiteo Documento do passageiro:");
        String Documento = scanner.nextLine();
        // Cria e retorna uma nova instância de passageiro com os dados fornecidos pelo
        // usuário
        return new Passageiro(IdPassageiro, Cpf, Nome, DataNascimento, Email, Telefone, Documento);
    }

    // cadastrar passageiro
    public static void cadastrarPassageiro() {
        // Obtém os dados do novo passageiro do usuário
        Passageiro novoPassageiro = obterPassageiro();
        // Cria uma instância do DAO para a classe passageiro
        DAO<Passageiro> daoPassageiro = new DAO<>(Passageiro.class);
        // Utiliza o método de incluir do DAO para cadastrar o novo passageiro
        daoPassageiro.atomicidade(novoPassageiro);
        System.out.println("Passageiro cadastrado com sucesso!");
    }

    // remover Passageiro
    public static void removerPassageiro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do passageiro que deseja remover:");
        int idPassageiro = scanner.nextInt();

        // Cria uma instância do DAO para a classe passageiro
        DAO<Passageiro> daoPassageiro = new DAO<>(Passageiro.class);

        // Chama o método DAO para remover o passageiro
        daoPassageiro.remover(idPassageiro);

        System.out.println("Passageiro removido com sucesso!");
    }

    // alterar PASSAGEIRO
    public static void alterarPassageiro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do passageiro que deseja alterar:");
        int idPassageiro = scanner.nextInt();

        // Cria uma instância do DAO para a classe compra
        DAO<Passageiro> daoPassageiro = new DAO<>(Passageiro.class);

        // Busca o passageiro no banco de dados com base no ID fornecido
        // falta buscar por id
        Passageiro passageiroParaAlterar = daoPassageiro.abrirT().buscarPorId(idPassageiro);

        if (passageiroParaAlterar != null) {
            // Solicita ao usuário para fornecer os novos dados
            System.out.println("Digite o novo id do passageiro:");
            scanner.nextLine(); // Consumir a quebra de linha
            int novoIdPassageiro = scanner.nextInt();

            System.out.println("Digite o cpf do passageiro:");
            scanner.nextLine(); // Consumir a quebra de linha
            String novoCpf = scanner.nextLine();

            System.out.println("Digiteo nome do passageiro:");
            String novoNome = scanner.nextLine();

            System.out.println("Digite a data de nascimento do passageiro:");
            String novaDataNascimento = scanner.nextLine();

            System.out.println("Digite o email do passageiro:");
            String novoEmail = scanner.nextLine();

            System.out.println("Digiteo telefone do passageiro:");
            String novoTelefone = scanner.nextLine();

            // Atualiza os dados do passageiro
            passageiroParaAlterar.setIdPassageiro(novoIdPassageiro);
            passageiroParaAlterar.setCpf(novoCpf);
            passageiroParaAlterar.setNome(novoNome);
            passageiroParaAlterar.setDataNascimento(novaDataNascimento);
            passageiroParaAlterar.setEmail(novoEmail);
            passageiroParaAlterar.setTelefone(novoTelefone);

            // Chama o método DAO para persistir as alterações
            daoPassageiro.fecharT().alterar(passageiroParaAlterar, idPassageiro);

            System.out.println("Dados do passageiro alterados com sucesso!");
        } else {
            System.out.println("passageiro não encontrado para o ID fornecido: " + idPassageiro);
        }
    }

    // dados dos passageiros cadastrados
    public static void listarPassageiro() {
        // Cria uma instância do DAO para a classe passageiros
        DAO<Passageiro> daoPassageiro = new DAO<>(Passageiro.class);

        // Obtém a lista completa de passageiro
        List<Passageiro> passageiros = daoPassageiro.obterLista();

        // Exibe os passageiro
        for (Passageiro passageiro : passageiros) {
            System.out.println(passageiro); // Alterado aqui para imprimir o objeto
        }
    }

}
