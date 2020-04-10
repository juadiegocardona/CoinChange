package uniandes.algorithms.coinchange;

public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm {

	/**
	 * las denominaciones deben de estar de mayor a menor
	 * @param denominacion
	 * @param cantidad
	 * @return
	 */
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		
				int[] resp=new int[denominations.length];
				int acumulado=0;
				int i=denominations.length-1;
				int moneda=0;
				while(acumulado<=totalValue && i>0) {
					moneda=denominations[i];
					if((acumulado+moneda) <= totalValue) {
						acumulado+=moneda;
						resp[i]+=1;
					}
					else {
						i--;
					}
				}
				return resp;
			}

}
