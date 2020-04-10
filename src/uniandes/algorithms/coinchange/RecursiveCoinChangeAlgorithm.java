package uniandes.algorithms.coinchange;

import java.util.ArrayList;

public class RecursiveCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int[]resp=new int[denominations.length];
		returnChange(totalValue, denominations, resp);
		return resp;
	}


	public int[] returnChange(int totalValue, int[] denominations,int[] monedas) {

		if(totalValue==0) {
			return monedas;
		}

		int c=0;
		for (int i=denominations.length-1;i>0;i--) {
			c=denominations[i];
			if((totalValue-c)>0) {
				int temporal=totalValue-c;
				monedas[i]+=1;
				return returnChange(temporal, denominations, monedas);
			}
		}
		return monedas;
	}



}
