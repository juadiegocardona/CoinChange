package uniandes.algorithms.coinchange;

import java.util.Arrays;

public class AlgoritmoProgDinamica implements CoinChangeAlgorithm {

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
		long num=count(denominations,totalValue,n);
		
		for(int i=0;i<num;i++)
		{
			resp[i]+=1;
		}
		return resp;

	}
	
	 static long count(int denominations[], int totalValue, int n) 
	    { 
	        long[] table = new long[n+1]; 
	        Arrays.fill(table, 0); 
	        table[0] = 1; 
	        for (int i=0; i<totalValue; i++) 
	            for (int j=denominations[i]; j<=n; j++) 
	                table[j] += table[j-denominations[i]]; 
	        return table[n]; 
	    } 

}
