package classes;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import infraestrutura.DAO;

@Entity
@Table(name = "Reservas")
public class Reserva {

    @Id
    private int idReserva;
    private String codigoAssento;
    //@ManyToOne
    private Passageiro passageiro;

   // @OneToMany(mappedBy = "compra")
    private Compra compra;

    //@ManyToOne
    private String voo;

    public Reserva() {
        // TODO Auto-generated constructor stub
    }

    public Reserva(int idReserva, String codigoAssento) {
        super();
        this.idReserva = idReserva;
        this.codigoAssento = codigoAssento;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getCodigoAssento() {
        return codigoAssento;
    }

    public void setCodigoAssento(String codigoAssento) {
        this.codigoAssento = codigoAssento;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public String getVoo() {
        return voo;
    }

    public void setVoo(String voo) {
        this.voo = voo;
    }

    // Adicionado o método toString
    @Override
    public String toString() {
        return "Reserva [idReserva=" + idReserva + ", codigoAssento=" + codigoAssento + ", passageiro=" + passageiro
                + ", compra=" + compra + ", voo=" + voo + "]";
    }

    // cadastrar reserva
    public static void cadastrarReserva() {
        // Obtém os dados do novo reserva do usuário
        Reserva novaReserva = obterReserva();
        // Cria uma instância do DAO para a classe reserva
        DAO<Reserva> daoReserva = new DAO<>(Reserva.class);
        // Utiliza o método de incluir do DAO para cadastrar o novo reserva
        daoReserva.atomicidade(novaReserva);
        System.out.println("Reserva cadastrado com sucesso!");
    }

    // remover reserva
    public static void removerReserva() {
        // Obtém o ID da reserva a ser removida do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do Reserva a ser removido: ");
        int idReserva = scanner.nextInt();

        // Cria uma instância do DAO para a classe Reserva
        DAO<Reserva> daoReserva = new DAO<>(Reserva.class);

        // Utiliza o método de remover do DAO para excluir o Reserva
        daoReserva.remover(idReserva);

        System.out.println("Reserva removido com sucesso!");
    }

    // alterar reserva
    public static void alterarReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do Reserva que deseja alterar:");
        int idReserva = scanner.nextInt();

        // Cria uma instância do DAO para a classe Reserva
        DAO<Reserva> daoReserva = new DAO<>(Reserva.class);

        // Busca o Reserva no banco de dados com base no ID fornecido
        Reserva reservaParaAlterar = daoReserva.abrirT().buscarPorId(idReserva);

        if (reservaParaAlterar != null) {
            // Solicita ao usuário para fornecer os novos dados
            System.out.println("Digite o novo modelo do avião:");
            scanner.nextLine(); // Consumir a quebra de linha
            String novoCodigoAssento = scanner.nextLine();

            // Atualiza os dados do Reserva
            reservaParaAlterar.setCodigoAssento(novoCodigoAssento);

            // Chama o método DAO para persistir as alterações
            daoReserva.fecharT().alterar(reservaParaAlterar, idReserva);

            System.out.println("Dados do avião alterados com sucesso!");
        } else {
            System.out.println("Reserva não encontrado para o ID fornecido: " + idReserva);
        }
    }

    // Obter lista de Reserva
    public static void listarReserva() {
        // Cria uma instância do DAO para a classe Aviao
        DAO<Reserva> daoReserva = new DAO<>(Reserva.class);

        // Obtém a lista completa de aviões
        List<Reserva> reservas = daoReserva.obterLista();

        // Exibe os aviões
        for (Reserva reserva : reservas) {
            System.out.println(reservas);
        }
    }

    // ler dados do usuario para reserva
    public static Reserva obterReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o id do Reserva:");
        int idReserva = scanner.nextInt();

        // Limpar o buffer do Scanner após a leitura do número inteiro
        scanner.nextLine();

        System.out.println("Digite o modelo do Reserva:");
        String codigoAssento = scanner.nextLine();

        // Cria e retorna uma nova instância de Reserva com os dados fornecidos pelo
        // usuário
        return new Reserva(idReserva, codigoAssento);
    }
}
