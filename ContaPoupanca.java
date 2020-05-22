
public class ContaPoupanca extends Conta{
		

	public void deposita(double valor)
	{
		if(valor<0) {
			throw new IllegalArgumentException(" Voce tentou depositar um valor invalido na conta poupança !");
			
		}else {
			this.saldo += valor;
			System.out.println(" Deposito efetuado com sucesso na conta poupança no valor de : "+ valor);
		}
		
		
	}
	
		
	/*  
	 A palavra chave throw, que está no imperativo, lança uma Exception . Isto é bem diferente de
throws , que está no presente do indicativo, e que apenas avisa da possibilidade daquele método lançála,
obrigando o outro método que vá utilizar deste de se preocupar com essa exceção em questão.
	*/
	
	/* Como a classe  SaldoInsuficienteException extends a classe RuntimeException e essa classe é a exception mãe de todas
	  as exceptions unchecked ,ou seja,  o compilador não checa se você está tratando essas exceções porque 
	tais problemas poderiam ser evitados pelo programador. 
	* Neste caso quem chama o método  saca(double valor) não é obrigado a inserir o try catch*/
	public void saca(double valor)
	{
		if(valor > this.saldo)
		{	
			throw new SaldoInsuficienteException(" Saldo insuficiente na conta poupança tente um valor menor");		
		}
		else
		{
			this.saldo -= valor;
			System.out.println(" Saque efetuado com sucesso na conta poupança no valor de : "+ valor);
			
		}
		 
	}
	
	
	



}
