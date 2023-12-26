package classes;

import classes.Aeroporto;
import classes.Aviao;
import classes.Cliente;
//import classes.Compra;
import classes.Passageiro;
import infraestrutura.DAO;

import java.util.Scanner;

public class MenuCont {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        // menu principal
        while (true) {
            displayMainMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    menuCliente();
                    break;
                case 2:
                    menuAeroporto();
                    break;
                case 3:
                    menuVoo();
                    break;
                case 4:
                    menuAviao();
                    break;
                case 5:
                    menuCompra();
                    break;
                case 6:
                    menuPassageiro();
                    break;
                case 7:
                    menuReserva();
                    break;
                case 8:
                    System.out.println("Saindo do programa. Até logo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Menu Cliente");
        System.out.println("2. Menu Aeroporto");
        System.out.println("3. Menu Voo");
        System.out.println("4. Menu Avião");
        System.out.println("5. Menu Compra");
        System.out.println("6. Menu Passageiro");
        System.out.println("7. Menu Reserva");
        System.out.println("8. Sair");
    }

//Menu aeroporto
   public static void menuAeroporto(){
    while (true) {
        System.out.println("Menu Aeroporto:");
        System.out.println("1. Cadastrar Aeroporto");
        System.out.println("2. Remover Aeroporto");
        System.out.println("3. Alterar Aeroporto");
        System.out.println("4. Listar Aeroporto");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção:");

       
		int escolha = scanner.nextInt();
        

        switch (escolha) {
            case 1:
            	
            	Aeroporto.cadastrarAeroporto();
                break;
            case 2:
            	Aeroporto.removerAeroporto();
                break;
            case 3:
            	Aeroporto.alterarAeroporto();
                break;
            case 4:
            	Aeroporto.listarAeroporto();
                break;
            case 0:
                System.out.println("Saindo do Menu Aeroporto. Até mais!");
                System.exit(0);
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
 
    }
   }
 
//Menu Avião
   
   public static void menuAviao(){

	    while (true) {
	        System.out.println("Menu Aeroporto:");
	        System.out.println("1. Cadastrar Avião");
	        System.out.println("2. Remover Avião");
	        System.out.println("3. Alterar Avião");
	        System.out.println("4. Listar Avião");
	        System.out.println("0. Sair");
	        System.out.println("Escolha uma opção:");

	        
			int escolha = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer

	        switch (escolha) {
	            case 1:
	            	Aviao.cadastrarAviao();
	                break;
	            case 2:
	            	Aviao.removerAviao();
	                break;
	            case 3:
	            	Aviao.alterarAviao();
	                break;
	            case 4:
	            	Aviao.listarAviao();
	                break;
	            case 0:
	                System.out.println("Saindo do Menu Avião. Até mais!");
	                System.exit(0);
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	        }
	 
	    }
	   }

//Menu cliente
  
   public static void menuCliente(){

	    while (true) {
	        System.out.println("Menu Cliente:");
	        System.out.println("1. Cadastrar Cliente");
	        System.out.println("2. Remover Cliente");
	        System.out.println("3. Alterar Cliente");
	        System.out.println("4. Listar Clientes");
	        System.out.println("0. Sair");
	        System.out.println("Escolha uma opção:");

	       
			int escolha = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer

	        switch (escolha) {
	            case 1:
	                Cliente.cadastrarCliente();
	                break;
	            case 2:
	            	Cliente.removerCliente();
	                break;
	            case 3:
	            	Cliente.alterarCliente();
	                break;
	            case 4:
	            	Cliente.listarCliente();
	                break;
	            case 0:
	                System.out.println("Saindo do Menu Cliente. Até mais!");
	                System.exit(0);
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	        }
	 
	    }
	   }

//Menu Compra
   public static void menuCompra(){
	    while (true) {
	        System.out.println("Menu Compra:");
	        System.out.println("1. Cadastrar Compra");
	        System.out.println("2. Remover Compra");
	        System.out.println("3. Alterar Compra");
	        System.out.println("4. Listar Compras");
	        System.out.println("0. Sair");
	        System.out.println("Escolha uma opção:");

			int escolha = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer

	       
	 
	    }
	   }

//Menu Passageiro
   public static void menuPassageiro(){
	    while (true) {
	        System.out.println("Menu Passageiro:");
	        System.out.println("1. Cadastrar Passageiro");
	        System.out.println("2. Remover Passageiro");
	        System.out.println("3. Alterar Passageiro");
	        System.out.println("4. Listar Passageiros");
	        System.out.println("0. Sair");
	        System.out.println("Escolha uma opção:");

	        int escolha = scanner.nextInt();
	         // Limpar o buffer

	        switch (escolha) {
	            case 1:
	                Passageiro.cadastrarPassageiro();
	                break;
	            case 2:
	                Passageiro.removerPassageiro();
	                break;
	            case 3:
	                Passageiro.alterarPassageiro();
	                break;
	            case 4:
	                Passageiro.listarPassageiro();
	                break;
	            case 0:
	                System.out.println("Saindo do Menu Passageiro. Até mais!");
	                System.exit(0);
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	        }
	 
	    }
	   }

//Menu Reserva
   
   public static void menuReserva(){
	    while (true) {
	        System.out.println("Menu Reserva:");
	        System.out.println("1. Cadastrar Reserva");
	        System.out.println("2. Remover Reserva");
	        System.out.println("3. Alterar Reserva");
	        System.out.println("4. Listar Reserva");
	        System.out.println("0. Sair");
	        System.out.println("Escolha uma opção:");

	        
			int escolha = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer

	        
	 
	    }
	   }

   //Menu Voo 
   public static void menuVoo(){
	    while (true) {
	        System.out.println("Menu Voo:");
	        System.out.println("1. Cadastrar Voo");
	        System.out.println("2. Remover Voo");
	        System.out.println("3. Alterar Voo");
	        System.out.println("4. Listar Voo");
	        System.out.println("0. Sair");
	        System.out.println("Escolha uma opção:");

	        int escolha = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer

	       
	 
	    }
	   }





}