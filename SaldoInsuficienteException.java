

public class SaldoInsuficienteException extends RuntimeException {
	/*RuntimeException é a exception mãe de todas as exceptions unchecked. 
	 Exemplo de exceção unchecked pois o compilador não checa se você está tratando essas exceções porque 
	tais problemas poderiam ser evitados pelo programador */
	
	/* Podemos transformar essa Exception de unchecked para checked, obrigando a quem chamar o método 
	  saca(double valor) na classe Conta a dar try-catch , ou throws ex:
	 
public class SaldoInsuficienteException extends Exception {
String mensagem;	
	SaldoInsuficienteException(String mensagem){
		this.mensagem = mensagem;
	}
	
}
*/
	
	/*
	 Quando estendemos uma classe, não herdamos seus construtores, mas podemos acessá-los através
da palavra chave super de dentro de um construtor. As exceções do Java possuem uma série de
construtores úteis para poder populá-las já com uma mensagem de erro.
*/
	
	
	
	
	String mensagem;
	
	public SaldoInsuficienteException(String mensagem){
		this.mensagem = mensagem;
	}
	
	public SaldoInsuficienteException(double valor){
	  System.out.println("Saldo insuficiente na conta corrente para sacar o valor :"+valor);
		
	}
	
	
	public String getMensagem() {
		return this.mensagem;
	}

}
