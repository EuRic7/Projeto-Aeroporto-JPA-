package classes;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import infraestrutura.DAO;

@Entity
@Table(name="Compras")
public class Compra {
    @Id
    private int idCompra;
    private String horario;
    private String numeroCartao;
   // @ManyToOne
    private Cliente cliente;
   // @ManyToOne
    private Reserva reserva;
    
    public Compra() {
        // TODO Auto-generated constructor stub
    }

    public Compra(int idCompra, String horario, String numeroCartao) {
        super();
        this.idCompra = idCompra;
        this.horario = horario;
        this.numeroCartao = numeroCartao;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public String toString() {
        return "Compra [idCompra=" + idCompra + ", horario=" + horario + ", numeroCartao=" + numeroCartao + ", cliente="
                + cliente + ", reserva=" + reserva + "]";
    }

    // Método para cadastrar compra
    public static void cadastrarCompra() {
        // Obtém os dados da nova compra do usuário
        Compra novaCompra = obterCompra();

        // Cria uma instância do DAO para a classe Compra
        DAO<Compra> daoCompra = new DAO<>(Compra.class);

        // Utiliza o método de incluir do DAO para cadastrar a nova compra
        daoCompra.atomicidade(novaCompra);

        System.out.println("Compra cadastrada com sucesso!");
    }

    // Método para remover compra
    public static void removerCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da compra que deseja remover:");
        int idCompra = scanner.nextInt();

        // Cria uma instância do DAO para a classe Compra
        DAO<Compra> daoCompra = new DAO<>(Compra.class);

        // Chama o método DAO para remover a compra
        daoCompra.remover(idCompra);

        System.out.println("Compra removida com sucesso!");
    }

    // Método para alterar compra
    public static void alterarCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da compra que deseja alterar:");
        int idCompra = scanner.nextInt();

        // Cria uma instância do DAO para a classe Compra
        DAO<Compra> daoCompra = new DAO<>(Compra.class);

        // Busca a compra no banco de dados com base no ID fornecido
        Compra compraParaAlterar = daoCompra.abrirT().buscarPorId(idCompra);

        if (compraParaAlterar != null) {
            // Solicita ao usuário para fornecer os novos dados
            System.out.println("Digite o novo horário da compra:");
            scanner.nextLine(); // Consumir a quebra de linha
            String novoHorario = scanner.nextLine();

            System.out.println("Digite o novo número do cartão da compra:");
            String novoNumeroCartao = scanner.nextLine();

            // Atualiza os dados da compra
            compraParaAlterar.setHorario(novoHorario);
            compraParaAlterar.setNumeroCartao(novoNumeroCartao);

            // Chama o método DAO para persistir as alterações
            daoCompra.fecharT().alterar(compraParaAlterar, idCompra);

            System.out.println("Dados da compra alterados com sucesso!");
        } else {
            System.out.println("Compra não encontrada para o ID fornecido: " + idCompra);
        }
    }

    // Método para listar compras
    public static void listarCompra() {
        // Cria uma instância do DAO para a classe Compra
        DAO<Compra> daoCompra = new DAO<>(Compra.class);

        // Obtém a lista completa de compras
        List<Compra> compras = daoCompra.obterLista();

        // Exibe as compras
        for (Compra compra : compras) {
            System.out.println(compra);
        }
    }

    // Método auxiliar para ler dados do usuário para compra
    public static Compra obterCompra() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID da Compra:");
        int idCompra = scanner.nextInt();

        System.out.println("Digite o horário da Compra:");
        scanner.nextLine(); // Consumir a quebra de linha
        String horario = scanner.nextLine();

        System.out.println("Digite o número do cartão da Compra:");
        String numeroCartao = scanner.nextLine();

        // Cria e retorna uma nova instância de Compra com os dados fornecidos pelo usuário
        return new Compra(idCompra, horario, numeroCartao);
    }
}
