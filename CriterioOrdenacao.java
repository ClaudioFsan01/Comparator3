import java.util.Comparator;
public class CriterioOrdenacao {
	
	// implementando classes anonimas e seus criterios de comparação 
	
	
	
		// Classe anonima 1 
		Comparator<Conta> compararPeloNumeroConta = new Comparator<Conta>() {
			public int compare(Conta conta1, Conta conta2){
				
				 return Integer.compare(conta1.getNumero(), conta2.getNumero());  //Classe Integer implementa a interface Comparator
				
				/* ou
			    if(conta1.getNumero()< conta2.getNumero()) {
			    	return -1;
			    }else {
			    	if(conta1.getNumero()> conta2.getNumero()) {
			    		return 1;
			    	}else {
			    		return 0;
			    	}
			    }*/ 		    
			    
			}		
			
		};
		
		
		// Classe anonima 2
		Comparator<Conta> comparaPeloTitular = new Comparator<Conta>() {
			
			public int compare(Conta conta1, Conta conta2) {
				return conta1.getNome().compareTo(conta2.getNome());
			}
		};
		
		
		
		// Classe anonima 3
		Comparator<Conta> comparaPeloSaldo = new Comparator<Conta>() {
			
			public int compare(Conta conta1, Conta conta2) {
				return Double.compare(conta1.getSaldo(), conta2.getSaldo());
			}
			
		};
	
	
	
	
	

}
