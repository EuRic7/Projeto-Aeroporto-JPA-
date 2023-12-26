package classes;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import infraestrutura.DAO;

@Entity
@Table(name = "Aviões")
public class Aviao {
    @Id
    private int idAviao;
    private String modelo;
    private String capacidade;
    private String fabricante;
    //@OneToMany(mappedBy = "aviao")
    private String voos;

    public Aviao() {

    }

    public Aviao(int idAviao, String modelo, String capacidade, String fabricante, String voo) {
        super();
        this.idAviao = idAviao;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.fabricante = fabricante;
        this.voos = voo;
    }

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String novaCapacidade) {
        this.capacidade = novaCapacidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getVoos() {
        return voos;
    }

    public void setVoos(String voos) {
        this.voos = voos;
    }

    // cadastrar avião
    public static void cadastrarAviao() {
        // Obtém os dados do novo avião do usuário
        Aviao novoAviao = obterAviao();

        // Cria uma instância do DAO para a classe Aviao
        DAO<Aviao> daoAviao = new DAO<>(Aviao.class);

        // Utiliza o método de incluir do DAO para cadastrar o novo avião
        daoAviao.atomicidade(novoAviao);

        System.out.println("Avião cadastrado com sucesso!");
    }

    // remover avião
    public static void removerAviao() {
        // Obtém o ID do avião a ser removido do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do Avião a ser removido: ");
        int idAviao = scanner.nextInt();

        // Cria uma instância do DAO para a classe Aviao
        DAO<Aviao> daoAviao = new DAO<>(Aviao.class);

        // Utiliza o método de remover do DAO para excluir o avião
        daoAviao.remover(idAviao);

        System.out.println("Avião removido com sucesso!");
    }

    // alterar avião
    public static void alterarAviao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do Aviao que deseja alterar:");
        int idAviao = scanner.nextInt();

        // Cria uma instância do DAO para a classe Aeroporto
        DAO<Aviao> daoAviao = new DAO<>(Aviao.class);

        // Busca o avião no banco de dados com base no ID fornecido
        Aviao AviaoParaAlterar = daoAviao.abrirT().buscarPorId(idAviao);

        if (AviaoParaAlterar != null) {
            // Solicita ao usuário para fornecer os novos dados
            System.out.println("Digite o novo modelo do avião:");
            scanner.nextLine(); // Consumir a quebra de linha
            String novoModelo = scanner.nextLine();

            System.out.println("Digite a nova capacidade do avião:");
            String novaCapacidade = scanner.nextLine();

            System.out.println("Digite o novo fabricante do avião:");
            String novoFabricante = scanner.nextLine();

            // Atualiza os dados do avião
            AviaoParaAlterar.setModelo(novoModelo);
            AviaoParaAlterar.setCapacidade(novaCapacidade);
            AviaoParaAlterar.setFabricante(novoFabricante);

            // Chama o método DAO para persistir as alterações
            daoAviao.fecharT().alterar(AviaoParaAlterar, idAviao);

            System.out.println("Dados do avião alterados com sucesso!");
        } else {
            System.out.println("avião não encontrado para o ID fornecido: " + idAviao);
        }
    }

    // Obter lista de aviões
    public static void listarAviao() {
        // Cria uma instância do DAO para a classe Aviao
        DAO<Aviao> daoAviao = new DAO<>(Aviao.class);

        // Obtém a lista completa de aviões
        List<Aviao> avioes = daoAviao.obterLista();

        // Exibe os aviões
        for (Aviao aviao : avioes) {
            System.out.println(aviao); // Alterado aqui para imprimir o objeto avião
        }
    }

    // ler dados do usuario para avião
    public static Aviao obterAviao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o id do avião:");
        int idAviao = scanner.nextInt();

        System.out.println("Digite o modelo do avião:");
        scanner.nextLine(); // Consumir a quebra de linha
        String modelo = scanner.nextLine();

        System.out.println("Digite a capacidade do avião:");
        String capacidade = scanner.nextLine();

        System.out.println("Digite o fabricante do avião:");
        String fabricante = scanner.nextLine();

        System.out.println("Digite o voo do avião:");
        String voo = scanner.nextLine();

        // Cria e retorna uma nova instância de Aviao com os dados fornecidos pelo usuário
        return new Aviao(idAviao, modelo, capacidade, fabricante, voo);
    }

    // Adicionado o método toString
    @Override
    public String toString() {
        return "Aviao [idAviao=" + idAviao + ", modelo=" + modelo + ", capacidade=" + capacidade + ", fabricante="
                + fabricante + ", voos=" + voos + "]";
    }
}
