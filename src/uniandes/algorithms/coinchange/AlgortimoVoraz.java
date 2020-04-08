package uniandes.algorithms.coinchange;

public class AlgortimoVoraz implements CoinChangeAlgorithm {

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
				int i=0;
				int moneda=0;
				while(acumulado<=totalValue) {
					moneda=denominations[i];
					if((acumulado+moneda) <= totalValue) {
						acumulado+=moneda;
						resp[i]+=1;
					}
					else {
						i++;
					}
				}
				return resp;
			}

}
