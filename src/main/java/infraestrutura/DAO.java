package infraestrutura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class DAO<E> {

	//Criamos apenas uma unica vez --> emf --> serve para caada novo dao
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	//inicialização
	static {
		try {
			emf = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		} catch(Exception e) {
			e.printStackTrace();
	        throw new RuntimeException("Erro ao inicializar o EntityManagerFactory.", e);
			
		}
	}
	//construtor padrão
	public DAO() {
		
		this(null);
	}
	
	///conexão--> construtor que recebe a classe
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	///metodo parar abrir a transação
	
	public DAO<E> abrirT(){
		em.getTransaction().begin();
		return this;
	}
	
	///metodo parar fechar a transação
	public DAO<E> fecharT(){
		em.getTransaction().commit();
		return this;
	}

	///metodo parar incluir transação
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}

	///metodo para 3 em 1
		public DAO<E> atomicidade(E entidade){
			return this.abrirT().incluir(entidade).fecharT();	
		}
		
	//listagem
	public List<E> obterLista(int limit){
		//caso classe seja nula
		if(classe==null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		String jpql = "select e from "  + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(limit);
		return query.getResultList();
		
	}
	
	//listagem padrão do sistema
	public List<E> obterLista(){
		return this.obterLista(15);
	}
	
	public void fechar() {
		em.close();
	}
	

	
	public DAO<E> alterar(E entidade, int ident) {
	    
	        this.abrirT(); // Abre a transação
	        // Use o método find para obter a entidade atual no banco de dados com base no identificador
	        E entidadeAtualizada = em.find(classe, ident);
	        
	        // Verifique se a entidade foi encontrada
	        if (entidadeAtualizada != null) {
	            // Atualize os atributos da entidade com os valores da entidade fornecida
	           
	            //exemplo -->entidadeAtualizada.setId(entidade.getId());
	            // Atualize outros atributos conforme necessário

	 
	            em.merge(entidadeAtualizada);
	           
	        } else {
	            System.out.println("Entidade não encontrada para o ID fornecido: " + ident);
	        }
	  
	        this.fecharT(); 
	        this.fechar(); 
	        return (DAO<E>) entidadeAtualizada;
	}

	// Método para remover uma entidade com base no identificador
    public void remover(int ident) {
        this.abrirT();
        E entidadeParaRemover = em.find(classe, ident);

        if (entidadeParaRemover != null) {
            em.remove(entidadeParaRemover);
            System.out.println("Entidade removida com sucesso!");
        } else {
            System.out.println("Entidade não encontrada para o ID fornecido: " + ident);
        }

        this.fecharT(); 
        this.fechar(); 
    }

	
	
    public E buscarPorId(int id) {
        try {
            return em.find(classe, id);
        } finally {
            this.fechar(); // Fecha o EntityManager
        }
    }


	
}
