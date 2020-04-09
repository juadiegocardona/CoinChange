package uniandes.algorithms.coinchange;

public class AlgoritmoRecursivo implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		
		int[] resp= new int[denominations.length];
		if(totalValue==0) {
			return resp;
		}
		
		if(totalValue-denominations[denominations.length]>0 && totalValue-denominations[denominations.length]>=denominations[denominations.length]) {
			totalValue-=denominations[denominations.length];
			calculateOptimalChange(totalValue, denominations);
			
		}
		else if(totalValue-denominations[denominations.length]>0 && totalValue-denominations[denominations.length]<denominations[denominations.length]) {
			totalValue-=denominations[denominations.length];
			//quitar el ultimo elemento de denominaciones
			int[] denom=recortarArreglo(denominations);
			calculateOptimalChange(totalValue, denom);
		}
			
		return resp;
	}
	
	public int[] recortarArreglo(int[] arreglo) {
		int[] recortado=new int[arreglo.length-1];
		
		for(int i=0;i<arreglo.length-2;i++) {
			recortado[i]=arreglo[i];
		}
		
		return recortado;
	}

}
