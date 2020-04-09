package uniandes.algorithms.coinchange;

public class AlgoritmoRecursivo implements CoinChangeAlgorithm {

	/**
	 * las denominaciones deben de estar de mayor a menor
	 * @param denominacion
	 * @param cantidad
	 * @return
	 */
	@Override
	
	
	
	public int[] calculateOptimalChange(int totalValue, int[] denominations) 
	{
		int[] resp=new int[denominations.length];
		int n=0;
		
		for(int i=0; i< denominations.length;i++)
		{
			n+=denominations[i];
		}
		int num=count(denominations,totalValue,n);
		
		for(int i=0;i<num;i++)
		{
			resp[i]+=1;
		}
		return resp;

	}
	
	 static int count( int denominations[], int totalValue, int n ) 
	    { 
	        if (n == 0) 
	            return 1; 
	          
	        if (n < 0) 
	            return 0; 
	      
	        if (totalValue <=0 && n >= 1) 
	            return 0; 
	       
	        return count( denominations, totalValue - 1, n ) + 
	               count( denominations, totalValue, n-denominations[totalValue-1] ); 
	    } 
}


