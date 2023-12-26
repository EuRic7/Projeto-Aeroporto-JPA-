package classes;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import infraestrutura.DAO;

@Entity
@Table(name = "Aeroportos")
public class Aeroporto {
    @Id
    private int idAeroporto;
    private String nome;
    private String cidade;
    private String estado;
    private String pais;
    private String voo;

    public Aeroporto() {

    }

    public Aeroporto(int idAeroporto, String nome, String cidade, String estado, String pais, String voo) {
        super();
        this.idAeroporto = idAeroporto;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public int getIdAeroporto() {
        return idAeroporto;
    }

    public void setIdAeroporto(int idAeroporto) {
        this.idAeroporto = idAeroporto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public void setVoo(String voo) {
        this.pais = voo;
    }

    //Cadastrar aeroporto
    public static void cadastrarAeroporto() {
        // Obtém os dados do novo aeroporto do usuário
        Aeroporto novoAeroporto = obterAeroporto();
        // Cria uma instância do DAO para a classe aeroporto
        DAO<Aeroporto> daoAeroporto = new DAO<>(Aeroporto.class);
        // Utiliza o método de incluir do DAO para cadastrar o novo aeroporto
        daoAeroporto.atomicidade(novoAeroporto);
        System.out.println("Aeroporto cadastrado com sucesso!");
    }

    //remover  aeroporto
    public static void removerAeroporto() {
        // Mantive o uso do Scanner aqui para ilustrar, mas pode precisar de ajustes
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o ID do aeroporto que deseja remover:");
            int idAeroporto = scanner.nextInt();

            // Cria uma instância do DAO para a classe Aeroporto
            DAO<Aeroporto> aeroportoDao = new DAO<>(Aeroporto.class);

            // Chama o método DAO para remover o aeroporto
            aeroportoDao.remover(idAeroporto);

            System.out.println("Aeroporto removido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //alterar aeroporto
    public static void alterarAeroporto() {
        // Mantive o uso do Scanner aqui para ilustrar, mas pode precisar de ajustes
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o ID do aeroporto que deseja alterar:");
            int idAeroporto = scanner.nextInt();

            // Cria uma instância do DAO para a classe Aeroporto
            DAO<Aeroporto> aeroportoDao = new DAO<>(Aeroporto.class);

            // Busca o aeroporto no banco de dados com base no ID fornecido
            Aeroporto aeroportoParaAlterar = aeroportoDao.abrirT().buscarPorId(idAeroporto);

            if (aeroportoParaAlterar != null) {
                // Solicita ao usuário para fornecer os novos dados
                System.out.println("Digite o novo nome do aeroporto:");
                scanner.nextLine(); // Consumir a quebra de linha
                String novoNome = scanner.nextLine();

                System.out.println("Digite a nova cidade do aeroporto:");
                String novaCidade = scanner.nextLine();

                System.out.println("Digite o novo estado do aeroporto:");
                String novoEstado = scanner.nextLine();

                System.out.println("Digite o novo país do aeroporto:");
                String novoPais = scanner.nextLine();

                // Atualiza os dados do aeroporto
                aeroportoParaAlterar.setNome(novoNome);
                aeroportoParaAlterar.setCidade(novaCidade);
                aeroportoParaAlterar.setEstado(novoEstado);
                aeroportoParaAlterar.setPais(novoPais);

                // Chama o método DAO para persistir as alterações
                aeroportoDao.fecharT().alterar(aeroportoParaAlterar, idAeroporto);

                System.out.println("Dados do aeroporto alterados com sucesso!");
            } else {
                System.out.println("Aeroporto não encontrado para o ID fornecido: " + idAeroporto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   //ler dados do usuario para aeroporto 
    public static Aeroporto obterAeroporto() {
        // Mantive o uso do Scanner aqui para ilustrar, mas pode precisar de ajustes
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o id do aeroporto:");
            int idAeroporto = scanner.nextInt();
            // Limpar o buffer do Scanner após a leitura do número inteiro
            scanner.nextLine();

            System.out.println("Digite o nome do aeroporto:");
            String nome = scanner.nextLine();

            System.out.println("Digite a cidade do aeroporto:");
            String cidade = scanner.nextLine();

            System.out.println("Digite o estado do aeroporto:");
            String estado = scanner.nextLine();

            System.out.println("Digite o país do aeroporto:");
            String pais = scanner.nextLine();

            System.out.println("Digite o voo do aeroporto:");
            String voo = scanner.nextLine();

            // Cria e retorna uma nova instância de Aeroporto com os dados fornecidos pelo usuário
            return new Aeroporto(idAeroporto, nome, cidade, estado, pais, voo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
  //dados dos aeropostos cadastrados
    public static void listarAeroporto() {
        // Cria uma instância do DAO para a classe aeroporto
        DAO<Aeroporto> daoAeroporto = new DAO<>(Aeroporto.class);

        // Obtém a lista completa de aeroportos
        List<Aeroporto> aeroportos = daoAeroporto.obterLista();

        // Exibe os aeroportos
        for (Aeroporto aeroporto : aeroportos) {
            System.out.println(aeroporto);
        }
    }

    @Override
    public String toString() {
        return "Aeroporto [idAeroporto=" + idAeroporto + ", nome=" + nome + ", cidade=" + cidade + ", estado=" + estado
                + ", pais=" + pais + "]";
    }
}
