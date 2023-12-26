package classes;

public class MenuBancoDados {
    // Método para exibir o menu de escolha de tabela
	
	
	
	
	
    public static void exibirMenuTabelas() {
    	for(int i = 0; i < 5; i++) {
    		System.out.println("");
    		System.out.println("=======================");
    		
    	}
    	System.out.println("");
        System.out.println("Escolha uma tabela:");
        System.out.println("1. Cliente");
        System.out.println("2. Passageiro");
        System.out.println("3. Compra");
        System.out.println("4. Reserva");
        System.out.println("5. Voo");
        System.out.println("6. Aeroporto");
        System.out.println("7. Avião");
        System.out.println("0. Sair do Programa");
        System.out.print("Escolha uma tabela: ");
    }

    // Método para realizar a escolha da tabela
    public static String escolherTabela(int opcao) {
        switch (opcao) {
            case 1:
                return "Cliente";
            case 2:
                return "Passageiro";
            case 3:
                return "Compra";
            case 4:
                return "Reserva";
            case 5:
                return "Voo";
            case 6:
                return "Aeroporto";
            case 7:
                return "Avião";
            
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        return null;
    }

    // Métodos para cada ação (com lógica para cada tabela)
    public static void cadastrar(String tabela) {
        System.out.println("Cadastrando na tabela " + tabela + "...");
    }

    public static void remover(String tabela) {
        System.out.println("Removendo da tabela " + tabela + "...");
    }

    public static void listar(String tabela) {
        System.out.println("Listando da tabela " + tabela + "...");
    }

    public static void alterar(String tabela) {
        System.out.println("Alterando na tabela " + tabela + "...");
    }

    // Método para exibir o menu de ações
    public static void exibirMenu() {
    	for(int i = 0; i < 5; i++) {
    		System.out.println("");
    		System.out.println("=======================");
    		
    	}
        System.out.println("Menu de Ações");
        System.out.println("1. Cadastrar");
        System.out.println("2. Remover");
        System.out.println("3. Listar");
        System.out.println("4. Alterar");
        System.out.println("0. Voltar ao menu de tabelas");
        System.out.print("Escolha uma ação: ");
    }

    // Método para realizar ação de cada opção do menu
    public static void realizarAcao(int opcao, String tabela) {
        switch (opcao) {
            case 1:
            	System.out.println("cadastrar tabela");
                break;
            case 2:
            	System.out.println("remover tabela");
                break;
            case 3:
            	System.out.println("Listar tabela");
                break;
            case 4:
            	System.out.println("Alterar tabela");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
