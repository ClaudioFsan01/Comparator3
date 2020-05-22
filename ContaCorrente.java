
public class ContaCorrente extends Conta{
		
     
	public void deposita(double valor)
	{
		if(valor<0) {
			throw new IllegalArgumentException(" Voce tentou depositar um valor invalido na conta corrente !");
			
		}else {
			this.saldo += valor;
			System.out.println(" Deposito efetuado com sucesso na conta corrente no valor de : "+ valor);
		}
		
		
	}
		

	public void saca(double valor)
	{
		if(valor > this.saldo)
		{	
			throw new SaldoInsuficienteException(valor);		
		}
		else
		{
			this.saldo -= valor;
			
			System.out.println(" Saque efetuado com sucesso na conta corrente no valor de : "+ valor);
			
		}
		 
	}
	
	


}
