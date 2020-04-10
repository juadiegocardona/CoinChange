package uniandes.algorithms.coinchange;


public class RecursiveCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int[]resp=new int[denominations.length];
		returnChange(totalValue, denominations, resp);
		return resp;
	}


	public int[] returnChange(int totalValue, int[] denominations,int[]monedas) {
		int[]resp=new int[denominations.length];

		if(totalValue==0) {
			return monedas;
		}

		for (int i=denominations.length-1;i>=0;i--) {
			if((totalValue-denominations[i])>=0) {
				totalValue-=denominations[i];
				monedas[i]+=1;
				return returnChange(totalValue, denominations, monedas);
			}
		}

		return resp;
	}



}
