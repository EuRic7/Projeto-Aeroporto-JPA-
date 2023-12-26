package classes;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import infraestrutura.DAO;

@Entity
@Table(name="Cliente")
public class Cliente {
	@Id
	private int idCliente;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	public Cliente() {
		
	}



	public Cliente(int idCliente, String nome, String cpf, String telefone, String email) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}



	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
//ler dados do usuario para cliente
 public static Cliente obterCliente() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o Id do cliente:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();

        System.out.println("Digite o telefone do cliente:");
        String telefone = scanner.nextLine();

        System.out.println("Digite o e-mail do cliente:");
        String email = scanner.nextLine();

        // Cria uma instância de Cliente com os dados fornecidos pelo usuário
        return new Cliente(idCliente,nome, cpf, telefone, email);
    }

	//cadastrar cliente
	 public static void cadastrarCliente() {
		// Obtém os dados do novo cliente do usuário
			
		 Cliente novoCliente = obterCliente();
		    // Cria uma instância do DAO para a classe cliente
		    DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		    // Utiliza o método de incluir do DAO para cadastrar o novo cliente
		     daoCliente.atomicidade(novoCliente);
		     System.out.println("Cliente cadastrado com sucesso!");
	 }

	 //remover cliente
	 public static void removerCliente() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Digite o ID do cliente que deseja remover:");
	        int idCliente = scanner.nextInt();

	        // Cria uma instância do DAO para a classe Cliente
	        DAO<Cliente> clienteDao = new DAO<>(Cliente.class);

	        // Chama o método DAO para remover o cliente
	        clienteDao.remover(idCliente);

	        System.out.println("Cliente removido com sucesso!");
	    }
	 
	 //aleterar cliente
	  public static void alterarCliente() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Digite o ID do cliente que deseja alterar:");
	        int idCliente = scanner.nextInt();

	        // Cria uma instância do DAO para a classe Cliente
	        DAO<Cliente> clienteDao = new DAO<>(Cliente.class);

	        // Busca o cliente no banco de dados com base no ID fornecido
	        //falta definir no dao buscarporid
	        Cliente clienteParaAlterar = clienteDao.abrirT().buscarPorId(idCliente);

	        if (clienteParaAlterar != null) {
	            // Solicita ao usuário para fornecer os novos dados
	            System.out.println("Digite o novo nome do cliente:");
	            scanner.nextLine(); // Consumir a quebra de linha
	            String novoNome = scanner.nextLine();

	            System.out.println("Digite o novo CPF do cliente:");
	            String novoCpf = scanner.nextLine();

	            System.out.println("Digite o novo telefone do cliente:");
	            String novoTelefone = scanner.nextLine();

	            System.out.println("Digite o novo e-mail do cliente:");
	            String novoEmail = scanner.nextLine();

	            // Atualiza os dados do cliente
	            clienteParaAlterar.setNome(novoNome);
	            clienteParaAlterar.setCpf(novoCpf);
	            clienteParaAlterar.setTelefone(novoTelefone);
	            clienteParaAlterar.setEmail(novoEmail);

	            // Chama o método DAO para persistir as alterações
	            clienteDao.fecharT().alterar(clienteParaAlterar, idCliente);

	            System.out.println("Dados do cliente alterados com sucesso!");
	        } else {
	            System.out.println("Cliente não encontrado para o ID fornecido: " + idCliente);
	        }
	    }

	  // obter dados dos clientes
	  public static void listarCliente() {
		    // Cria uma instância do DAO para a classe clientes
		    DAO<Cliente> daoCliente = new DAO<>(Cliente.class);

		    // Obtém a lista completa de clientes
		    List<Cliente> clientes = daoCliente.obterLista();

		    // Exibe os clientes
		    for (Cliente cliente : clientes) {
		        System.out.println(clientes);
		    }
		}



	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone
				+ ", email=" + email + "]";
	}
	
}