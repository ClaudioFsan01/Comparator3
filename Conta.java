
public abstract class Conta  implements java.lang.Comparable<Conta>{// Classe Conta abstrata pois ela não pode ser instanciada pois não existe conta generica somente conta poupança e corrente
	 // quem for instanciar uma conta , obrigatoriamente deve instanciar a ContaCorrente ou ContaPoupança
	

	protected int numero;
	private String nome;		
	protected double saldo;
	protected String endereco;
	
	public void setNumero(int numero) {
		if(numero<0) {
			System.out.println("Inserir um numero inteiro maior que zero");
		}
		else {
			this.numero = numero;
		}
		
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNome(String nome) {
		if(nome != " " && nome != null) {
			this.nome = nome;
		}
		else {
			System.out.println(" Inserir um nome valido !");
		}
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEndereco(String endereco) {
		if(endereco != " " && endereco != null) {
			this.endereco = endereco;
			System.out.println(" Endereço inserido com sucesso !");
			
		}
		else {
			System.out.println(" Inserir um endereço valido !");
			}	
		
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int compareTo(Conta outraContra)
	{
		if(this.getSaldo() == outraContra.getSaldo()) {
			return 0; //se o objeto comparado for igual a este objeto
		}else {
			if(this.getSaldo() < outraContra.getSaldo()) {
				return -1; //se o saldo deste objeto for menor que o saldo do objeto dado
			}else {
				return 1;
			}	
		
	  }

   }
	
	
	/* Inserindo aqui o métodos abstratos deposita(double valor),  saca(double valor)
	  Isso faz com que as classes filhas  ContaCorrente e ContaPoupança obrigatoriamente reescrevam esses métodos cada uma com as 
	  suas peculiaridades. 
	  Nesse contexto não me foi conveniente criar uma interface que implemente esses metodos pois quero que uma referencia 
	  do tipo Conta acesse esses métodos que serão reecritos nas classes filhas ContaCorrente e ContaPoupança.
	  E tambem não me foi conveniente declarar essa classe Conta sendo do tipo interface pois quero que as classes filhas herdem sem ter que 
	  implementar os métodos acima pois em uma interface não se implementa o corpo (o que o método faz ou como faz uma determinada execução).
	  
	  Existe um recurso em Java que, em uma classe abstrata, podemos escrever que determinado método.
    será sempre escrito pelas classes filhas. Isto é, um método abstrato.
   Ele indica que todas as classes filhas (concretas, isto é, que não forem abstratas) devem reescrever
   esse método ou não compilarão. É como se você herdasse a responsabilidade de ter aquele método.*/
	
	public abstract void deposita(double valor);
	public abstract void saca(double valor);	
	
	


}
