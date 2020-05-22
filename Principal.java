
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	public static void main(String [] args) {
int op;
		
		Scanner sc = new Scanner(System.in);
		Agencia ag = new Agencia();
		CriterioOrdenacao co = new CriterioOrdenacao();
		Conta conta= null;
			
		 do {
			   op= menu(sc);
			   
			 switch(op){
			 
			 case 1:
				 
				  try {
					  conta = new ContaCorrente();				 
						 cadastrarConta(conta,sc);
						ag.inserirConta(conta);
						 
				  }catch(IllegalArgumentException e) {
					  System.out.println(" \n"+ e.getMessage());		
				  }catch(UnsupportedOperationException e) {
					  System.out.println(" \n"+ e.getMessage());	
				  }
				 
				 break;
				 
			 case 2:
				 try {
					 conta = new ContaPoupanca();				 
					 cadastrarConta(conta,sc);
					 ag.inserirConta(conta);
					 
				 }catch(IllegalArgumentException e) {
					  System.out.println(" \n"+ e.getMessage());		
				  }catch(UnsupportedOperationException e) {
					  System.out.println(" \n"+ e.getMessage());	
				  }
				 
				  
				 break;
				 
			 case 3:
				 try {
					    				
					 exibirLista(ag.retornaListaContas());
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());					 
				 }
				 break;
				 
			 case 4:
				 try {
				 pesquisarConta(ag, sc);
				 }catch(NullPointerException e) {					
					 System.out.println(e.getMessage());
				 }catch(IllegalArgumentException e) {
					 System.out.println(e.getMessage());
				 }
				 
				 break;
			 case 5:/*
				 try {
				 removerConta(sc, ag);
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());				
				 }*/
				 break;
				 
			 case 6:/*
				    try {
				    	 alterarConta(sc, conta, ag);	
				    }catch(NullPointerException e) {
				    	System.out.println(" \n"+ e.getMessage());			
				    }	*/		 
					
				 break;
				 
			 case 7:/*
				 try {
				 atualizarConta(sc, conta, ag);
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());	
				 }*/
				 break;
				 
			 case 8:
				 try {
					 //realizarDeposito(sc, conta, ag);
				 }catch(IllegalArgumentException e) {
					 System.out.println(" \n"+ e.getMessage());	
				 }
				
				 break;
				 
			 case 9:
				 try {
					// realizarSaque(sc, conta, ag);
				 }catch(SaldoInsuficienteException e) {
					 System.out.println(" \n"+ e.getMessage());	
					 System.out.println(" \n"+ e.getMensagem());	 /*Somente no método saca da classe ContaPoupanca
					   é passado uma String no parametro do construtor  SaldoInsuficienteException. 
					   Criei um método personalizado getMensagem() para retornar essa mensagem */  
				 }
				
				 break;
				 
			 case 10:
				 try {
					 ordenarPeloNumeroConta(co,ag.retornaListaContas());
				 }catch(NullPointerException e) {
					 System.out.println(e.getMessage());
				 }				 
				
				 break;
				 
			 case 11:
				 try {
					 ordenarPeloTitular(co, ag.retornaListaContas());
				 }catch(NullPointerException e) {
					 System.out.println(e.getMessage());
				 }				 
				
				 
				 break;
				 
			 case 12:
				 try {
					 ordenarPeloSaldo(co, ag.retornaListaContas());
				 }catch(NullPointerException e) {
					 System.out.println(e.getMessage());
				 }				 
				
				 break;
				 
			 case 13:
				 
				 System.out.println(" \n Programa encerrado ! /n");
				
				 break;
				 
				 default:
					 System.out.println(" \n Opção invalida !");
					 break;
			 }			 
			
			 
		 }while(op !=13); 
		 
		
	}
	
	
	
	static int menu(Scanner sc) {
		int op=0;
		
		  System.out.println("    Menu de opçoes : \n");
		  
		  System.out.println("(1)- Criar Conta Corrente : \n"
		  		            +"(2)- Criar Conta Poupança : \n"
		  		            +"(3)- Exibir a lista de contas : \n"
		  		            +"(4)- Pesquisar Conta : \n"
		  		            +"(5)- Remover Conta: \n"
		  		            +"(6)- Alterar Conta no lista: \n" 
		  		            +"(7)- Atualizar Conta : \n"
		  		            +"(8)- Depositar : \n"
		  		            +"(9)- Sacar : \n"
		  		            +"(10)- Ordenar lista pelo numero da conta \n"
		  		            +"(11)- Ordenar lista pelo titular da conta \n"
		  		            +"(12)- Ordenar lista pelo saldo da conta \n"
		  		            +"(13)- sair");		  
		 op = sc.nextInt();
		  
		return op;
	}
	
public static void cadastrarConta(Conta conta, Scanner sc) {
		
		int numConta = (int)(Math.random()*1000)+1;	
		
		 conta.setNumero(numConta);
		
		 System.out.println("\n Entre com o nome do titular :");
		 conta.setNome(sc.next());   
		
		 System.out.println("\n Entre com o endereço do titular :");
		 conta.setEndereco(sc.next());	
		 
		 System.out.println("\n Entre com o valor do deposito :");
		 conta.deposita(sc.nextDouble());			 
		 exibirConta(conta);
		
	}

public static void pesquisarConta(Agencia ag, Scanner sc) {
	System.out.println("\n Entre com o numero da Conta : \n");
	Conta conta = ag.pesquisarContaPeloNumero(sc.nextInt());
	
	if(conta != null) {
		exibirConta(conta); 
	}else {
		System.out.println("\n Conta não encontrada ou inexistente ! : \n");
	}
}

 public static void ordenarPeloNumeroConta(CriterioOrdenacao co, List<Conta> listaContas) {
	listaContas.sort(co.compararPeloNumeroConta);
	exibirLista(listaContas);	
 }
 
 public static void ordenarPeloTitular(CriterioOrdenacao co, List<Conta> listaContas) {
		listaContas.sort(co.comparaPeloTitular);
		exibirLista(listaContas);	
	 }
 
 public static void ordenarPeloSaldo(CriterioOrdenacao co, List<Conta> listaContas) {
		listaContas.sort(co.comparaPeloSaldo);
		exibirLista(listaContas);	
	 }


 public static void exibirConta(Conta conta) {
	
	
	 System.out.println("\n Dados da Conta : \n");
	 
	 System.out.println("\n Numero : "+ conta.getNumero()+ "- Titular : "+ conta.getNome()+ " - Endereço : "+ conta.getEndereco()+ " - Saldo : "+ conta.getSaldo());
	}
	
	
	public static void exibirLista(List<Conta> listaConta) {
		
		for(Conta conta : listaConta) {
			System.out.println("\n Numero : "+ conta.getNumero()+ "- Titular : "+ conta.getNome()+ " - Endereço : "+ conta.getEndereco()+ " - Saldo : "+ conta.getSaldo());
			
		}
		 
	}

	

}






