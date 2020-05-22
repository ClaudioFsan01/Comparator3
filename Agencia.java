import java.util.List;
import java.util.ArrayList;


public class Agencia {
	/*
	Também declaramos atributos como List em vez de nos comprometer com uma ou outra
	implementação. Dessa forma obtemos um baixo acoplamento: podemos trocar a implementação, já que
	estamos programando para a interface! Por exemplo: */
   /*
	private List<ContaCorrente> contasCorrentes;
	private List<ContaPoupanca> constasPoupancas;
	*/
	
	private List<Conta> listaContas = new ArrayList<>(); // criando a lista de conta corrente ou poupança
	
	/*
	 É boa prática trabalhar com a interface em todos os lugares possíveis:
    métodos que precisam receber, retornar uma lista de objetos ou add objetos em uma lista têm List como parâmetro em vez de uma
    implementação em específico como ArrayList , deixando o método mais flexível:
	 */
	
	// tanto a classe ArrayList quanto a LinkedList implementam a interface List

	public void inserirConta(Conta conta) {
			
		if(listaContas.add(conta)==true) {
			System.out.println(" Conta inserida com sucesso ! \n");
		}else {
			System.out.println(" Conta não foi inserida com sucesso ! \n");
		}
		
	}
	
	/*
	public void inserirContaPoupanca(ContaPoupanca conta) {
		
		constasPoupancas = new LinkedList<>();
		
		constasPoupancas.add(conta);
		
	}
	*/
	public List<Conta> retornaListaContas(){
		tratarListaVazia(); // verifica se a lista está vazia no caso de contas igual a nulo
		return listaContas;  // retonra a lista de conta corrente
	}
	
	/*
	public List<ContaPoupanca> retornaListaContaPoupanca(){
		return constasPoupancas;  // retonra a lista de conta poupanças
	}*/
	
	// pesquisar conta pelo index
	
	
	
	// remover uma conta da lista
	
	public void removerConta(int index ) {
		tratarListaVazia();
		
		  if(listaContas.remove(index) !=null) {
			  System.out.println(" Elemento removido com sucesso !");
		  }else {
			  System.out.println(" Elemento não foi removido com sucesso !");
		  }
	}
	
	public boolean removerContaPeloNumero(int numero) {
		tratarListaVazia();
		
		Conta conta = pesquisarContaPeloNumero(numero);			
			
		      if(conta != null) {
		    	  listaContas.remove(conta); // se o numero da conta do objeto acessado for igual ao numero passado no parametro 
					// o objeto em questao será removido da lista
					return true;		    	  
		      }	
		
		return false;		
		
		
	}
	
	// alterar contas na lista 
	
	/*public void alterarContas(int numeroContaAntiga, Conta nova) {
		
		if(removerContaPeloNumero(numeroContaAntiga)) {
			System.out.println("Conta antiga removida com sucesso ! \n");
		}else {
			System.out.println("Conta antiga não foi removida com sucesso ! \n");
		}
		
		inserirConta(nova);
		
	}*/
	
	
	// atualizar endereço da conta
	
	
	public boolean atualizarEndereco(int numeroConta, String endereco) {
		  
		tratarListaVazia();
		
		Conta conta = pesquisarContaPeloNumero(numeroConta);
		 
		 if(conta != null) {
			 conta.setEndereco(endereco);
			 return true;
		 }		
		
		return false;
	}
	
	
   public Conta pesquisarContaPeloNumero(int numero) {
		
		tratarListaVazia();				
		
		for(Conta conta : listaContas) {// percorrendo cada item da lista contas e atribuindo cada objeto a variavel conta  // forEch em java
			if(conta.numero == numero) { // verificando se o numero da conta de cada objeto acessado na lista contas é igual ao numero passado no parametro
				
				return conta;// caso possua na lista uma conta com o numero igual passado no parametro essa conta sera retornada
			}		
			
		}		
		
		return null;	// caso não possua uma conta com o numero igual ao pesquisado	
		
	}
	
	
	
	
	public void tratarListaVazia() { // verifica se a lista está vazia caso sim lança a exceção de ponteiro nulo
		if(listaContas.isEmpty()) { //contas.isEmpty() retorna true se a lista não contem elementos
			throw new NullPointerException(" Lista não possui conta cadastrada ! \n"); 
		}
		
	}
	
	
	
}
